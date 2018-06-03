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

public class ContactDeletionTests extends TestBase {

  @BeforeMethod
  public void ensurePreconditions() {
    app.goTo().gotoHomePage();
    if (app.db().contacts().size() == 0) { //if there is no contact, create new contact
      if (app.db().groups().size() == 0) { // if there is no group, create new group
        app.goTo().groupPage();
        app.group().create(new GroupData().withName("newGroupDeletion"));
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
  public void testContactDeletion() throws InterruptedException {
    Contacts before = app.db().contacts();
    ContactData deletedContact = before.iterator().next();
    app.contact().delete(deletedContact);
    app.goTo().gotoHomePage();
    Contacts after = app.db().contacts();
    assertEquals(after.size(), before.size() - 1);
    assertThat(after, equalTo(before.without(deletedContact)));
    verifyContactlistInUi();
  }
}







