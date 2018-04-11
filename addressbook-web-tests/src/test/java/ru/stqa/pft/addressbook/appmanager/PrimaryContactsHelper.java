package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;
import ru.stqa.pft.addressbook.model.ContactData;

public class PrimaryContactsHelper extends HelperBase {

  public PrimaryContactsHelper(FirefoxDriver wd) {
    super(wd);
  }

  public void primaryContacts(ContactData contactData) {

    type(By.name("email"), contactData.getEmail1());

    type(By.name("email2"), contactData.getEmail2());

    type(By.name("email3"), contactData.getEmail3());

    type(By.name("homepage"), contactData.getHomePage());

    type(By.name("home"), contactData.getHome());

    type(By.name("mobile"), contactData.getMobile());

    type(By.name("work"), contactData.getWork());

    type(By.name("fax"), contactData.getFax());

  }

  public void personalInfo(ContactData contactData) {

    type(By.name("firstname"), contactData.getFirstName());

    type(By.name("middlename"), contactData.getMiddleName());

    type(By.name("lastname"), contactData.getLastName());

    type(By.name("nickname"), contactData.getNickName());

    type(By.name("title"), contactData.getTitle());

    type(By.name("company"), contactData.getCompany());

    type(By.name("address"), contactData.getAddress());

  }
}
