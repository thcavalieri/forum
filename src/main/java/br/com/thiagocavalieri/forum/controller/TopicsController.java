package br.com.thiagocavalieri.forum.controller;

import br.com.thiagocavalieri.forum.dto.TopicDTO;
import br.com.thiagocavalieri.forum.dto.TopicDetailDTO;
import br.com.thiagocavalieri.forum.dto.TopicRequestDTO;
import br.com.thiagocavalieri.forum.mapper.TopicMapper;
import br.com.thiagocavalieri.forum.service.TopicService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping(value = "/topics")
public class TopicsController {

    private TopicService topicService;

    @GetMapping
    public List<TopicDTO> topicList(String courseName) {
        return TopicMapper.MAPPER.topicModelListToListDTO(topicService.getListTopics(courseName));
    }

    // Rest good practices: This method returns the http status code 201 and the header contains the Location
    @PostMapping
    public ResponseEntity<TopicDTO> createTopic(@RequestBody @Valid TopicRequestDTO requestDTO, UriComponentsBuilder uriBuilder) {
        TopicDTO dto = TopicMapper.MAPPER.topicModelToDTO(topicService.createTopic(requestDTO));

        URI uri = uriBuilder.path("/topics/{id}").buildAndExpand(dto.getId()).toUri();

        return ResponseEntity.created(uri).body(dto);
    }

    @GetMapping("/{id}")
    public TopicDetailDTO detail(@PathVariable Long id)  {
        return TopicMapper.MAPPER.topicModelToTopicDetailDTO(topicService.getTopic(id));
    }
}
