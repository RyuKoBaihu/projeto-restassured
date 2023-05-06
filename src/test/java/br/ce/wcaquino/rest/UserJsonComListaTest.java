package br.ce.wcaquino.rest;

import io.restassured.http.Method;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.request;
import static org.hamcrest.Matchers.*;

public class UserJsonComListaTest {

    Response response = request(Method.GET, "http://restapi.wcaquino.me/users/3");
    JsonPath jsonPath = new JsonPath(response.asString());
    Integer statusCodeOK = 200;

    @Test
    public void verificacaoEmListaJson() {
        given()
                .when()
                .response()
                .then()
                .statusCode(statusCodeOK)
                .body("name",containsString("Ana"))
                .body("filhos",hasSize(2))
                .body("filhos[0].name",is("Zezinho"))
                .body("filhos[1].name",is("Luizinho"))
                .body("filhos.name",hasItem("Zezinho"))
                .body("filhos.name",hasItems("Zezinho","Luizinho"));

    }


}
