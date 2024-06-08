package com.example.Oauth;

import org.springframework.security.oauth2.client.authentication.OAuth2AuthenticationToken;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.Map;

import java.util.Map;

@RestController
public class UserController {

    //direct start Oauth request
    @GetMapping("/user")
    public Map<String, Object> user(OAuth2AuthenticationToken authentication) {
        return authentication.getPrincipal().getAttributes();
    }
}