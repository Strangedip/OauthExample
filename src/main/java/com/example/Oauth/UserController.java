package com.example.Oauth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.oauth2.client.authentication.OAuth2AuthenticationToken;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.Map;

import java.util.Map;

@RestController
public class UserController {

    @Autowired
    OauthUserService oauthUserService;
    //direct start Oauth request
    @GetMapping("/oauth/google")
    public ResponseEntity<Result> user(OAuth2AuthenticationToken authentication) {
        return oauthUserService.registerOauthUser(authentication);
    }
}