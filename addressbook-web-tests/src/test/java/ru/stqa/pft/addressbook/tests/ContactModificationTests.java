package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

public class ContactModificationTests extends TestBase {

  @Test
  public void testContactModification() {

    app.getNavigationHelper().gotoHomePage();

    if (!app.getContactHelper().isThereAContact()) {
      app.getContactHelper().addNew();
      app.getContactHelper().personalInfo(new ContactData("Tom", "Junior", "Fox", "Foxxy", "QA Engineer", "XYZ Company", "Somewhere"));
      app.getContactHelper().primaryContacts(new ContactData("123 123 11 11", "456 456 56 56", "789 789 99 99", "369 369 69 69", "test@test.com", "protest@protest.com", "tester@tester.com", "www.tester.com", "test1"), true);
      app.getContactHelper().secondaryContacts(new ContactData("new nowhere", "741 741 14 14", "dont ring"));
    }

    app.getContactHelper().selectContact();
    app.getContactHelper().clickOnEdit();

    app.getContactHelper().personalInfo(new ContactData("David", "W", "Bush", "N/A", "Manager", "SuperCompany", "Somewhere"));
    app.getContactHelper().primaryContacts(new ContactData("999 999 99 99", "888 888 88 88", "777 777 77 77", "666 666 66 66", "noemail@noemail.com", "no@email.com", "1234@yahoo.com", "www.nohomepageatall.com", null), false);
    app.getContactHelper().secondaryContacts(new ContactData("Any Street", "000 000 00 00", "be aware of dogs!"));

    app.getContactHelper().updateEditedContact();

  }

}
