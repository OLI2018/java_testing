package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

public class ContactModificationTests extends TestBase {

  @Test
  public void testContactModification() {

    app.getContactHelper().goHomePage();
    app.getContactHelper().selectContact();
    app.getContactHelper().clickOnEdit();

    app.getContactHelper().personalInfo(new ContactData("David", "W", "Bush", "N/A", "Manager", "SuperCompany", "Somewhere"));
    app.getContactHelper().primaryContacts(new ContactData("999 999 99 99", "888 888 88 88", "777 777 77 77", "666 666 66 66", "noemail@noemail.com", "no@email.com", "1234@yahoo.com", "www.nohomepageatall.com"));
    app.getContactHelper().secondaryContacts(new ContactData("Any Street", "000 000 00 00", "be aware of dogs!"));
    app.getContactHelper().updateEditedContact();

  }

}
