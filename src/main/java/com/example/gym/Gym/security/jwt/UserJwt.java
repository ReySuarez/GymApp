package com.example.gym.Gym.security.jwt;

import com.example.gym.Gym.model.entity.UserQueryDTO;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Setter
@Getter
public class UserJwt extends UserQueryDTO {
    private String token;
    @Builder(builderMethodName = "jwtUserJwtBuilder")
    public UserJwt(String username, String rol, String token) {
        super(username, rol);
        this.token = token;
    }
}
