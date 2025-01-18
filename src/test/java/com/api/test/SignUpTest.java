package com.api.test;

import com.api.base.AuthService;
import com.api.models.request.SignupRequest;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SignUpTest {

    @Test
    public void signup() {
        SignupRequest signupRequest = new SignupRequest.Builder()
                .username("dipta1234")
                .password("dipta1234")
                .firstName("Dipatmoy")
                .lastName("Sinha")
                .email("diptamoy25@gmail.com")
                .mobileNumber("9456782345")
                .build();
        AuthService authService = new AuthService();
        Response res = authService.signup(signupRequest);
        Assert.assertEquals(res.asPrettyString(), "User registered successfully!");
    }
}
