package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;

public class ContactDeletionTests extends TestBase {

  @Test
  public void testContactDeletion() {

    app.getContactNavigationHelper().goHomePage();
    app.getContactNavigationHelper().selectContact();
    app.getContactNavigationHelper().deleteContact();
    app.getContactNavigationHelper().clickOnAlert();
    app.getContactNavigationHelper().goHomePage();

  }
}
