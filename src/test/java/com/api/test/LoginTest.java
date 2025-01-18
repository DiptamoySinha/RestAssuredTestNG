package com.api.test;

import com.api.base.AuthService;
import com.api.models.request.LoginRequest;
import com.api.models.response.LoginResponse;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;

@Listeners(com.api.listener.TestListener.class)
public class LoginTest {

    @Test(description = "login test")
    public void login() {
        LoginRequest  loginRequest = new LoginRequest("sinha", "abc12345");
        AuthService authService = new AuthService();
        Response res = authService.login(loginRequest);
        LoginResponse loginResponse = res.as(LoginResponse.class);
//        Response res = given().baseUri("https://bookcart.azurewebsites.net")
//                .header("Content-type", "application/json")
//                .body(payload).post("/api/Login");

        Assert.assertEquals(loginResponse.getUsername(), "sinha");
    }
}
