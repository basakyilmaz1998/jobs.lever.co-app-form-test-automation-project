import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class BasePage {

    protected WebDriver driver;

    public BasePage(WebDriver driver) {
        this.driver = driver;
    }

    //aşağıdakileri protected yapmak daha mantıklı olmaz mı

    String Url = "https://jobs.lever.co/commencis/ae502445-77b6-4e51-9226-1cc91790f2dc/apply";

    public WebElement find(By locator) {
        return driver.findElement(locator);
    }

    public void click(By locator) {
        find(locator).click();
    }

    public void type(By locator, String text) {
        find(locator).sendKeys(text);
    }

    public String getValue(By locator) {
        return find(locator).getAttribute("value");
    }

    public String getText(By locator) {
        return find(locator).getText();
    }

    public boolean isDisplayed(By locator) {
        return find(locator).isDisplayed();
    }
}
