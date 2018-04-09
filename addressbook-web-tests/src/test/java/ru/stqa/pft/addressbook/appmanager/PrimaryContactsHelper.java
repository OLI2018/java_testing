package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;
import ru.stqa.pft.addressbook.model.EmailsData;
import ru.stqa.pft.addressbook.model.PersonalInfoData;
import ru.stqa.pft.addressbook.model.PhonesData;

public class PrimaryContactsHelper extends HelperBase {

  public PrimaryContactsHelper(FirefoxDriver wd) {
    super(wd);
  }

  public void emailsAndHomePage(EmailsData emailsData) {

    type(By.name("email"), emailsData.getEmail1());

//    wd.findElement(By.name("email")).click();
//    wd.findElement(By.name("email")).clear();
//    wd.findElement(By.name("email")).sendKeys(emailsData.getEmail1());


    type(By.name("email2"),emailsData.getEmail2());

//    wd.findElement(By.name("email2")).click();
//    wd.findElement(By.name("email2")).clear();
//    wd.findElement(By.name("email2")).sendKeys(emailsData.getEmail2());

    type(By.name("email3"),emailsData.getEmail3());

//    wd.findElement(By.name("email3")).click();
//    wd.findElement(By.name("email3")).clear();
//    wd.findElement(By.name("email3")).sendKeys(emailsData.getEmail3());

    type(By.name("homepage"), emailsData.getHomePage());

//    wd.findElement(By.name("homepage")).click();
//    wd.findElement(By.name("homepage")).clear();
//    wd.findElement(By.name("homepage")).sendKeys(emailsData.getHomePage());
  }

  public void phones(PhonesData phonesData) {

    type(By.name("home"), phonesData.getHome());

//    wd.findElement(By.name("home")).click();
//    wd.findElement(By.name("home")).clear();
//    wd.findElement(By.name("home")).sendKeys(phonesData.getHome());

    type(By.name("mobile"), phonesData.getMobile());

//    wd.findElement(By.name("mobile")).click();
//    wd.findElement(By.name("mobile")).clear();
//    wd.findElement(By.name("mobile")).sendKeys(phonesData.getMobile());

    type(By.name("work"),phonesData.getWork());

//    wd.findElement(By.name("work")).click();
//    wd.findElement(By.name("work")).clear();
//    wd.findElement(By.name("work")).sendKeys(phonesData.getWork());

    type(By.name("fax"),phonesData.getFax());

//    wd.findElement(By.name("fax")).click();
//    wd.findElement(By.name("fax")).clear();
//    wd.findElement(By.name("fax")).sendKeys(phonesData.getFax());
  }

  public void personalInfo(PersonalInfoData personalInfoData) {

    type(By.name("firstname"), personalInfoData.getFirstName());

//    wd.findElement(By.name("firstname")).click();
//    wd.findElement(By.name("firstname")).clear();
//    wd.findElement(By.name("firstname")).sendKeys(personalInfoData.getFirstName());

    type(By.name("middlename"), personalInfoData.getMiddleName());

//    wd.findElement(By.name("middlename")).click();
//    wd.findElement(By.name("middlename")).clear();
//    wd.findElement(By.name("middlename")).sendKeys(personalInfoData.getMiddleName());

    type(By.name("lastname"),personalInfoData.getLastName());

//    wd.findElement(By.name("lastname")).click();
//    wd.findElement(By.name("lastname")).clear();
//    wd.findElement(By.name("lastname")).sendKeys(personalInfoData.getLastName());

    type(By.name("nickname"), personalInfoData.getNickName());

//    wd.findElement(By.name("nickname")).click();
//    wd.findElement(By.name("nickname")).clear();
//    wd.findElement(By.name("nickname")).sendKeys(personalInfoData.getNickName());

    type(By.name("title"), personalInfoData.getTitle());

//    wd.findElement(By.name("title")).click();
//    wd.findElement(By.name("title")).clear();
//    wd.findElement(By.name("title")).sendKeys(personalInfoData.getTitle());

    type(By.name("company"),personalInfoData.getCompany());

//    wd.findElement(By.name("company")).click();
//    wd.findElement(By.name("company")).clear();
//    wd.findElement(By.name("company")).sendKeys(personalInfoData.getCompany());

    type(By.name("address"), personalInfoData.getAddress());

//    wd.findElement(By.name("address")).click();
//    wd.findElement(By.name("address")).clear();
//    wd.findElement(By.name("address")).sendKeys(personalInfoData.getAddress());
  }
}
