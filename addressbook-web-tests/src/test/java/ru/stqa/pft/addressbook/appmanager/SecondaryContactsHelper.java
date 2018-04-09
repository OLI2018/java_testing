package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;

public class SecondaryContactsHelper extends HelperBase {


  public SecondaryContactsHelper(FirefoxDriver wd) {
    super(wd);

  }

  public void secondaryContacts() {

    wd.findElement(By.name("address2")).click();
    wd.findElement(By.name("address2")).clear();
    wd.findElement(By.name("address2")).sendKeys("1234 Qwert St E, Moscow, WA, 98188");


    wd.findElement(By.name("phone2")).click();
    wd.findElement(By.name("phone2")).clear();
    wd.findElement(By.name("phone2")).sendKeys("Castle Rock");


    wd.findElement(By.name("notes")).click();
    wd.findElement(By.name("notes")).clear();
    wd.findElement(By.name("notes")).sendKeys("go to the 3rd floor and be aware of dogs! ");


    wd.findElement(By.xpath("//div[@id='content']/form/input[21]")).click();
  }
}
