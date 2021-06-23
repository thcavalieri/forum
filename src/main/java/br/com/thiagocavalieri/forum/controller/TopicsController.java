package br.com.thiagocavalieri.forum.controller;

import br.com.thiagocavalieri.forum.dto.TopicDTO;
import br.com.thiagocavalieri.forum.mapper.TopicMapper;
import br.com.thiagocavalieri.forum.service.TopicService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@AllArgsConstructor
@RestController
public class TopicsController {

    private TopicService topicService;

    @GetMapping("/topics")
    public List<TopicDTO> list(String courseName) {
        return TopicMapper.MAPPER.topicModelListToListDTO(topicService.getListTopics(courseName));
    }
}
