package br.com.thiagocavalieri.forum.dto;

import br.com.thiagocavalieri.forum.model.TopicStatus;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Data
public class TopicDetailDTO {
    private Long id;
    private String title;
    private String message;
    private LocalDateTime dtCreation;
    private String userName;
    private TopicStatus status;
    private List<AnswerDTO> listAnswer;
}
