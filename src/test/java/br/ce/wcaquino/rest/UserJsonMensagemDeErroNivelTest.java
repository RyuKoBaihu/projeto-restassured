package br.ce.wcaquino.rest;

import io.restassured.http.Method;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.request;
import static org.hamcrest.Matchers.*;

public class UserJsonMensagemDeErroNivelTest {

    Response response = request(Method.GET, "http://restapi.wcaquino.me/users/4");
    Integer statusCodeOK = 404;

    @Test
    public void deveraRetornarErroUsuarioInexistente() {
        given()
                .when()
                .response()
                .then()
                .statusCode(statusCodeOK)
                .body("error", is("Usuário inexistente"));
    }


}
