package br.ce.wcaquino.rest;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import org.junit.Assert;
import org.junit.Test;

public class HelloWorldTest {
    Response response = RestAssured.request(Method.GET, "http://restapi.wcaquino.me/ola");

    @Test
    public void testHelloWorld() {
        Assert.assertEquals("Ola Mundo!",response.getBody().asString());
        Assert.assertEquals(200,response.statusCode());
    }

    @Test
    public void testeOutrosMetodos(){
        Assert.assertEquals("Ola Mundo!",response.getBody().asString());
        Assert.assertEquals(200,response.statusCode());
    }
}
