package depaul.csc452.group2.campusconnect.major;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/major")
class majorController {

    @Autowired
    private majorRepository majorRepository;
    @Autowired
    private courseRepository courseRepository;
    @Autowired
    private noSQLCourseRepository noSQLCourseRepository;

    @CrossOrigin(origins = "http://localhost:8080")
    @GetMapping("/majorinfo/{name}")
    public String majorDetails(@PathVariable String name) {
        return majorRepository.findBymajorname(name).toString();
    }

    @CrossOrigin(origins = "http://localhost:8080")
    @PutMapping("/update/{name}")
    public void updateMajorDetails(@RequestBody Major newMajor, @PathVariable int name) {
        majorRepository.save(newMajor);
    }

    @CrossOrigin(origins = "http://localhost:8080")
    @DeleteMapping("/deleteCourse/{name}/{cid}")
    public void DeleteCourse(@PathVariable String name, @PathVariable long cid) {
        course deleteCourse = courseRepository.findBycourseid(cid);
        deleteCourse.setMajor(null);
        courseRepository.delete(deleteCourse);
        noSQLCourseRepository.deleteById(deleteCourse.getCourseid());
    }

    @CrossOrigin(origins = "http://localhost:8080")
    @PutMapping("/addCourse/{name}")
    public void addCourse(@PathVariable String name, @RequestBody Course newCourse) {
        Major curMajor = majorRepository.findBymajorname(name);
        CourseNoSQL courseNoSQL = new CourseNoSQL();
        courseNoSQL.setCourseid(newCourse.getCourseid());
        newCourse.setMajor(curMajor);
        courseNoSQLRepository.save(courseNoSQL);
        curMajor.getCourseList().add(newCourse);
        majorRepository.save(curMajor);

    }


}
