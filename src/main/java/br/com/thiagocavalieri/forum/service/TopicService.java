package br.com.thiagocavalieri.forum.service;

import br.com.thiagocavalieri.forum.dto.TopicCreateDTO;
import br.com.thiagocavalieri.forum.dto.TopicUpdateDTO;
import br.com.thiagocavalieri.forum.mapper.TopicMapper;
import br.com.thiagocavalieri.forum.model.Course;
import br.com.thiagocavalieri.forum.model.Topic;
import br.com.thiagocavalieri.forum.repository.CourseRepository;
import br.com.thiagocavalieri.forum.repository.TopicRepository;
import lombok.AllArgsConstructor;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.persistence.EntityNotFoundException;

@AllArgsConstructor
@Service
public class TopicService {

    private TopicRepository topicRepository;
    private CourseRepository courseRepository;

    // Manual pagination without necessity of @EnableSpringDataWebSupport in main class.
    public Page<Topic> getListTopics(String courseName, int page, int size, String... orderBy) {
        Pageable pagination = PageRequest.of(page, size, Sort.Direction.ASC, orderBy);
        return this.getListTopics(courseName, pagination);
    }

    public Page<Topic> getListTopics(String courseName,
                                     @PageableDefault(sort = "id", direction = Sort.Direction.ASC) Pageable pagination) {
        if (StringUtils.hasText(courseName)) {
            return topicRepository.findByCourseName(courseName, pagination);
        }
        return topicRepository.findAll(pagination);
    }

    public Topic createTopic(TopicCreateDTO requestDTO) {
        Topic topic = TopicMapper.MAPPER.topicRequestDTOToModel(requestDTO);
        Course course = courseRepository.findByName(requestDTO.getCourseName());

        topic.setCourse(course);

        return topicRepository.save(topic);
    }

    public Topic getTopic(Long id) {
        return topicRepository.getOne(id);
    }

    public Topic updateTopic(Long id, TopicUpdateDTO requestDTO) {
        Topic topic = topicRepository.getOne(id);
        topic.setTitle(requestDTO.getTitle());
        topic.setMessage(requestDTO.getMessage());

        return topicRepository.save(topic);
    }

    public void deleteTopic(Long id) {
        try {
            topicRepository.deleteById(id);
        } catch (EmptyResultDataAccessException e) {
            throw new EntityNotFoundException(e.getMessage());
        }
    }
}
