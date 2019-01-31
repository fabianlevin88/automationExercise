package Tests;

import Pages.BuenaSaludPage;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class BuenaSaludTest extends BaseTest {

    @Test
    @Parameters({"height", "weight", "age", "gender"})
    public void buenaSaludTest(String height, String weight, String age, String gender) {

        BuenaSaludPage saludPage = getSaludPage();

        saludPage.enterHeight(height);

        saludPage.enterWeight(weight);

        saludPage.enterAge(age);

        saludPage.selectGender(gender);

        saludPage.calculate();

        Assert.assertTrue(saludPage.validateIMC(), "IMC is not between 24 or 25");
    }

}
