package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

import java.util.Comparator;
import java.util.List;

public class ContactModificationTests extends TestBase {

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
  public void testContactModification() {


    List<ContactData> before = app.contact().list();
    int index = before.size() - 1;

    app.contact().modifyTest(index);

    ContactData contact = new ContactData()
            .withId(before.get(index).getId()).withFirstName("sssss").withLastName("ssssssss")
            .withMiddleName("sssssss").withNickName("sssss/A").withTitle("ssss")
            .withCompany("sssss").withAddress("sssss");

    app.contact().personalInfo(contact);

    app.contact().primaryContacts(new ContactData().withHome("0000000000000")
            .withMobile("0000000000000").withWork("0000000000000").withFax("0000000000000").withEmail1("0000000000000")
            .withEmail2("0000000000000").withEmail3("0000000000000").withHomePage("0000000000000"), false);

    app.contact().secondaryContacts(new ContactData()
            .withAddress2("zzzzzzzz").withPhone2("zzzzzzzz").withNotes("zzzzzzzz"));

    app.contact().updateEditedContact();

    List<ContactData> after = app.contact().list();
    Assert.assertEquals(after.size(), before.size());
    before.remove(index);
    before.add(contact);
    Comparator<? super ContactData> byId = (c1, c2) -> Integer.compare(c1.getId(), c2.getId());
    before.sort(byId);
    after.sort(byId);
    Assert.assertEquals(before, after);

  }

}
