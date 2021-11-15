package depaul.csc452.group2.campusconnect.minor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface minorRepository extends JpaRepository<Minor, Long>  {
    public Minor findByMinorName(String minorName);

}
