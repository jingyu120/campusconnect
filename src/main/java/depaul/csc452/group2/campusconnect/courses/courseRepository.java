package depaul.csc452.group2.campusconnect.courses;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface courseRepository extends JpaRepository<Courses, Long> {
    public Courses findBycourseid(Long cid);
    public List<Courses> findAll();
}
