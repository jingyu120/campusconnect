package depaul.csc452.group2.campusconnect;

import java.sql.Date; 
import java.sql.Date;
import java.util.UUID; 

import lombok.Data;


import javax.persistence.Entity;
import javax.persistence.Column; 
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.Table;
import javax.validation.constraints.Email;


@Table(name = "AcademicRecords")
@Data
@Entity

public class AcademicRecords {
       @Id 
       @GeneratedValue
       private int recordID; 

       @Column(name = "courseID")
       private int courseID; 

       @Column(name = "studentID")
       private long studentID;
    
       @Column(name = "courseGrade")
       private String courseGrade;
    
    
}
