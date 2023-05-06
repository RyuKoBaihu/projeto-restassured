package br.ce.wcaquino.rest;

import io.restassured.http.Method;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.Test;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class UserJsonPrimeiroNivelTest {

    Response response = request(Method.GET, "http://restapi.wcaquino.me/users/1");
    JsonPath jsonPath = new JsonPath(response.asString());
    Integer statusCodeOK = 200;

    @Test
    public void testePrimeiroNivelJson() {
        given()
                .when()
                .response()
                .then()
                .statusCode(statusCodeOK)
                .body("id",is(1))
                .body("name",containsString("Silva"))
                .body("age",greaterThan(18));
    }

    @Test
    public void primeiroNivelOutroMetodo() {
        //path
        Assert.assertEquals(new Integer(1), response.path("id"));
        Assert.assertEquals(new Integer(1), response.path("id"));

        //jsonpath
        Assert.assertEquals(1,jsonPath.getInt("id"));
    }
}
