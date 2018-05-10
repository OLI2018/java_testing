package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class ContactPhoneTests extends TestBase {

  @Test
  public void testContactPhones() {
    app.goTo().gotoHomePage();
    ContactData contact = app.contact().all().iterator().next();
    ContactData contactInfoFromEditForm = app.contact().infoFormEditForm(contact);
    assertThat(contact.getHome(), equalTo(clenaed(contactInfoFromEditForm.getHome())));
    assertThat(contact.getMobile(), equalTo(clenaed(contactInfoFromEditForm.getMobile())));
    assertThat(contact.getWork(), equalTo(clenaed(contactInfoFromEditForm.getWork())));
  }

  public String clenaed(String phone) {
    return phone.replaceAll("\\s", "").replaceAll("[-()]", "");
  }
}
