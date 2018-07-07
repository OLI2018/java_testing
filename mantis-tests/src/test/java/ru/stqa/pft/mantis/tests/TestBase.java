package ru.stqa.pft.mantis.tests;

import org.openqa.selenium.remote.BrowserType;
import org.testng.SkipException;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import ru.stqa.pft.mantis.appmanager.ApplicationManager;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.rmi.RemoteException;


public class TestBase {

  public static ApplicationManager app;

  {
    try {
      app = new ApplicationManager(System.getProperty("browser", BrowserType.FIREFOX));
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  @BeforeSuite
  public void setUp() throws Exception {
    app.init();
    app.ftp().upload(new File("src/test/resources/config_inc.php"), "config_inc.php", "config_inc.php.bak");
  }

  @AfterSuite
  public void tearDown() throws IOException {
    app.ftp().restore("config_inc.php.bak", "config_inc.php");
    app.stop();
  }

  public boolean isIssueOpen(int issueId) throws MalformedURLException, javax.xml.rpc.ServiceException, RemoteException {
    String closedStatus = "closed";
    String resolvedStatus = "resolved";

    String fixed = app.soap().getStatus(issueId);

    if (fixed.equals(closedStatus) || fixed.equals(resolvedStatus)) {
      return false;
    } else {
      return true;
    }
  }


  public void skipIfNotFixed(int issueId) throws MalformedURLException, javax.xml.rpc.ServiceException, RemoteException {
    if (isIssueOpen(issueId)) {
      throw new SkipException("Ignored because of issue " + issueId);
    }
  }
}





