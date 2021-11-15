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
@Table(name = "Minor")


//(Manli)Minor: minorID(p), minorName, required classes, electives, units required

public class Minor {
    @Id
    @GeneratedValue
    private long minorID;

    @Column(name = "nm")
    private String minorName;

    @Email(message = "classes required: ")
    private String requiredClasses;

    private String electives;

    private String units;
}
}
