package depaul.csc452.group2.campusconnect;

import java.sql.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.Transient;

//(Manli)Courses: courseID(p),  courseName, prerequisite, requiredText

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "Courses")
public class Courses {
    @Transient
    public static final String SEQUENCE_NAME = "course list";

    @Id
    private long courseID;


    private String courseName;
    private String prerequisite;


    @ManyToOne(fetch = FetchType.LAZY, targetEntity = Professor.class)
    private Professor professor;

    @ManyToOne(fetch = FetchType.LAZY, targetEntity = Major.class)
    private Major major;

}
