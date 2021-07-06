package br.com.thiagocavalieri.forum.repository;

import br.com.thiagocavalieri.forum.model.Course;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseRepository extends JpaRepository<Course, Long> {
    Course findByName(String name);
}
