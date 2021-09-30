package br.com.thiagocavalieri.forum.controller;

import br.com.thiagocavalieri.forum.dto.TopicCreateDTO;
import br.com.thiagocavalieri.forum.dto.TopicDTO;
import br.com.thiagocavalieri.forum.dto.TopicDetailDTO;
import br.com.thiagocavalieri.forum.dto.TopicUpdateDTO;
import br.com.thiagocavalieri.forum.mapper.TopicMapper;
import br.com.thiagocavalieri.forum.service.TopicService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;

@AllArgsConstructor
@RestController
@RequestMapping(value = "/topics")
public class TopicsController {

    private TopicService topicService;

    @GetMapping
    public Page<TopicDTO> topicList(@RequestParam(required = false) String courseName, @RequestParam int page,
                                    @RequestParam int size) {
        return topicService.getListTopics(courseName, page, size).map(TopicMapper.MAPPER::topicModelToDTO);
    }

    // Rest good practices: This method returns the http status code 201 and the header contains the Location
    @PostMapping
    public ResponseEntity<TopicDTO> createTopic(@RequestBody @Valid TopicCreateDTO requestDTO, UriComponentsBuilder uriBuilder) {
        TopicDTO dto = TopicMapper.MAPPER.topicModelToDTO(topicService.createTopic(requestDTO));
        URI uri = uriBuilder.path("/topics/{id}").buildAndExpand(dto.getId()).toUri();
        return ResponseEntity.created(uri).body(dto);
    }

    @GetMapping("/{id}")
    public ResponseEntity<TopicDetailDTO> detail(@PathVariable Long id) {
        return ResponseEntity.ok(TopicMapper.MAPPER.topicModelToTopicDetailDTO(topicService.getTopic(id)));
    }

    @PutMapping("/{id}")
    public ResponseEntity<TopicDTO> updateTopic(@PathVariable Long id, @RequestBody @Valid TopicUpdateDTO requestDTO) {
        TopicDTO dto = TopicMapper.MAPPER.topicModelToDTO(topicService.updateTopic(id, requestDTO));
        return ResponseEntity.ok(dto);
    }

    @DeleteMapping("/{id}")
    public void deleteTopic(@PathVariable Long id) {
        topicService.deleteTopic(id);
    }

}
