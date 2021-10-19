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
@Table(name = "Transactions")
public class Transactions {
    @Id
    @GeneratedValue
    private long TransactionsID;


    @Column(name = "student_id")
    private String studentID;

    @Column(name = "amount")
    private int amount;

    @Column(name = "payment info")
    private String payment_info;

    @Column(name = "payment details (memo)")
    private String payment_details;
}
