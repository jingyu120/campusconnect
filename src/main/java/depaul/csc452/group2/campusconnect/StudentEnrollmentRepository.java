package depaul.csc452.group2.campusconnect;

import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentEnrollmentRepository extends JpaRepository<StudentEnrollment, StudentCourse> {

}
