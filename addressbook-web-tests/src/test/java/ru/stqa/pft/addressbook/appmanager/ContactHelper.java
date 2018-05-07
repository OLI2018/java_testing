package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.GroupData;

import java.util.ArrayList;
import java.util.List;

public class ContactHelper extends HelperBase {

  public ContactHelper(WebDriver wd) {
    super(wd);
  }

  public void clickOnAlert() {
    wd.switchTo().alert().accept();
  }

  public void addNew() {

    click(By.linkText("add new"));

  }

  public void selectContact(int index) {
//    wd.findElements(By.name("selected[]")).get(index).click();
    wd.findElements(By.name("selected[]")).get(index).click();
//    click(By.name("selected[]"));
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


  public void primaryContacts(ContactData contactData, boolean creation) {

    type(By.name("email"), contactData.getEmail1());

    type(By.name("email2"), contactData.getEmail2());

    type(By.name("email3"), contactData.getEmail3());

    type(By.name("homepage"), contactData.getHomePage());

    type(By.name("home"), contactData.getHome());

    type(By.name("mobile"), contactData.getMobile());

    type(By.name("work"), contactData.getWork());

    type(By.name("fax"), contactData.getFax());

    if (creation) {
      new Select(wd.findElement(By.name("new_group"))).selectByVisibleText(contactData.getGroup());

    } else {

      Assert.assertFalse(isElementPresent(By.name("new_group")));
    }
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

  public boolean isThereAContact() {
    return isElementPresent(By.name("selected[]"));
  }

  public List<ContactData> getContactList() {

    List<ContactData> contacts = new ArrayList<ContactData>();
    WebElement htmltable = wd.findElement(By.xpath("//*[@id=\"maintable\"]"));
    List<WebElement> rows = htmltable.findElements(By.tagName("tr"));
    for (int i = 1; i < rows.size(); i++) {
      List<WebElement> cells = rows.get(i).findElements(By.tagName("td"));
      String firstName = cells.get(2).getText();
      String lastName = cells.get(1).getText();
      int id = Integer.parseInt(rows.get(i).findElement(By.tagName("input")).getAttribute("value"));
      ContactData contact = new ContactData(id, firstName, null, lastName, null, null, null, null);
      contacts.add(contact);
    }
    return contacts;
  }
}









































