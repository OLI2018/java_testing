package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.Contacts;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.testng.Assert.assertEquals;

public class ContactModificationTests extends TestBase {

  @BeforeMethod
  public void ensurePreconditions() {
    app.goTo().gotoHomePage();
    if (app.contact().all().size() == 0) {
      app.contact().addNew();
      app.contact().personalInfo(new ContactData()
              .withFirstName("Bob").withLastName("Logan").withMiddleName("V")
              .withNickName("BigB").withTitle("No Title").withCompany("remote position")
              .withAddress("0987 123 St W Road Town"));

      app.contact().primaryContacts(new ContactData()
              .withHome("444 444 44 44").withMobile("666 666 66 66").withWork("888 888 88 88")
              .withFax("000 000 00 00").withEmail1("mail1@test.com").withEmail2("mail2t@protest.com")
              .withEmail3("mail3@tester.com").withHomePage("www.tester.com").withGroup("test1"), true);

      app.contact().secondaryContacts(new ContactData()
              .withAddress2("Moscow").withPhone2("555 666 77 88").withNotes("Super Buzzyyyyy"));
    }
  }

  @Test
  public void testContactModification() {

    Contacts before = app.contact().all();
    ContactData modifiedContact = before.iterator().next();
    ContactData contact = new ContactData()
            .withId(modifiedContact.getId()).withFirstName("Tom").withLastName("Ross")
            .withMiddleName("Wally").withNickName("Rose").withTitle("VP")
            .withCompany("NoName").withAddress("NoAddress");
    app.contact().modifyTest(contact);
    app.contact().personalInfo(contact);
    app.contact().primaryContacts(new ContactData()
            .withHome("888 888 88 88").withMobile("888 888 88 88").withWork("888 888 88 88")
            .withFax("888 888 88 88").withEmail1("mail_1@mail.com").withEmail2("mail_2@mail.com")
            .withEmail3("mail_3@mail.com").withHomePage("NoPage"), false);
    app.contact().secondaryContacts(new ContactData()
            .withAddress2("NoWhere").withPhone2("123 456 78 90").withNotes("Out of order"));
    app.contact().updateEditedContact();
    Contacts after = app.contact().all();
    assertEquals(after.size(), before.size());
    assertThat(after, equalTo(before.without(modifiedContact).withAdded(contact)));
  }
}
