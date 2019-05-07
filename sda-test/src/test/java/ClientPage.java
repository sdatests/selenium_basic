import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class ClientPage {
  private final By logOutLink = new By.ByClassName("logout");

  private WebDriver driver;

  public ClientPage(WebDriver driver){
    this.driver = driver;
  }

  public boolean iCanLogOut(){
    WebElement element = driver.findElement(logOutLink);
    return element.isDisplayed();
  }
}
