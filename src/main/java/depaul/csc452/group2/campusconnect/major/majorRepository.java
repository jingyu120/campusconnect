package depaul.csc452.group2.campusconnect.major;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface majorRepository extends JpaRepository<Major, Long>  {
    public Major findByMajorName(String majorName);

}
