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

public class AddContactToGroupTests extends TestBase {

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
  }

  @Test
  public void testAddingContactToGroup() {

    Groups group = app.db().groups();                                             //get list of all groups from db
    Contacts contacts = app.db().contacts();                                      //get list of contacts from db
    ContactData contact = contacts.iterator().next();                             //get any contact from all contacts
    int id = contact.getId();                                                     //get ID of that contact
    Set<GroupData> groupOfContactSet = contact.getGroups();                       //contact belongs to that list of groups

    if (groupOfContactSet.size() < group.size()) {                                //if groupOfContactSet is less than number of all groups
      group.removeAll(groupOfContactSet);                                         //delete groupOfContactSet groups
      int index = group.iterator().next().getId();                                //get any group from the rest/available groups
      app.contact().addInSelectGroup(id, index);                                  //pass contact ID and group ID to method to add contact to selected group
      app.goTo().gotoHomePage();

    } else {
      GroupData newGroup = new GroupData();                                                     //newGroup object created, if contact belongs to all groups
      app.goTo().groupPage();                                                                   //create new group
      long now = System.currentTimeMillis();                                                    //get current timestamp
      app.group().create(newGroup.withName(String.format("newGroup%s", now)));                  //create new group with timestamp name
      int index = app.db().groups().stream().mapToInt(g -> g.getId()).max().getAsInt();         //get ID of newly created group
      app.goTo().gotoHomePage();
      app.contact().addInSelectGroup(id, index);                                                //pass contact ID and group ID to method
      app.goTo().gotoHomePage();
    }

    Contacts contacts1 = app.db().contacts();                                                   //get list of modified contacts from db
    ContactData contactnew = contacts1.stream()
            .filter((c) -> c.equals(contact)).findFirst().get();                                //in modified contact list, find contact that is equal to original contact
    Set<GroupData> groupOfContactSet1 = contactnew.getGroups();                                 //get list of groups to which contact belongs to, + 1 group
    assertThat(groupOfContactSet1.size(), equalTo(groupOfContactSet.size() + 1));       //compare list of groups before and after

    GroupData groupData1 = groupOfContactSet1
            .stream().filter(groupData -> !(groupOfContactSet.contains(groupData)))
            .findFirst().get();
//    groupOfContactSet.add(groupData1); delete
    assertThat(groupOfContactSet1, equalTo(((Groups) groupOfContactSet).withAdded(groupData1)));
  }
}

