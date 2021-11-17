package depaul.csc452.group2.campusconnect.studentFinancialAid;

import javax.persistence.*;
import lombok.Data;
import java.io.Serializable;

@Data
@Entity

public class studentFinancialAid implements Serializable {
    private static final long serialVersionUUID= 1L;

    @Id
    private long financialaidid;
    
    private String financialAidInformation;
    private int financialAidAmount;

    @Column (name = "student_id")
    private long studentid;
}
