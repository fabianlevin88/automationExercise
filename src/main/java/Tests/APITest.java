package Tests;

import Config.Logger;
import com.jayway.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.util.List;

import static Config.Values.getAPI;
import static com.jayway.restassured.RestAssured.given;


public class APITest {

    @Test
    public void statusCheck() {

        Logger.printInfo("Validating that the response returns a status code of 200");

        given().expect().statusCode(200).get(getAPI());

    }

    @Test
    public void validateIdList() {

        Logger.printInfo("Obtaining the list of userIds");

        List<Integer> response = given().get(getAPI()).getBody().jsonPath().getList("userId");

        Logger.printInfo("userId list obtained: " + response);

        for(Integer res: response) {
            Assert.assertNotEquals(res, "0", "one of the userIds obtained is 0");
        }

    }
}
