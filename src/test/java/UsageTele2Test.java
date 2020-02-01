import com.jayway.restassured.RestAssured;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.ArrayList;

import static com.jayway.restassured.RestAssured.*;


public class UsageTele2Test {
    private static String PARAMETER_NAME = "siteId";
    private static String PARAMETER_VALUE = "siteMSK";

    @BeforeClass
    public static void setUp() {
        RestAssured.baseURI = "https://msk.tele2.ru";
        RestAssured.basePath = "/api/roaming";
    }

    @Test
    public void tele2APITest() {

        ArrayList <String> dataRegionId = given()
                .queryParam(PARAMETER_NAME, PARAMETER_VALUE)
                .when()
                .get("/regions")
                .then()
                .extract()
                .path("data.regionId");

        for (String s : dataRegionId) {
            Integer.parseInt(s);
        }

        ArrayList <String> dataRoamingProductId = given()
                .queryParam(PARAMETER_NAME, PARAMETER_VALUE)
                .when()
                .get("/regions")
                .then()
                .extract()
                .path("data.roamingProductId");

        for (String i : dataRoamingProductId) {
            Assert.assertTrue(i.matches("prod(.*)"));
        }
    }
}
