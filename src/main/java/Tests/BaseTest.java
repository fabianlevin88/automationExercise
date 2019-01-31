package Tests;

import Config.MyDriver;
import Pages.BuenaSaludPage;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

public class BaseTest {
    MyDriver driver;
    private BuenaSaludPage saludPage;

    @Parameters({"browser"})
    @BeforeSuite(alwaysRun = true)
    public void setUp(String browser) {

        selectBrowser(browser);

        saludPage = new BuenaSaludPage(driver.getDriver());
    }

    @AfterSuite
    public void tearDown() {

        saludPage.dispose();
    }

    public BuenaSaludPage getSaludPage() {

        return saludPage;
    }

    public void selectBrowser(String browser) {

        switch (browser) {
            case "chrome":
                driver = new MyDriver("chrome");
                break;
            case "firefox":
                driver = new MyDriver("firefox");
                break;
            default:
                driver = new MyDriver("chrome");
                break;
        }
    }
}
