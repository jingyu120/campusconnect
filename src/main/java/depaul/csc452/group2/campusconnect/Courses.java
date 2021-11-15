package depaul.csc452.group2.campusconnect;

import java.sql.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Transient;

//(Manli)Courses: courseID(p),  courseName, prerequisite, requiredText

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "Courses")
public class Courses {
    @Transient
    public static final String SEQUENCE_NAME = "courses_sequence";

    @Id
    private long courseID;


    private String courseName;
    private String prerequisite;

}
