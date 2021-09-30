package br.com.thiagocavalieri.forum.repository;

import br.com.thiagocavalieri.forum.model.Topic;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TopicRepository extends JpaRepository<Topic, Long> {
    Page<Topic> findByCourseName(String courseName, Pageable pagination);
}
