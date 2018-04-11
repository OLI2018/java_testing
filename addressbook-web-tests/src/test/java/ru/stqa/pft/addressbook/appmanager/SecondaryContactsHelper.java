package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;
import ru.stqa.pft.addressbook.model.ContactData;


public class SecondaryContactsHelper extends HelperBase {


  public SecondaryContactsHelper(FirefoxDriver wd) {
    super(wd);

  }

  public void secondaryContacts(ContactData contactData) {

    type(By.name("address2"), contactData.getaddress2());


    type(By.name("phone2"), contactData.getphone2());


    type(By.name("notes"), contactData.getnotes());


    click(By.xpath("//div[@id='content']/form/input[21]"));


  }
}
