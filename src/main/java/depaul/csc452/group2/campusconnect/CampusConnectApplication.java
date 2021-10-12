package depaul.csc452.group2.campusconnect;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@SpringBootApplication
public class CampusConnectApplication {
	private static final Logger log = LoggerFactory.getLogger(CampusConnectApplication.class);
////
//	@Bean
//	public CommandLineRunner saveCourseReview(CourseReviewRepository repository) {
//		return (args) -> {
//			CourseReview review1 = new CourseReview();
//			review1.setCourse("hello");
//			review1.setReview("some data");
//			repository.save(review1);
//
//			CourseReview review2 = new CourseReview();
//			review2.setCourse("SE420");
//			review2.setReview("less Fun");
//			repository.save(review2);
//		};
//	}
//
//	@Bean
//	public CommandLineRunner showCourseReview(CourseReviewRepository repository) {
//		return (args) -> {
//			List<CourseReview> reviews = repository.findAll();
//			for (CourseReview review : reviews) {
//				log.info(review.toString());
//				System.out.println(review);
//			}
//		};
//	}

	@Bean
	public CommandLineRunner addStudent(StudentRepository repository) {
		return (args) -> {
			// fetch all Course
			log.info("Before James: " + repository.count());
			Student student = new Student();
			student.setEmail("james@bond.uk");
			student.setName("James Bond");
			repository.save(student);
			log.info("After James: " + repository.count());
		};
	}

	public static void main(String[] args) {
		SpringApplication.run(CampusConnectApplication.class, args);
	}
}
