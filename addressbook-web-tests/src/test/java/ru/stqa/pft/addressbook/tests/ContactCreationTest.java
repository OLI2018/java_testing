package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.Contacts;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class ContactCreationTest extends TestBase {

  @Test
  public void testContactCreationTest() {

    Contacts before = app.contact().all();
    app.contact().addNew();
    ContactData contact = new ContactData()
            .withFirstName("David").withLastName("Gross").withMiddleName("Jr")
            .withNickName("Dave").withTitle("Mini Super").withCompany("Super Company")
            .withAddress("1234 200th WE apt123 City");
    app.contact().personalInfo(contact);
    app.contact().primaryContacts(new ContactData()
            .withHomePhone("111 111 11 11").withMobilePhone("222 222 22 22").withWorkPhone("333 333 33 33")
            .withFax("444 444 44 44").withEmail_1("test@test.com").withEmail_2("protest@protest.com")
            .withEmail_3("tester@tester.com").withHomePage("www.tester.com").withGroup("test1"), true);
    app.contact().secondaryContacts(new ContactData()
            .withAddress2("new nowhere").withPhone2(null).withNotes("no trespassing"));
    Contacts after = app.contact().all();
    assertThat(after.size(), equalTo(before.size() + 1));
    assertThat(after, equalTo(
            before.withAdded(contact.withId(after.stream().mapToInt((c) -> c.getId()).max().getAsInt()))));
  }
}
