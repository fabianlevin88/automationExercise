package Config;

import io.github.bonigarcia.wdm.ChromeDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

public class MyDriver {

    private WebDriver driver;

    /**
     * Instantiating the browser
     * @param browser selected
     */
    public MyDriver(String browser) {

        switch (browser) {
            case "firefox":
                System.setProperty("webdriver.gecko.driver", "/Users/fabianandreslevin/Projects/AutomationBasics/src/main/java/utils/geckodriver");
                DesiredCapabilities capabilities=DesiredCapabilities.firefox();
                capabilities.setCapability("marionette", true);
                driver = new FirefoxDriver();
                break;
            case "chrome":
                ChromeDriverManager.getInstance().setup();
                driver = new ChromeDriver();
                driver.manage().window().fullscreen();
                break;
            default:
                ChromeDriverManager.getInstance().setup();
                driver = new ChromeDriver();
                break;
        }
    }

    public WebDriver getDriver() {
        return this.driver;
    }
}
