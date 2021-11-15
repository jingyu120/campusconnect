package depaul.csc452.group2.campusconnect.studentFinancialAid;

import org.springframework.stereotype.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface financialAidRepository extends JpaRepository<FinancialAid, Long>  {
    public financialAid findBystudentid(Long studentid);
}
