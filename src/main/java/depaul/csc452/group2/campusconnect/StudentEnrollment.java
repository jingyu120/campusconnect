package depaul.csc452.group2.campusconnect;
import java.sql.Date;
import java.sql.Date;
import java.util.UUID;

import javax.persistence.*;
import javax.validation.constraints.Email;

import lombok.Data;

@Data
@Entity
public class StudentEnrollment {

    @EmbeddedId
    private StudentCourse studentCourse;

    @Column
    private String enrolledPeriod;
}
