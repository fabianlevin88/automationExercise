package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class BasePage {

    private WebDriver driver;
    private WebDriverWait wait;

    public BasePage(WebDriver pDriver) {
        PageFactory.initElements(pDriver, this);
        wait = new WebDriverWait(pDriver, 30);
        driver = pDriver;
    }

    public WebDriverWait getWait() {
        return wait;
    }

    public WebDriver getDriver() {
        return driver;
    }

    public void dispose() {
        if (driver != null) {
            driver.quit();
        }
    }
}
