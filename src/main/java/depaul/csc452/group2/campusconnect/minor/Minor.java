package depaul.csc452.group2.campusconnect;
import javax.persistence.*;
import javax.validation.constraints.Email;

import lombok.Data;

import java.util.ArrayList;

@Data
@Entity
@Table(name = "Minor")


//(Manli)Minor: minorID(p), minorName, required classes, electives, units required

public class Minor {
    @Id
    @GeneratedValue
    private long minorID;

    @Column(name = "minor courses: ")
    private String minorName;

    @Email(message = "classes required: ")
    private String requiredClasses;

    private String electives;

    private String units;
    
    @OneToMany(fetch = FetchType.LAZY, targetEntity = Course.class,cascade = {CascadeType.ALL})
    private List<Course> courseList = new ArrayList<>();

}
