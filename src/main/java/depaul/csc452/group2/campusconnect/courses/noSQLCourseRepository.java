package depaul.csc452.group2.campusconnect.courses;

import java.util.List;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface noSQLCourseRepository extends MongoRepository<noSQLCourse, Long> {
    public noSQLCourse findBycourseid(Long courseid);
    public List<noSQLCourse> findAll();


}
