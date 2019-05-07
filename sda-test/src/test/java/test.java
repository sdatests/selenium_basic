import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class test {
  WebDriver driver;
  String baseUrl = "http://automationpractice.com/index.php";
  final String LOGIN = "fsdsizdf.pi0@20mail.it";
  final String PASSWORD = "testtest";

  @Before
  public void setUP() {
    //here system.setProperty...
    driver = new ChromeDriver();
    driver.get(baseUrl);
  }

  @Test
  public void shouldIcanLogIn() {
    HomePage homePage = new HomePage(driver);
    LoginPage loginPage = homePage.goToLogIn();
    loginPage.sendLogin(LOGIN);
    loginPage.sendPassword(PASSWORD);
    ClientPage clientPage = loginPage.logIn();
    Assert.assertTrue("I'm not logged", clientPage.iCanLogOut());
  }
  @Test
  public void shouldIcanNotLogInAndGetMessage() {
    HomePage homePage = new HomePage(driver);
    LoginPage loginPage = homePage.goToLogIn();
    loginPage.sendLogin(LOGIN);
    loginPage.sendPassword(PASSWORD+"a");
    loginPage.logIn();
    Assert.assertTrue("I'm not logged", loginPage.alertIsShowWithMessage());
  }

  @After
  public void endTest() {
    driver.quit();
  }
}