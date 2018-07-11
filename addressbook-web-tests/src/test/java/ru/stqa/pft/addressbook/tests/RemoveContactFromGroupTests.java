package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.Contacts;
import ru.stqa.pft.addressbook.model.GroupData;
import ru.stqa.pft.addressbook.model.Groups;

import java.util.Set;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class RemoveContactFromGroupTests extends TestBase {

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

    if (app.db().contacts().iterator().next().getGroups().size() == 0) { //add contact to group, if there are no
      app.contact().addInSelectGroup(app.db().contacts().iterator().next().getId(), app.db().groups().iterator().next().getId());
      app.goTo().gotoHomePage();
    }
  }

  @Test

  public void testDeleteContactFromGroup() {

    Groups group = app.db().groups();
    Contacts contacts = app.db().contacts();
    ContactData contact = contacts.iterator().next();
    int id = contact.getId();
    Set<GroupData> groupOfContactSet = contact.getGroups();

    if (!groupOfContactSet.isEmpty()) {
      int index = groupOfContactSet.iterator().next().getId();
      app.contact().deleteFromSelectedGroup(id, index);
      app.goTo().gotoHomePage();
    }

    Contacts contacts1 = app.db().contacts();
    ContactData contactnew = contacts1.stream().filter((c) -> c.equals(contact)).findFirst().get();
    Set<GroupData> groupOfContactSet1 = contactnew.getGroups();
    assertThat(groupOfContactSet1.size(), equalTo(groupOfContactSet.size() - 1));

    GroupData groupData2 = groupOfContactSet.stream().filter(groupData -> !(groupOfContactSet1.contains(groupData))).findFirst().get();
    assertThat(groupOfContactSet1, equalTo(((Groups) groupOfContactSet).without(groupData2)));
  }
}
