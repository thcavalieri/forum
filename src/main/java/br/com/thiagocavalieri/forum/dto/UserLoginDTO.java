package br.com.thiagocavalieri.forum.dto;

import lombok.Value;

import javax.validation.constraints.NotEmpty;

@Value
public class UserLoginDTO {
    @NotEmpty
    String email;

    @NotEmpty
    String password;
}
