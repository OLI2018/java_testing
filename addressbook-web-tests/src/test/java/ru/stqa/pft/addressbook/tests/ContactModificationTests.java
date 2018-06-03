package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.Contacts;
import ru.stqa.pft.addressbook.model.GroupData;
import ru.stqa.pft.addressbook.model.Groups;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.testng.Assert.assertEquals;

public class ContactModificationTests extends TestBase {

  @BeforeMethod
  public void ensurePreconditions() {

    app.goTo().gotoHomePage();
    if (app.db().contacts().size() == 0) { //if there is no contact, create new contact
      if (app.db().groups().size() == 0) { // if there is no group, create new group
        app.goTo().groupPage();
        app.group().create(new GroupData().withName("newGroupModification"));
      }
      Groups groups = app.db().groups();

      app.contact().addNew();
      app.contact().personalInfo(new ContactData()
              .withFirstName("New").withLastName("Contact").withMiddleName("If")
              .withNickName("No").withTitle("No Title").withCompany("remote position")
              .withAddress("0987 123 St W Road Town"));
      app.contact().primaryContacts(new ContactData()
              .withHomePhone("4444444444").withMobilePhone("6666666666").withWorkPhone("8888888888")
              .withFax("0000000000").withEmail_1("mail1@test.com").withEmail_2("mail2t@protest.com")
              .withEmail_3("mail3@tester.com").withHomePage("www.tester.com").inGroup(groups.iterator().next()), true);
      app.contact().secondaryContacts(new ContactData()
              .withAddress2("Moscow").withPhone2(null).withNotes("Super Buzzyyyyy"));
    }
  }

  @Test
  public void testContactModification() {
    Contacts before = app.db().contacts();
    ContactData modifiedContact = before.iterator().next();
    ContactData contact = new ContactData()
            .withId(modifiedContact.getId()).withFirstName("ZERO").withLastName("BIG")
            .withMiddleName("Daddy").withNickName("Red").withTitle("VP")
            .withCompany("NoName").withAddress("NoAddress");
    app.contact().modifyTest(contact);
    app.contact().personalInfo(contact);
    app.contact().primaryContacts(new ContactData()
            .withHomePhone("8888888888").withMobilePhone("8888888888").withWorkPhone("8888888888")
            .withFax("8888888888").withEmail_1("mail_1@mail.com").withEmail_2("mail_2@mail.com")
            .withEmail_3("mail_3@mail.com").withHomePage("NoPage"), false);
    app.contact().secondaryContacts(new ContactData()
            .withAddress2("NoWhere").withPhone2(null).withNotes("Out of order"));
    app.contact().updateEditedContact();
    Contacts after = app.db().contacts();
    assertEquals(after.size(), before.size());
    assertThat(after, equalTo(before.without(modifiedContact).withAdded(contact)));
    verifyContactlistInUi();
  }
}
