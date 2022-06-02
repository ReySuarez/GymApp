package com.example.gym.Gym.controller;

import com.example.gym.Gym.model.entity.User;
import com.example.gym.Gym.model.entity.UserQueryDTO;
import com.example.gym.Gym.model.service.UserService;
import com.example.gym.Gym.security.jwt.JwtProvider;
import com.example.gym.Gym.security.jwt.LoginPassword;
import com.example.gym.Gym.security.jwt.UserJwt;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class UserLoginController {
    private final UserService serveiUsuaris;
    private final AuthenticationManager authenticationManager;
    private final JwtProvider tokenProvider;

    @PostMapping("/login")
    public ResponseEntity<UserJwt> login(@RequestBody LoginPassword userPassword)
    {
        Authentication auth=authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(userPassword.getUserName(),userPassword.getPassword())
        );
        SecurityContextHolder.getContext().setAuthentication(auth);
        User usu=(User)auth.getPrincipal();
        String jwtToken = tokenProvider.generateToken(auth);
        UserJwt usu2=new UserJwt(usu.getUsername(),usu.getRole(),jwtToken);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(usu2);
    }


    @GetMapping("/login")
    public UserQueryDTO login(@AuthenticationPrincipal User user){
        UserQueryDTO user2=new UserQueryDTO(user.getUsername(),user.getRole());
        return user2;
    }

}


