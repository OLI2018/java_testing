package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;

public class AddNewContactCreationHelper extends HelperBase {


  public AddNewContactCreationHelper(FirefoxDriver wd) {
    super(wd);
  }

  public void addNew() {

    click(By.linkText("add new"));

//    wd.findElement(By.linkText("add new")).click();
  }
}
