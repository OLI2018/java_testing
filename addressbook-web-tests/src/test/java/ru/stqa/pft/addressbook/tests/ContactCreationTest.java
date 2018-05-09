package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

import java.util.Set;

public class ContactCreationTest extends TestBase {

  @Test
  public void testContactCreationTest() {

    Set<ContactData> before = app.contact().all();
    app.contact().addNew();
    ContactData contact = new ContactData()
            .withFirstName("first").withLastName("last").withMiddleName("middle")
            .withNickName("nick").withTitle("QA Engineer").withCompany("XYZ Company")
            .withAddress("Somewhere");
    app.contact().personalInfo(contact);
    app.contact().primaryContacts(new ContactData()
            .withHome("123 123 11 11").withMobile("456 456 56 56").withWork("789 789 99 99")
            .withFax("369 369 69 69").withEmail1("test@test.com").withEmail2("protest@protest.com")
            .withEmail3("tester@tester.com").withHomePage("www.tester.com").withGroup("test1"), true);
    app.contact().secondaryContacts(new ContactData()
            .withAddress2("new nowhere").withPhone2("741 741 14 14").withNotes("dont ring"));
    Set<ContactData> after = app.contact().all();
    Assert.assertEquals(after.size(), before.size() + 1);
    contact.withId(after.stream().mapToInt((c) -> c.getId()).max().getAsInt());
    before.add(contact);
    Assert.assertEquals(before, after);
  }
}
