package depaul.csc452.group2.campusconnect;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;

import lombok.Data;

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
}
}
