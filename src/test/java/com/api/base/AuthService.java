package com.api.base;

import com.api.models.request.LoginRequest;
import com.api.models.request.SignupRequest;
import io.restassured.response.Response;

public class AuthService extends BaseService{

    private static final String BASEPATH = "api/auth/";

    public Response login(LoginRequest payload) {
        return postRequest(payload, BASEPATH + "login");
    }

    public Response signup(SignupRequest payload) {
        return postRequest(payload, BASEPATH + "signup");
    }
}
