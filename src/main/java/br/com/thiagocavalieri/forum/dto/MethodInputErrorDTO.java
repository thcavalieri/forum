package br.com.thiagocavalieri.forum.dto;

import lombok.Value;

@Value
public class MethodInputErrorDTO {
    String field;
    String errorMsg;
}
