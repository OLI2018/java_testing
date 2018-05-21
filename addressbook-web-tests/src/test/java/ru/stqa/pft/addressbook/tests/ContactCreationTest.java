package ru.stqa.pft.addressbook.tests;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.Contacts;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class ContactCreationTest extends TestBase {

  @DataProvider
  public Iterator<Object[]> validContactsFromJson() throws IOException {
    BufferedReader reader = new BufferedReader(new FileReader(new File("src/test/resources/contacts.json")));
    String json = "";
    String line = reader.readLine();
    while (line != null) {
      json += line;
      line = reader.readLine();
    }
    Gson gson = new Gson();
    List<ContactData> contacts = gson.fromJson(json, new TypeToken<List<ContactData>>() {
    }.getType()); //List<ContactData>.class
    return contacts.stream().map((g) -> new Object[]{g}).collect(Collectors.toList()).iterator();
  }

  @Test(dataProvider = "validContactsFromJson")
  public void testContactCreationTest(ContactData contact) {

    Contacts before = app.contact().all();
    app.contact().addNew();
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

  @Test(enabled = false)
  public void testCurrentDir() {
    File currentDir = new File(".");
    currentDir.getAbsolutePath();
    System.out.println(currentDir.getAbsoluteFile());
    File photo = new File("src/test/resources/contacts.json");
    System.out.println(photo.getAbsoluteFile());
    System.out.println(photo.exists());
  }
}
