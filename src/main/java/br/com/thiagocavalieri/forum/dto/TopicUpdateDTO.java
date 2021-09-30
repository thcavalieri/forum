package br.com.thiagocavalieri.forum.dto;

import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotEmpty;

@Data
public class TopicUpdateDTO {

    @NotEmpty @Length(min = 5)
    private String title;

    @NotEmpty @Length(min = 10)
    private String message;

}
