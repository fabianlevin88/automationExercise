package Pages;

import Config.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import static Config.Values.*;

public class BuenaSaludPage extends BasePage {

    @FindBy(id = "altura")
    private WebElement heightInput;

    @FindBy(id = "peso")
    private WebElement weightInput;

    @FindBy(id = "edad")
    private WebElement ageInput;

    @FindBy(id = "sexo")
    private WebElement genderButton;

    @FindBy(css = ".form_buttonbox")
    private WebElement calculateBtn;

    @FindBy(id = "IMC")
    private WebElement imc;

    public BuenaSaludPage(WebDriver pDriver) {
        super(pDriver);
        getDriver().get(getPageURL());
    }

    public void enterHeight(String height) {

        heightInput.clear();

        Logger.printInfo("Entering the height: " + height);

        heightInput.sendKeys(height);
    }

    public void enterWeight(String weight) {

        weightInput.clear();

        Logger.printInfo("Entering the weight: " + weight);

        weightInput.sendKeys(weight);
    }

    public void enterAge(String age) {

        ageInput.clear();

        Logger.printInfo("entering the age: " + age);

        ageInput.sendKeys(age);
    }

    public void selectGender(String gender) {

        Select genderSelect = new Select(genderButton);

        Logger.printInfo("Selecting the gender: " + gender);

        genderSelect.selectByValue(gender);
    }

    public void calculate() {

        Logger.printInfo("Calculating...");

        calculateBtn.click();

    }

    public Boolean validateIMC() {

        Logger.printInfo(imc.getAttribute("value"));

        return imc.getAttribute("value").contains("24") || imc.getAttribute("value").contains("25");
    }
}
