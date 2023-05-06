package br.ce.wcaquino.rest;

import io.restassured.http.Method;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.request;
import static org.hamcrest.Matchers.*;

public class UserJsonSegundoNivelTest {

    Response response = request(Method.GET, "http://restapi.wcaquino.me/users/2");
    JsonPath jsonPath = new JsonPath(response.asString());
    Integer statusCodeOK = 200;

    @Test
    public void testeSegundoNivelJson() {
        given()
                .when()
                .response()
                .then()
                .statusCode(statusCodeOK)
                .body("name",containsString("Joaquina"))
                .body("endereco.rua",is("Rua dos bobos"))
                .body("endereco.numero",is(0));
    }


}
