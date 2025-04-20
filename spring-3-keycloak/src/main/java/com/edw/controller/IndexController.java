package com.edw.controller;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

/**
 * <pre>
 *     com.edw.controller.IndexController
 * </pre>
 *
 * @author Muhammad Edwin < edwin at redhat dot com >
 * 21 Mar 2023 20:09
 */
@RestController
public class IndexController {

    @GetMapping(path = "/")
    public HashMap index() {
        // get a successful user login
//        OAuth2User user = ((OAuth2User)SecurityContextHolder.getContext().getAuthentication().getPrincipal());
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        if (principal instanceof Jwt) {
            Jwt jwt = (Jwt) principal;

            return new HashMap<>() {{
                put("hello", jwt.getClaim("name"));
                put("your email is", jwt.getClaim("email"));
            }};
        }
//        return new HashMap(){{
//            put("hello", user.getAttribute("name"));
//            put("your email is", user.getAttribute("email"));
//        }};
        return new HashMap<>() {{
            put("error", "Unable to retrieve user information");
        }};
    }


    @GetMapping(path = "/unauthenticated")
    public HashMap unauthenticatedRequests() {
        return new HashMap() {{
            put("this is", "unauthenticated endpoint");
        }};
    }

}
