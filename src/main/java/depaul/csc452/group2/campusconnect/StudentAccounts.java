package depaul.csc452.group2.campusconnect;
import java.sql.Date;
import java.sql.Date;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;

import lombok.Data;

@Data
@Entity
@Table(name = "StudentAccounts")
public class StudentAccounts {
    @Id
    @GeneratedValue
    private long acountID;


    @Column(name = "usr_id")
    private String userID;

    @Column(name = "employer_tuition_deferral")
    private String employer_tuition_deferral;

    @Column(name = "balance")
    private int account_balance;

    @Column(name = "name")
    private Date aidDate;

    private String tasks;
}
