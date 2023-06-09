package br.ce.wcaquino.rest;

import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import org.junit.Assert;
import org.junit.Test;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class MetodosDiferentesRestTest {
    Response response = request(Method.GET, "http://restapi.wcaquino.me/ola");
    Integer statusCodeOK = 200;

    @Test
    public void metodoAssertEquals() {
        Assert.assertEquals("Ola Mundo!",response.getBody().asString());
        Assert.assertEquals(200,response.statusCode());
    }

    @Test
    public void metodoValidatableResponse(){
        ValidatableResponse validacao = response.then();
        validacao.statusCode(200);
    }

    @Test
    public void metodoGivenWhenThen(){
        given()
                .when()
                .response().
                then().
                statusCode(statusCodeOK);
    }

    @Test
    public void validacaoBodyHamscrest(){
        given()
                .when()
                .response()
                .then()
                .statusCode(statusCodeOK)
                .body(is("Ola Mundo!"))
                .body(containsString("Mundo"))
                .body(is(not(nullValue())));
    }


}
