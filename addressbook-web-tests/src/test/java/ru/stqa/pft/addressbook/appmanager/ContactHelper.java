package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;
import ru.stqa.pft.addressbook.model.ContactData;

public class ContactHelper extends HelperBase {

  public ContactHelper(FirefoxDriver wd) {
    super(wd);
  }

  public void clickOnAlert() {
    wd.switchTo().alert().accept();
  }

  public void addNew() {

    click(By.linkText("add new"));

  }

  public void goHomePage() {
    click(By.linkText("home"));
  }

  public void selectContact() {
    click(By.name("selected[]"));
  }

  public void deleteContact() {
    click(By.xpath("//div[@id='content']/form[2]/div[2]/input"));
  }

  public void clickOnEdit() {
    click(By.xpath("//table[@id='maintable']/tbody/tr[2]/td[8]/a/img"));
  }

  public void updateEditedContact() {
    click(By.name("update"));
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

  public void secondaryContacts(ContactData contactData) {

    type(By.name("address2"), contactData.getaddress2());


    type(By.name("phone2"), contactData.getphone2());


    type(By.name("notes"), contactData.getnotes());


    click(By.xpath("//div[@id='content']/form/input[21]"));

  }
}




