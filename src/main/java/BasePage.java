import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BasePage {

    protected WebDriver driver;

    public BasePage(WebDriver driver) {
        this.driver = driver;
    }

    /**
     * Url the URL of the application page.
     */
    String Url = "https://jobs.lever.co/commencis/ae502445-77b6-4e51-9226-1cc91790f2dc/apply";

    public WebElement find(By locator) {return driver.findElement(locator);}

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

    public void wait(WebElement element, Long waitingSeconds){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(waitingSeconds));
        wait.until(ExpectedConditions.visibilityOf(element));
    }
}
