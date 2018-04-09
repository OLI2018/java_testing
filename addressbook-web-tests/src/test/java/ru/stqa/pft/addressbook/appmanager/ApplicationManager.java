package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import java.util.concurrent.TimeUnit;

public class ApplicationManager {

  FirefoxDriver wd;

  private ContactNavigationHelper contactNavigationHelper;
  private PrimaryContactsHelper primaryContactsHelper;
  private SecondaryContactsHelper secondaryContactsHelper;
  private SessionHelper sessionHelper;
  private NavigationHelper navigationHelper;
  private GroupHelper groupHelper;


  public void init() {
    wd = new FirefoxDriver(new FirefoxOptions().setLegacy(true));
    wd.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
    wd.get("http://localhost/addressbook/");
    groupHelper = new GroupHelper(wd);
    navigationHelper = new NavigationHelper(wd);
    sessionHelper = new SessionHelper(wd);
    secondaryContactsHelper= new SecondaryContactsHelper(wd);
    primaryContactsHelper = new PrimaryContactsHelper(wd);
    contactNavigationHelper = new ContactNavigationHelper(wd);
    sessionHelper.login("admin", "secret");
  }

  public void stop() {
    wd.quit();
  }

  public GroupHelper getGroupHelper() {
    return groupHelper;
  }

  public NavigationHelper getNavigationHelper() {
    return navigationHelper;
  }

  public SecondaryContactsHelper getSecondaryContactsHelper() {
    return secondaryContactsHelper;
  }

  public PrimaryContactsHelper getPrimaryContactsHelper() {
    return primaryContactsHelper;
  }

  public ContactNavigationHelper getContactNavigationHelper() {
    return contactNavigationHelper;
  }
}
