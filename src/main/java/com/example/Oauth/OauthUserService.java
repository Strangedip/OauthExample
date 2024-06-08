package com.example.Oauth;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.oauth2.client.authentication.OAuth2AuthenticationToken;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class OauthUserService {

    public ResponseEntity<Result> registerOauthUser(OAuth2AuthenticationToken authentication){

        // Extract attributes from OAuth2 authentication
        Map<String, Object> attributes = authentication.getPrincipal().getAttributes();

        // Store attributes in the database
//        User user = new User();
//        user.setName((String) attributes.get("name"));
//        user.setEmail((String) attributes.get("email"));
//        user.setOtherAttribute((String) attributes.get("otherAttribute")); // Example: Extract and store other attributes
//        userRepository.save(user);

        // Prepare attributes to send to the frontend
        Map<String, Object> attributesToSend = Map.of(
                "name", attributes.get("name"),
                "email", attributes.get("email"),
                "otherAttribute", attributes.get("otherAttribute")
                // Add more attributes as needed
        );

//        now create the result which need to be sent to frontend as RESULT
        Result res = new Result();
        res.setCode(HttpStatus.OK.value());
        res.setMessage("registered successfully");
        res.setData(attributesToSend);

//        return the ResponseEntity object by setting ur Result object res and status code
        return new ResponseEntity<Result>(res,HttpStatus.OK);

    }
}
