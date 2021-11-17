package depaul.csc452.group2.campusconnect.minor;

import depaul.csc452.group2.campusconnect.courses.noSQLCourse;
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
class minorController {

    @Autowired
    private minorRepository minorRepository;
    @Autowired
    private courseRepository courseRepository;
    @Autowired
    private noSQLCourseRepository noSQLCourseRepository;

    @CrossOrigin(origins = "http://localhost:8080")
    @GetMapping("/majorinfo/{name}")
    public String minorDetails(@PathVariable String name) {
        return minorRepository.findByminorname(name).toString();
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
        Minor currentMinor = minorRepository.findBymajorname(name);
        noSQLCourse courseNoSQL = new noSQLCourse();
        courseNoSQL.setCourseid(newCourse.getCourseid());
        newCourse.setMinor(currentMinor);
        noSQLCourseRepository.save(courseNoSQL);
        currentMinor.getCourseList().add(newCourse);
        minorRepository.save(currentMinor);

    }

    @CrossOrigin(origins = "http://localhost:8080")
    @PutMapping("/update/{name}")
    public void updateMajorDetails(@RequestBody Minor newMinor, @PathVariable int name) {
        minorRepository.save(newMinor);
    }


}
