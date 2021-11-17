package depaul.csc452.group2.campusconnect.courses;

import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.Set;

@Controller
@RequestMapping("/courses")
public class CourseController {

    @Autowired
    NoSQLStudentRepository noSQLStudentRepository;

    @Autowired
    courseRepository courseRepository;

    @Autowired
    noSQLCourseRepository noSQLCourseRepository;


    @CrossOrigin(origins = "http://localhost:8080")
    @GetMapping("/info")
    public String courseInformation(Model model) {
        Long campusConnectUserId = UserUtil.getUserId();
        String username = UserUtil.getUsername();
        noSQLStudent student = noSQLStudentRepository.findBystudentid(campusConnectUserId);
        Set<String> curCourses = student.currentRegisStudents();
        List<Course> curList = new ArrayList<>();
        List<noSQLCourse> nosqlList = new ArrayList<>();
        List<Course> allCourse = courseRepository.findAll();
        for (String cid : curCourses) {
            Course course = courseRepository.findBycourseid(Long.valueOf(cid));
            noSQLCourse nosql = noSQLCourseRepository.findBycourseid(Long.valueOf(cid));
            currentList.add(course);
            nosqlList.add(nosql);
            allCourse.remove(course);
        }


        model.addAttribute("curList", currentList);
        model.addAttribute("nosqlList", nosqlList);
        model.addAttribute("allCourse", allCourse);
        model.addAttribute("sid", campusConnectUserId);
        return "courses";

    }
}
