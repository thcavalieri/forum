package br.com.thiagocavalieri.forum.dto;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class AnswerDTO {
    private Long id;
    private String message;
    private LocalDateTime dateCreation;
    private String userName;
}
