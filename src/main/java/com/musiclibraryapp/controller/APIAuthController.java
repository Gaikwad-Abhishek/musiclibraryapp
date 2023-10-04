package com.musiclibraryapp.controller;

import java.time.Instant;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.oauth2.jwt.JwtClaimsSet;
import org.springframework.security.oauth2.jwt.JwtEncoder;
import org.springframework.security.oauth2.jwt.JwtEncoderParameters;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.musiclibraryapp.dto.LoginBody;
import com.musiclibraryapp.dto.TokenDTO;
import com.musiclibraryapp.entity.User;
import com.musiclibraryapp.service.UserService;

 

@RestController
@RequestMapping("/api/auth")

public class APIAuthController {

   

    @Autowired

    JwtEncoder jwtEncoder;

 

    @Autowired

    AuthenticationManager authenticationManager;
    
    @Autowired
    UserService userService;
 

    @PostMapping("/token")

    public TokenDTO token(@RequestBody LoginBody loginBody) {

        Instant now = Instant.now();

        long expiry = 3600L;
//        long expiry = 20L;

        var username = loginBody.getUsername();

        var password = loginBody.getPassword();

        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));

        String scope = authentication.getAuthorities().stream()

        .map(GrantedAuthority::getAuthority)

        .collect(Collectors.joining(" "));

 

        JwtClaimsSet claims = JwtClaimsSet.builder()

        .issuer("self")

        .issuedAt(now)

        .expiresAt(now.plusSeconds(expiry))

        .subject(authentication.getName())

        .claim("scope", scope)

        .build();

 
        TokenDTO token = new TokenDTO();
        token.setToken(this.jwtEncoder.encode(JwtEncoderParameters.from(claims)).getTokenValue());

        return token;
    }
    
    
    @PostMapping("/social/token")

    public TokenDTO socialToken(@RequestBody LoginBody loginBody) {

        Instant now = Instant.now();

        long expiry = 3600L;
//        long expiry = 20L;

        var username = loginBody.getUsername();
        
        var password = loginBody.getPassword();
        
        if(!userService.getByName(username).isPresent()) {
        	User registerUser = new User();
        	registerUser.setName(username);
        	registerUser.setPassword(password);
        	registerUser.setRole("User");
        	userService.create(registerUser);
        }
        System.out.println("In Social Login");
        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));

        String scope = authentication.getAuthorities().stream()

        .map(GrantedAuthority::getAuthority)

        .collect(Collectors.joining(" "));

 

        JwtClaimsSet claims = JwtClaimsSet.builder()

        .issuer("self")

        .issuedAt(now)

        .expiresAt(now.plusSeconds(expiry))

        .subject(authentication.getName())

        .claim("scope", scope)

        .build();

 
        TokenDTO token = new TokenDTO();
        token.setToken(this.jwtEncoder.encode(JwtEncoderParameters.from(claims)).getTokenValue());

        return token;
    }

 

}