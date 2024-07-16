package org.zolusca.inc.Testing;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.zolusca.inc.Entities.Course;
import org.zolusca.inc.Entities.Student;
import org.zolusca.inc.Repository.CourseRepository;
import org.zolusca.inc.Repository.StudentRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@SpringBootTest
public class ManyToMany {
    @Autowired private CourseRepository courseRepository;
    @Autowired private StudentRepository studentRepository;

    private final String COURSE_NAME = "MATH";
    private final String STUDENT_NAME = "STUART";

    @Test
    @Order(1)
    void insertCourse() {
        Assertions.assertDoesNotThrow(() -> {
            Course math = new Course();
            math.setName(COURSE_NAME);

            courseRepository.save(math);
        });
    }

    @Test
    @Order(2)
    void findCourse(){
        Optional<Course> result =  courseRepository.findByName(COURSE_NAME);
        Assertions.assertNotNull(result.get());
    }

    @Test
    @Order(3)
    void deleteCourse(){
        Assertions.assertDoesNotThrow(()->{
            Optional<Course> result =  courseRepository.findByName(COURSE_NAME);

            courseRepository.delete(result.get());
        });
    }

    @Test
    @Order(4)
    void insertStudentWithCourse(){

        Assertions.assertDoesNotThrow(()->{
            Course math = new Course();
            math.setName(COURSE_NAME);

            Student student1 = new Student();
            student1.setName(STUDENT_NAME);
            student1.setCourses(new ArrayList<>(List.of(math)));

            studentRepository.save(student1);
        });

    }

    @Test
    @Order(5)
    void findStudent(){
        Optional<Student> result =  studentRepository.findByName(STUDENT_NAME);
        Assertions.assertNotNull(result.get());
    }

}
