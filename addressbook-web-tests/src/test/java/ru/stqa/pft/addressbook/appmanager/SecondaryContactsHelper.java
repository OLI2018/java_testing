package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;
import ru.stqa.pft.addressbook.model.SecondaryData;

public class SecondaryContactsHelper extends HelperBase {


  public SecondaryContactsHelper(FirefoxDriver wd) {
    super(wd);

  }

  public void secondaryContacts(SecondaryData secondaryData) {

    type(By.name("address2"),secondaryData.getaddress2());

//    wd.findElement(By.name("address2")).click();
//    wd.findElement(By.name("address2")).clear();
//    wd.findElement(By.name("address2")).sendKeys(secondaryData.getaddress2());

    type(By.name("phone2"),secondaryData.getphone2());

//    wd.findElement(By.name("phone2")).click();
//    wd.findElement(By.name("phone2")).clear();
//    wd.findElement(By.name("phone2")).sendKeys(secondaryData.getphone2());

    type(By.name("notes"),secondaryData.getnotes());

//    wd.findElement(By.name("notes")).click();
//    wd.findElement(By.name("notes")).clear();
//    wd.findElement(By.name("notes")).sendKeys(secondaryData.getnotes());

    click(By.xpath("//div[@id='content']/form/input[21]"));

//    wd.findElement(By.xpath("//div[@id='content']/form/input[21]")).click();
  }
}
