package br.com.thiagocavalieri.forum.service;

import br.com.thiagocavalieri.forum.dto.TopicRequestDTO;
import br.com.thiagocavalieri.forum.mapper.TopicMapper;
import br.com.thiagocavalieri.forum.model.Course;
import br.com.thiagocavalieri.forum.model.Topic;
import br.com.thiagocavalieri.forum.repository.CourseRepository;
import br.com.thiagocavalieri.forum.repository.TopicRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;

@AllArgsConstructor
@Service
public class TopicService {

    private TopicRepository topicRepository;
    private CourseRepository courseRepository;

    public List<Topic> getListTopics(String courseName) {
        if (StringUtils.hasText(courseName)) {
            return topicRepository.findByCourseName(courseName);
        }
        return topicRepository.findAll();
    }

    public Topic createTopic(TopicRequestDTO requestDTO) {
        Topic topic = TopicMapper.MAPPER.topicRequestDTOToModel(requestDTO);
        Course course = courseRepository.findByName(requestDTO.getCourseName());

        topic.setCourse(course);

        return topicRepository.save(topic);
    }

    public Topic getTopic(Long id) {
        return topicRepository.getOne(id);
    }
}
