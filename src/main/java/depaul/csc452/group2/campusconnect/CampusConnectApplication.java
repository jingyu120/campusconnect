package depaul.csc452.group2.campusconnect;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import depaul.csc452.group2.campusconnect.Student;
import depaul.csc452.group2.campusconnect.UserProfile;
import depaul.csc452.group2.campusconnect.UserProfileRepository;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication

@Controller
public class CampusConnectApplication {
    private static final Logger log = LoggerFactory.getLogger(CampusConnectApplication.class);

    @Autowired
    private StudentRepository studentrepository;

    @Autowired
    private UserProfileRepository userRepository;

    @Autowired
    private noSQLStudentRepository noSQLStudentRepository;


    @GetMapping("/")
    public String start() {
        return "homepage";
    }
    
    @GetMapping("/login")
    public String login() {return "login"; }

    @GetMapping("/home")
    public String home() {
        return "homepage";
    }


    @Bean
    public CommandLineRunner saveUserProfile(UserProfileRepository repository) {
        return (args) -> {
            UserProfile profile = new UserProfile();
            profile.setUserID(1);
            profile.setEmail("myemail@gmail.com");
            profile.setGender("male");
            repository.save(profile);

            UserProfile profile2 = new UserProfile();
            profile2.setUserID(2);
            profile2.setEmail("goldentanchy@gmail.com");
            profile2.setGender("female");
            repository.save(profile);

            List<UserProfile> profiles = repository.findAll();
            for (UserProfile p : profiles) {
                log.info(p.toString());
                System.out.println(p);
            }
        };
    }

	@Bean
	public CommandLineRunner saveStudent(StudentRepository repository) {
		return (args) -> {
			Student s1 = new Student();
			s1.setName("JZ");
			s1.setMajor("Computer Science");
			repository.save(s1);

			Student s2 = new Student();
			s2.setName("Vanessa");
			s2.setMajor("Civil Engineering");
			repository.save(s2);

			List<Student> students = repository.findAll();
			for (Student s : students) {
				log.info(s.toString());
				System.out.println(s);
			}
		};
	}
//
//	@Bean
//	public CommandLineRunner addStudent(StudentRepository repository) {
//		return (args) -> {
//			// fetch all Course
//			Student student2 = new Student();
//			student2.setEmail("student@gmail.com");
//			student2.setName("Jon Snow");
//			student2.setMajor("WinterMajor");
//			repository.save(student2);
//
//			Student student = new Student();
//			student.setEmail("james@bond.uk");
//			student.setName("James Bond");
//			student.setMajor("Computer Science");
//			repository.save(student);
//
//			List<Student> students = repository.findAll();
//			for (Student s : students) {
//				log.info(s.toString());
//				System.out.println(s);
//			}
//		};
//	}

    public static void main(String[] args) {
        SpringApplication.run(CampusConnectApplication.class, args);
    }
}
