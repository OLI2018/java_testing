package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;

public class AddNewContactCreationHelper {
  private FirefoxDriver wd;

  public AddNewContactCreationHelper(FirefoxDriver wd) {
    this.wd = wd;
  }

  public void addNew() {
    wd.findElement(By.linkText("add new")).click();
  }
}
