import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class HomePage {
  private final By login = By.className("login");

  private WebDriver driver;

  public HomePage (WebDriver driver){
    this.driver=driver;
  }

  public LoginPage goToLogIn(){
    WebElement element = driver.findElement(login);
    element.click();
    return new LoginPage(driver);
  }
}
