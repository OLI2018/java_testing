package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

import java.util.Set;

public class ContactModificationTests extends TestBase {

  @BeforeMethod
  public void ensurePreconditions() {
    app.goTo().gotoHomePage();
    if (app.contact().all().size() == 0) {
      app.contact().addNew();
      app.contact().personalInfo(new ContactData()
              .withFirstName("qwert").withLastName("ddd").withMiddleName("fff")
              .withNickName("gg").withTitle("QA Engineer").withCompany("XYZ Company")
              .withAddress("Somewhere"));

      app.contact().primaryContacts(new ContactData()
              .withHome("123 123 11 11").withMobile("456 456 56 56").withWork("789 789 99 99")
              .withFax("369 369 69 69").withEmail1("test@test.com").withEmail2("protest@protest.com")
              .withEmail3("tester@tester.com").withHomePage("www.tester.com").withGroup("test1"), true);

      app.contact().secondaryContacts(new ContactData()
              .withAddress2("new nowhere").withPhone2("741 741 14 14").withNotes("don't ring"));
    }
  }

  @Test
  public void testContactModification() {

    Set<ContactData> before = app.contact().all();
    ContactData modifiedContact = before.iterator().next();
    ContactData contact = new ContactData()
            .withId(modifiedContact.getId()).withFirstName("sssss").withLastName("ssssssss")
            .withMiddleName("sssssss").withNickName("sssss/A").withTitle("ssss")
            .withCompany("sssss").withAddress("sssss");
    app.contact().modifyTest(contact);
    app.contact().personalInfo(contact);
    app.contact().primaryContacts(new ContactData()
            .withHome("0000000000000").withMobile("0000000000000").withWork("0000000000000")
            .withFax("0000000000000").withEmail1("0000000000000").withEmail2("0000000000000")
            .withEmail3("0000000000000").withHomePage("0000000000000"), false);
    app.contact().secondaryContacts(new ContactData()
            .withAddress2("zzzzzzzz").withPhone2("zzzzzzzz").withNotes("zzzzzzzz"));
    app.contact().updateEditedContact();
    Set<ContactData> after = app.contact().all();
    Assert.assertEquals(after.size(), before.size());
    before.remove(modifiedContact);
    before.add(contact);
    Assert.assertEquals(before, after);
  }
}
