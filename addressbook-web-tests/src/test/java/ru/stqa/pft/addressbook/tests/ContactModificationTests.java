package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

import java.util.Comparator;
import java.util.List;

public class ContactModificationTests extends TestBase {

  @BeforeMethod
  public void ensurePreconditions () {
    app.goTo().gotoHomePage();
    if (app.contact().list().size() == 0) {
      app.contact().addNew();
      app.contact().personalInfo(new ContactData("Tom", "Junior", "Fox", "Foxxy", "QA Engineer", "XYZ Company", "Somewhere"));
      app.contact().primaryContacts(new ContactData("123 123 11 11", "456 456 56 56", "789 789 99 99", "369 369 69 69", "test@test.com", "protest@protest.com", "tester@tester.com", "www.tester.com", "test1"), true);
      app.contact().secondaryContacts(new ContactData("new nowhere", "741 741 14 14", "dont ring"));
    }
  }

  @Test
  public void testContactModification() {

    List<ContactData> before = app.contact().list();
    app.contact().selectContact(before.size() - 1);
    app.contact().clickOnEdit(before.size() + 1);
    ContactData contact = new ContactData(before.get(before.size() - 1).getId(), "11111", "22222", "33333", "N/A", "Manager", "SuperCompany", "Somewhere");
    app.contact().personalInfo(contact);
    app.contact().primaryContacts(new ContactData("999 999 99 99", "888 888 88 88", "777 777 77 77", "666 666 66 66", "noemail@noemail.com", "no@email.com", "1234@yahoo.com", "www.nohomepageatall.com", null), false);
    app.contact().secondaryContacts(new ContactData("Any Street", "000 000 00 00", "be aware of dogs!"));
    app.contact().updateEditedContact();
    List<ContactData> after = app.contact().list();
    Assert.assertEquals(after.size(), before.size());
    before.remove(before.size() - 1);
    before.add(contact);
    Comparator<? super ContactData> byId = (c1, c2) -> Integer.compare(c1.getId(), c2.getId());
    before.sort(byId);
    after.sort(byId);
    Assert.assertEquals(before, after);
  }
}
