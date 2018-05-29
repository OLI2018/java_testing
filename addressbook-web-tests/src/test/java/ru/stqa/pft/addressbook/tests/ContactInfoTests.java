package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

import java.util.Arrays;
import java.util.stream.Collectors;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class ContactInfoTests extends TestBase {


  @BeforeMethod
  public void ensurePreconditionsContactInfoTest() {
    app.goTo().gotoHomePage();
    if (app.db().contacts().size() == 0) {
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
  public void testContactPhones() {

    ContactData contact = app.contact().all().iterator().next();
    ContactData contactInfoFromEditForm = app.contact().infoFormEditForm(contact);
    assertThat(contact.getAllPhones(), equalTo(mergePhones(contactInfoFromEditForm)));
  }

  private String mergePhones(ContactData contact) {
    return Arrays.asList(contact.getHomePhone(), contact.getMobilePhone(), contact.getWorkPhone())
            .stream().filter((s) -> !s.equals(""))
            .map(ContactInfoTests::cleaned)
            .collect(Collectors.joining("\n"));
  }

  public static String cleaned(String phone) {
    return phone.replaceAll("\\s", "").replaceAll("[-()]", "");
  }

  @Test
  public void testContactEmails() {

    ContactData contact = app.contact().all().iterator().next();
    ContactData contactInfoFromEditForm = app.contact().infoFormEditForm(contact);
    assertThat(contact.getAllEmails(), equalTo(mergeEmails(contactInfoFromEditForm)));
  }

  private static String mergeEmails(ContactData contact) {
    return Arrays.asList(contact.getEmail1(), contact.getEmail2(), contact.getEmail3())
            .stream().filter((s) -> !s.equals(""))
            .collect(Collectors.joining("\n"));
  }

  @Test
  public void testContactAddress() {

    ContactData contact = app.contact().all().iterator().next();
    ContactData contactInfoFromEditForm = app.contact().infoFormEditForm(contact);
    assertThat(contact.getAddressContact(), equalTo(contactInfoFromEditForm.getAddressContact()));
  }
}


