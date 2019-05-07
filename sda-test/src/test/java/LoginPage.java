import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {
  private final By loginForm = By.id("email");
  private final By passwordForm = By.id("passwd");
  private final By buttonForm = By.id("SubmitLogin");
  private final By alert =  new By.ByClassName("alert-danger");

  WebDriver driver;

  public LoginPage(WebDriver driver){
    this.driver = driver;
  }

  public void sendLogin(String login){
    WebElement element = driver.findElement(loginForm);
    element.clear();
    element.sendKeys(login);
  }

  public void sendPassword(String password){
    WebElement element = driver.findElement(passwordForm);
    element.clear();
    element.sendKeys(password);
  }

  public ClientPage logIn(){
    WebElement element = driver.findElement(buttonForm);
    element.click();
    return new ClientPage(driver);
  }

  public boolean alertIsShowWithMessage(){
    WebElement element = driver.findElement(alert);
    return element.isDisplayed() && element.getText().contains("There is 1 error");
  }


}
