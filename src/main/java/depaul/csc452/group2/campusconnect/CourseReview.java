package depaul.csc452.group2.campusconnect;

import java.sql.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "reviews")
public class CourseReview {
    @Id
    private String course;
    private String review;
    private String reviewer;
    private Date reviewDate;
}
