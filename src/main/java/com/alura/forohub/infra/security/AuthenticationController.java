package com.andromeda.forohub.infra.security;

import com.andromeda.forohub.model.User;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/login")
public class AuthenticationController {

    private final AuthenticationManager authenticationManager;
    private final TokenService tokenService;

    public AuthenticationController(AuthenticationManager authenticationManager, TokenService tokenService) {
        this.authenticationManager = authenticationManager;
        this.tokenService = tokenService;
    }

    @PostMapping
    public ResponseEntity authenticationUser(@RequestBody @Valid UserAuthentication user){
        Authentication authToken = new UsernamePasswordAuthenticationToken(user.email(), user.password());
        var usuarioAuthenticated = authenticationManager.authenticate(authToken);
        var JWTtoken = tokenService.generateToken((User) usuarioAuthenticated.getPrincipal());
        return ResponseEntity.ok(new DataJWTToken(JWTtoken));
    }

    public record DataJWTToken(String jwToken){}
}
