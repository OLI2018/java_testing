package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

import java.util.Comparator;
import java.util.List;

public class ContactCreationTest extends TestBase {

  @Test
  public void testContactCreationTest() {

    List<ContactData> before = app.contact().list();

    app.contact().addNew();

    ContactData contact = new ContactData("Tom", "Junior", "Fox", "Foxxy", "QA Engineer", "XYZ Company", "Somewhere");

    app.contact().personalInfo(contact);

    app.contact().primaryContacts(new ContactData("123 123 11 11", "456 456 56 56", "789 789 99 99", "369 369 69 69", "test@test.com", "protest@protest.com", "tester@tester.com", "www.tester.com", "test1"), true);
    app.contact().secondaryContacts(new ContactData("new nowhere", "741 741 14 14", "dont ring"));

    List<ContactData> after = app.contact().list();
    Assert.assertEquals(after.size(), before.size() + 1);

    before.add(contact);
    Comparator<? super ContactData> byId = (c1, c2) -> Integer.compare(c1.getId(), c2.getId());
    before.sort(byId);
    after.sort(byId);
    Assert.assertEquals(before, after);
  }
}
