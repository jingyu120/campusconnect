package depaul.csc452.group2.campusconnect;

import lombok.Data;

import java.sql.Date;
import java.sql.Date;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.GeneratedValue;
import javax.validation.constraints.Email;


@Data
@Entity 
@Table(name = "StudentResources")
public class StudentResources {
    @Id 
    private int resourceID;

    @Column(name ="universityNews ")
    private String universityNews;

    @Column(name = "immunizationStatus")
    private String immunizationStatus; 
}
