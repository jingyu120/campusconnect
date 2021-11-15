package depaul.csc452.group2.campusconnect.courses;
import java.io.Serializable;
import java.util.*;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "courseInformation")
public class noSQLCourse implements Serializable {

    @Id
    private long courseid;

    private String courseName;
    private String prerequisite;

}
