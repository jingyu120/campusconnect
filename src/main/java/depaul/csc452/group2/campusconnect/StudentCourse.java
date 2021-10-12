package depaul.csc452.group2.campusconnect;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Embeddable
@Data
@AllArgsConstructor
public class StudentCourse implements Serializable {
    @NotNull
    private String studentID;

    @NotNull
    private String courseID;
}
