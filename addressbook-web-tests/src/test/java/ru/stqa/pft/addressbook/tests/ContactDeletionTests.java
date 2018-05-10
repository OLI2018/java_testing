package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.Contacts;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.testng.Assert.assertEquals;

public class ContactDeletionTests extends TestBase {

  @BeforeMethod
  public void ensurePreconditions() {
    app.goTo().gotoHomePage();
    if (app.contact().all().size() == 0) {
      app.contact().addNew();
      app.contact().personalInfo(new ContactData()
              .withFirstName("David").withLastName("Gross").withMiddleName("Jr")
              .withNickName("Dave").withTitle("Mini Super").withCompany("Super Company")
              .withAddress("1234 200th WE apt123 City"));
     app.contact().primaryContacts(new ContactData()
             .withHomePhone("1111111111").withMobilePhone("2222222222").withWorkPhone("3333333333")
             .withFax("4444444444").withEmail_1("test@test.com").withEmail_2("protest@protest.com")
             .withEmail_3("tester@tester.com").withHomePage("www.tester.com").withGroup("test1"), true);
      app.contact().secondaryContacts(new ContactData()
              .withAddress2("new nowhere").withPhone2(null).withNotes("no trespassing"));
    }
  }

  @Test
  public void testContactDeletion() throws InterruptedException {
    Contacts before = app.contact().all();
    ContactData deletedContact = before.iterator().next();
    app.contact().delete(deletedContact);
    app.goTo().gotoHomePage();
    Contacts after = app.contact().all();
    assertEquals(after.size(), before.size() - 1);
    assertThat(after, equalTo(before.without(deletedContact)));
  }
}







