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
@Table(name = "Tasks")

public class Tasks {
    @Id 
    private int taskID;
    
    @Column(name ="userID")
     private int userID;

     @Column(name ="holds")
     private String holds;

     @Column(name ="toDoList")
     private String toDoList;
}