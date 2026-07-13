package com.cognizant.spring_learn;

import org.springframework.web.bind.annotation.*;

@RestController
public class JwtController {

    @PostMapping("/authenticate")
    public JwtResponse authenticate(@RequestBody JwtRequest request) {

        if(request.getUsername().equals("admin") &&
                request.getPassword().equals("admin123")){

            String token = JwtUtil.generateToken(request.getUsername());

            return new JwtResponse(token);

        }

        return new JwtResponse("Invalid Username or Password");
    }

}