package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;

public class ContactNavigationHelper extends HelperBase {


  public ContactNavigationHelper(FirefoxDriver wd) {
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
}


