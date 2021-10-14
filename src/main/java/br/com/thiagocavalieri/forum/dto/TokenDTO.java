package br.com.thiagocavalieri.forum.dto;

import lombok.Value;

@Value
public class TokenDTO {
    String token;
    String securityType;
}
