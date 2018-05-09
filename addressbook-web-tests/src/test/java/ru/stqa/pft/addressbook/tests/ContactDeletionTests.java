package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

import java.util.List;
import java.util.Set;

public class ContactDeletionTests extends TestBase {

  @BeforeMethod
  public void ensurePreconditions() {
    app.goTo().gotoHomePage();
    if (app.contact().list().size() == 0) {
      app.contact().addNew();
      app.contact().personalInfo(new ContactData()
              .withFirstName("qwert").withLastName("ddd").withMiddleName("fff").withNickName("gg")
              .withTitle("QA Engineer").withCompany("XYZ Company").withAddress("Somewhere"));

     app.contact().primaryContacts(new ContactData()
              .withHome("123 123 11 11").withMobile("456 456 56 56").withWork("789 789 99 99").withFax("369 369 69 69")
              .withEmail1("test@test.com").withEmail2("protest@protest.com").withEmail3("tester@tester.com")
              .withHomePage("www.tester.com").withGroup("test1"), true);

      app.contact().secondaryContacts(new ContactData().withAddress2("new nowhere").withPhone2("741 741 14 14").withNotes("dont ring"));
    }
  }

  @Test
  public void testContactDeletion() throws InterruptedException {

    Set<ContactData> before = app.contact().all();
    ContactData deletedContact = before.iterator().next();

//    int index = before.size() - 1;

    app.contact().delete(deletedContact);
    app.goTo().gotoHomePage();
    Set<ContactData> after = app.contact().all();
    Assert.assertEquals(after.size(), before.size() - 1);

    before.remove(deletedContact);
    Assert.assertEquals(before, after);
  }
}







