package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

import java.util.Comparator;
import java.util.List;

public class ContactModificationTests extends TestBase {

  @BeforeMethod
  public void ensurePreconditions() {
    app.goTo().gotoHomePage();
    if (app.contact().list().size() == 0) {
      app.contact().addNew();
      app.contact().personalInfo(new ContactData()
              .withFirstName("qwert").withLastName("ddd").withMiddleName("fff").withNickName("gg")
              .withTitle("QA Engineer").withCompany("XYZ Company").withAddress("Somewhere"));

      app.contact().primaryContacts(new ContactData()
              .withHome("123 123 11 11").withMobile("456 456 56 56").withWork("789 789 99 99").withFax("369 369 69 69")
              .withEmail1("test@test.com").withEmail2("protest@protest.com").withEmail3("tester@tester.com")
              .withHomePage("www.tester.com").withGroup("test1"), true);

      app.contact().secondaryContacts(new ContactData().withAddress2("new nowhere").withPhone2("741 741 14 14").withNotes("dont ring"));
    }
  }

  @Test
  public void testContactModification() {

    List<ContactData> before = app.contact().list();
    int index = before.size() - 1;

    app.contact().selectContact(index);
    app.contact().clickOnEdit(before.size() + 1);
    ContactData contact = new ContactData()
            .withId(before.get(index).getId()).withFirstName("oooo").withLastName("ppppp")
            .withMiddleName("iiii").withNickName("N/A").withTitle("Manager")
            .withCompany("SuperCompany").withAddress("Somewhere");

    app.contact().personalInfo(contact);
    app.contact().primaryContacts(new ContactData().withHome("999 999 99 99")
            .withMobile("888 888 88 88").withWork("777 777 77 77").withFax("666 666 66 66").withEmail1("noemail@noemail.com")
            .withEmail2("no@email.com").withEmail3("1234@yahoo.com").withHomePage("www.nohomepageatall.com"), false);

    app.contact().secondaryContacts(new ContactData()
            .withAddress2("Any Street").withPhone2("000 000 00 00").withNotes("be aware of dogs!"));

    app.contact().updateEditedContact();
    List<ContactData> after = app.contact().list();
    Assert.assertEquals(after.size(), before.size());
    before.remove(index);
    before.add(contact);
    Comparator<? super ContactData> byId = (c1, c2) -> Integer.compare(c1.getId(), c2.getId());
    before.sort(byId);
    after.sort(byId);
    Assert.assertEquals(before, after);
  }
}
