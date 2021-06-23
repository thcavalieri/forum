package br.com.thiagocavalieri.forum.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.time.LocalDateTime;

@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class TopicDTO {
    @EqualsAndHashCode.Include
    private Long id;

    private String title;
    private String message;
    private LocalDateTime dtCreation;
}
