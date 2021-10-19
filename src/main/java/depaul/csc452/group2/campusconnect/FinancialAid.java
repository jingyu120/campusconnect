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
@Table(name = "FinancialAid")
public class FinancialAid {
    @Id
    @GeneratedValue
    private long aidID;


    @Column(name = "student_id")
    private String student_id;

    @Column(name = "aidAmount")
    private int aidAmount;

    @Column(name = "Date of Aid")
    private Date aidDate;

    @Column(name = "Description")
    private String aidDescription;
}
