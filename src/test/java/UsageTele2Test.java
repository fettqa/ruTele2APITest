import com.jayway.restassured.RestAssured;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.ArrayList;

import static com.jayway.restassured.RestAssured.*;


public class UsageTele2Test {

    @BeforeClass
    public static void setUp() {
        RestAssured.baseURI = Configurations.BASE_URI;
        RestAssured.basePath = Configurations.BASE_PATH;
    }

    @Test
    public void tele2APITest() {

        ArrayList <String> dataRegionId = given()
                .queryParam(Configurations.PARAMETER_NAME, Configurations.PARAMETER_VALUE)
                .when()
                .get("/regions")
                .then()
                .extract()
                .path("data.regionId");

        Assertions.shouldHaveNumbers(dataRegionId);

        ArrayList <String> dataRoamingProductId = given()
                .queryParam(Configurations.PARAMETER_NAME, Configurations.PARAMETER_VALUE)
                .when()
                .get("/regions")
                .then()
                .extract()
                .path("data.roamingProductId");

        Assertions.startsWithString(dataRoamingProductId, "prod");

    }
}
