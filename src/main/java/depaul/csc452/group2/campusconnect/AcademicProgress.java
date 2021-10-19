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
@Table(name = "Academic Progress")
public class AcademicProgress {
    @Id
    private long studentID;

    @Column(name = "courses required")
    private int[] coursesrequired;

    @Column(name = "courses completed")
    private int[] coursescompleted;

    @Column(name = "courses in progress")
    private int[] coursesinprogress;

    @Column(name = "courses incompleted")
    private int[] coursesincompleted;

    @Column(name = "recordsID")
    private int[] recordsID;

    @Email(message = "advisor")
    private String advisor;
}
