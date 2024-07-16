package org.zolusca.inc.Repository;

import org.hibernate.sql.exec.spi.JdbcCallParameterExtractor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.zolusca.inc.Entities.Course;
import org.zolusca.inc.Entities.Student;

import java.util.Optional;

@Repository
public interface CourseRepository extends JpaRepository<Course,Short> {
    Optional<Course> findByName(String name);
}
