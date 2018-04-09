package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.EmailsData;
import ru.stqa.pft.addressbook.model.PersonalInfoData;
import ru.stqa.pft.addressbook.model.PhonesData;
import ru.stqa.pft.addressbook.model.SecondaryData;

public class ContactModificationTests extends TestBase {

  @Test
  public void testContactModification() {

    app.getContactNavigationHelper().goHomePage();
    app.getContactNavigationHelper().selectContact();
    app.getContactNavigationHelper().clickOnEdit();

    app.getPrimaryContactsHelper().personalInfo(new PersonalInfoData("Bob", "J", "White", "Puppy", "Manager", "SuperCompany", "Somewhere"));
    app.getPrimaryContactsHelper().phones(new PhonesData("000 000 00 00", "111 111 11 11", "222 222 22 22", "999 999 99 99"));
    app.getPrimaryContactsHelper().emailsAndHomePage(new EmailsData("firstaemail@gmail.com", "secondemail@gmail.com", "thirdemail@gmail.com", "anotheremail@gmail.com"));
    app.getSecondaryContactsHelper().secondaryContacts(new SecondaryData("Any Street", "456 789 00 00", "DOGS!!!!"));

    app.getContactNavigationHelper().updateEditedContact();

  }

}
