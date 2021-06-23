package br.com.thiagocavalieri.forum.service;

import br.com.thiagocavalieri.forum.model.Topic;
import br.com.thiagocavalieri.forum.repository.TopicRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;

@AllArgsConstructor
@Service
public class TopicService {

    private TopicRepository topicRepository;

    public List<Topic> getListTopics(String courseName) {
        if (StringUtils.hasText(courseName)) {
            return topicRepository.findByCourseName(courseName);
        }
        return topicRepository.findAll();
    }
}
