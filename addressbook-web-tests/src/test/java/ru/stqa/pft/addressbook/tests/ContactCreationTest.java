package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

public class ContactCreationTest extends TestBase {

  @Test
  public void testContactCreationTest() {
    app.getContactHelper().addNew();
    app.getContactHelper().personalInfo(new ContactData("Tom", "Junior", "Fox", "Foxxy", "QA Engineer", "XYZ Company", "Somewhere"));
    app.getContactHelper().primaryContacts(new ContactData("123 123 11 11", "456 456 56 56", "789 789 99 99", "369 369 69 69", "test@test.com", "protest@protest.com", "tester@tester.com", "www.tester.com", "test1"), true);
    app.getContactHelper().secondaryContacts(new ContactData("new nowhere", "741 741 14 14", "dont ring"));
  }
}
