package depaul.csc452.group2.campusconnect;
import javax.persistence.*;
import javax.validation.constraints.Email;

import lombok.Data;

import java.util.ArrayList;

@Data
@Entity
@Table(name = "Major")


//(Manli)Major: majorID(p), majorName, required classes, electives, units required

public class Major {
    @Id
    @GeneratedValue
    private long majorID;

    @Column(name = "nm")
    private String majorName;

    @Email(message = "classes required: ")
    private String requiredClasses;

    private String electives;

    private String units;

    @OneToMany(fetch = FetchType.LAZY, targetEntity = Course.class,cascade = {CascadeType.ALL})
    private List<Course> courseList = new ArrayList<>();

}
