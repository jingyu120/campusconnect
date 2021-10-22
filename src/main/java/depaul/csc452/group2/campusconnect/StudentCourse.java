package depaul.csc452.group2.campusconnect;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Embeddable;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import java.io.Serializable;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Embeddable
public class StudentCourse implements Serializable {
    @NotNull
    private String studentID;

    @NotNull
    private String courseID;
}
