package br.com.thiagocavalieri.forum.repository;

import br.com.thiagocavalieri.forum.model.Course;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;

@ActiveProfiles("test")
@DataJpaTest
public class CourseRepositoryTest {

    @Autowired
    private CourseRepository courseRepository;

    @Test
    public void findCourseByNameTest() {
        var courseName = "HTML 5";

        var course = new Course();
        course.setName(courseName);
        course.setCategory("Front-end");

        courseRepository.save(course);

        course = courseRepository.findByName(courseName);

        Assertions.assertNotNull(course);
        Assertions.assertEquals(courseName, course.getName());
    }
}
