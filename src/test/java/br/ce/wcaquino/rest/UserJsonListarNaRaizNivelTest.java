package br.ce.wcaquino.rest;

import io.restassured.http.Method;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.request;
import static org.hamcrest.Matchers.*;

public class UserJsonListarNaRaizNivelTest {

    Response response = request(Method.GET, "http://restapi.wcaquino.me/users");
    Integer statusCodeOK = 404;

    @Test
    public void deveraVerificarInfosDaListaNaRaiz() {
        given()
                .when()
                .response()
                .then()
                .statusCode(statusCodeOK)
                .body("S",hasSize(3))
                .body("name",hasItems("João da Silva","Maria Joaquina","Ana Júlia"))
                .body("age[1]",is(25))
                .body("filhos.name",hasItems("Zezinho","Luizinho"));

    }
}
