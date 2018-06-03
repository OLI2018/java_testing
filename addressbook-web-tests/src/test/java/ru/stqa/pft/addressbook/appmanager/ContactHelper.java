package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.Contacts;

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
    wd.findElements(By.name("selected[]")).get(index).click();
  }

  public void deleteContact() {
    click(By.xpath("//div[@id='content']/form[2]/div[2]/input"));
  }

  public void clickOnEdit(int index) {
    int increaseIndex = index + 2;
    wd.findElement(By.xpath("//table[@id='maintable']/tbody/tr[" + increaseIndex + "]/td[8]/a/img")).click();
  }

  public void updateEditedContact() {
    click(By.name("update"));
  }

  public void primaryContacts(ContactData contactData, boolean creation) {

    type(By.name("email"), contactData.getEmail1());

    type(By.name("email2"), contactData.getEmail2());

    type(By.name("email3"), contactData.getEmail3());

    type(By.name("homepage"), contactData.getHomePage());

    type(By.name("home"), contactData.getHomePhone());

    type(By.name("mobile"), contactData.getMobilePhone());

    type(By.name("work"), contactData.getWorkPhone());

    type(By.name("fax"), contactData.getFax());

    if (creation) {
      if (contactData.getGroups().size() > 0) {
        Assert.assertTrue(contactData.getGroups().size() == 1);
        new Select(wd.findElement(By.name("new_group"))).selectByVisibleText(contactData.getGroups().iterator().next().getName());
        }
      } else {
        Assert.assertFalse(isElementPresent(By.name("new_group")));
      }
    }

    public void personalInfo (ContactData contactData){

      type(By.name("firstname"), contactData.getFirstName());

      type(By.name("middlename"), contactData.getMiddleName());

      type(By.name("lastname"), contactData.getLastName());

      type(By.name("nickname"), contactData.getNickName());

      type(By.name("title"), contactData.getTitle());

//    attach(By.name("photo"),contactData.getPhoto()); skip a photo

      type(By.name("company"), contactData.getCompany());

      type(By.name("address"), contactData.getAddress());

    }

    public void secondaryContacts (ContactData contactData){

      type(By.name("address2"), contactData.getaddress2());

      type(By.name("phone2"), contactData.getphone2());

      type(By.name("notes"), contactData.getnotes());

      click(By.xpath("//div[@id='content']/form/input[21]"));

    }

    public boolean isThereAContact () {
      return isElementPresent(By.name("selected[]"));
    }

    public Contacts all () {
      Contacts contacts = new Contacts();
      WebElement htmltable = wd.findElement(By.xpath("//*[@id=\"maintable\"]"));
      List<WebElement> rows = htmltable.findElements(By.tagName("tr"));
      for (int i = 1; i < rows.size(); i++) {
        List<WebElement> cells = rows.get(i).findElements(By.tagName("td"));
        String firstName = cells.get(2).getText();
        String lastName = cells.get(1).getText();
        int id = Integer.parseInt(rows.get(i).findElement(By.tagName("input")).getAttribute("value"));
        String allPhones = cells.get(5).getText();
        String allEmails = cells.get(4).getText();
        String allAddress = cells.get(3).getText();
        contacts.add(new ContactData()
                .withId(id).withFirstName(firstName).withLastName(lastName)
                .withAllPhones(allPhones).withAllEmails(allEmails).withAddressContact(allAddress));
      }
      return contacts;
    }

    public void delete (ContactData contact){
      selectContactById(contact.getId());
      deleteContact();
      clickOnAlert();
    }

    public void selectContactById ( int id){
      wd.findElement(By.cssSelector("input[value='" + id + "'")).click();
    }


    public void modifyTest (ContactData contact){
      selectContactById(contact.getId());
      clickOnEditById(contact.getId());
    }

    public void clickOnEditById ( int id){
      wd.findElement(By.xpath("//table[@id='maintable']/tbody/tr/td/input[@value='" + id + "']/../../td[8]/a/img")).click();
    }

    public ContactData infoFormEditForm (ContactData contact){

      initContactModificationById(contact.getId());
      String firstname = wd.findElement(By.name("firstname")).getAttribute("value");
      String lastname = wd.findElement(By.name("lastname")).getAttribute("value");
      String home = wd.findElement(By.name("home")).getAttribute("value");
      String mobile = wd.findElement(By.name("mobile")).getAttribute("value");
      String work = wd.findElement(By.name("work")).getAttribute("value");

      String email_1 = wd.findElement(By.name("email")).getAttribute("value");
      String email_2 = wd.findElement(By.name("email2")).getAttribute("value");
      String email_3 = wd.findElement(By.name("email3")).getAttribute("value");

      String addressContact = wd.findElement(By.name("address")).getText();

      wd.navigate().back();
      return new ContactData()
              .withId(contact.getId()).withFirstName(firstname).withLastName(lastname)
              .withHomePhone(home).withMobilePhone(mobile).withWorkPhone(work)
              .withEmail_1(email_1).withEmail_2(email_2).withEmail_3(email_3)
              .withAddressContact(addressContact);
    }

    private void initContactModificationById ( int id){

      WebElement checkbox = wd.findElement(By.cssSelector(String.format("input[value='%s']", id)));
      WebElement row = checkbox.findElement(By.xpath("./../.."));
      List<WebElement> cells = row.findElements(By.tagName("td"));
      cells.get(7).findElement(By.tagName("a")).click();
    }
  }



