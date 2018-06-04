package ru.stqa.pft.mantis.tests;

import org.openqa.selenium.remote.BrowserType;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import ru.stqa.pft.mantis.appmanager.ApplicationManager;

import java.io.File;
import java.io.IOException;


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

    File file = new File("C:\\Users\\OI\\Documents\\GitHub\\java_testing\\mantis-tests\\src\\test\\resources\\config_inc.php");
    String target = "C:\\xampp\\htdocs\\mantisbt-2.14.0\\config\\config_inc.php";
    String backup = "C:\\xampp\\htdocs\\mantisbt-2.14.0\\config\\config_inc.php.bak";

    app.ftp().upload(file, target, backup);

  }

  @AfterSuite
  public void tearDown() throws IOException {
    app.ftp().restore("config_inc.php.bak", "config_inc.php");
    app.stop();
  }

}





