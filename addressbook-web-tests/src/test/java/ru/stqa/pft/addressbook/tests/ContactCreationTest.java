package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.EmailsData;
import ru.stqa.pft.addressbook.model.PersonalInfoData;
import ru.stqa.pft.addressbook.model.PhonesData;

public class ContactCreationTest extends TestBase {

  @Test
  public void testContactCreationTest() {
    app.getAddNewContactCreationHelper().addNew();
    app.getPrimaryContactsHelper().personalInfo(new PersonalInfoData("Petr", "Petrovich", "Petrov", "Pupa", "QA Engineer", "Super Puper Company", "1234 Google St SE, London, CA, 98208"));
    app.getPrimaryContactsHelper().phones(new PhonesData("123 456 78 99", "321 432 54 76 ", "456 431 66 66", "333 333 33 33"));
    app.getPrimaryContactsHelper().emailsAndHomePage(new EmailsData("test@test.com", "lomn@google.com", "petrpetr@yahoo.com", "www.homepage.com"));
    app.getSecondaryContactsHelper().secondaryContacts();
  }

}