package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

import java.util.List;

public class ContactDeletionTests extends TestBase {

  @BeforeMethod
  public void ensurePreconditions() {
    app.goTo().gotoHomePage();
    if (app.contact().list().size() == 0) {
      app.contact().addNew();
      app.contact().personalInfo(new ContactData("Tom", "Junior", "Fox", "Foxxy", "QA Engineer", "XYZ Company", "Somewhere"));
      app.contact().primaryContacts(new ContactData("123 123 11 11", "456 456 56 56", "789 789 99 99", "369 369 69 69", "test@test.com", "protest@protest.com", "tester@tester.com", "www.tester.com", "test1"), true);
      app.contact().secondaryContacts(new ContactData("new nowhere", "741 741 14 14", "dont ring"));
    }
  }

  @Test
  public void testContactDeletion() throws InterruptedException {

    List<ContactData> before = app.contact().list();

    app.contact().selectContact(before.size() - 1);
    app.contact().deleteContact();
    app.contact().clickOnAlert();
    app.goTo().gotoHomePage();

    List<ContactData> after = app.contact().list();

    Assert.assertEquals(after.size(), before.size() - 1);

    before.remove(before.size() - 1);
    Assert.assertEquals(before, after);
  }
}



