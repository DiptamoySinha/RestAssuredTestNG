package com.api.test;

import com.api.base.AuthService;
import com.api.base.UserManagementService;
import com.api.models.request.LoginRequest;
import com.api.models.request.ProfileRequest;
import com.api.models.response.LoginResponse;
import com.api.models.response.UserProfileResponse;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(com.api.listener.TestListener.class)
public class UserManagementTest {

    @Test
    public void getUserProfile() {
        AuthService authService = new AuthService();
        String token = authService.login(new LoginRequest("dipta1234", "dipta1234"))
                .as(LoginResponse.class)
                .getToken();

        UserManagementService userManagementService = new UserManagementService();
        UserProfileResponse userProfileResponse = userManagementService.getProfileDetails(token)
                        .as(UserProfileResponse.class);
        Assert.assertEquals(userProfileResponse.getUsername(), "dipta1234");
    }

    @Test
    public void updateProfileTest() {
        AuthService authService = new AuthService();
        String token = authService.login(new LoginRequest("dipta1234", "dipta1234"))
                .as(LoginResponse.class)
                .getToken();

        ProfileRequest payload = new ProfileRequest.Builder()
                .firstName("Diptamoy")
                .lastName("Sinha")
                .email("diptamoy25@gmail.com")
                .mobileNumber("9823478029")
                .build();
        UserManagementService userManagementService = new UserManagementService();
        UserProfileResponse userProfileResponse = userManagementService.updateProfile(token, payload).as(UserProfileResponse.class);
        Assert.assertEquals(userProfileResponse.getFirstName(), "Diptamoy");
        Assert.assertEquals(userProfileResponse.getLastName(), "Sinha");
        Assert.assertEquals(userProfileResponse.getEmail(), "diptamoy25@gmail.com");
        Assert.assertEquals(userProfileResponse.getMobileNumber(), "9823478029");
    }  
}
