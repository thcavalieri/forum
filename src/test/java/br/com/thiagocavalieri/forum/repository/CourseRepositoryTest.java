package br.com.thiagocavalieri.forum.repository;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

@DataJpaTest
public class CourseRepositoryTest {

    @Autowired
    private CourseRepository courseRepository;

    @Test
    public void findCourseByNameTest() {
        var courseName = "HTML 5";
        var course = courseRepository.findByName(courseName);

        Assertions.assertNotNull(course);
        Assertions.assertEquals(courseName, course.getName());
    }
}
