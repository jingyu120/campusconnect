package depaul.csc452.group2.campusconnect.frontend.controller;

import Design.CampusConnect.OffsetPageable;
import Design.CampusConnect.entity.Group;
import Design.CampusConnect.entity.Post;
import Design.CampusConnect.entity.Student;
import Design.CampusConnect.service.GroupService;
import Design.CampusConnect.service.PostService;
import Design.CampusConnect.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.security.Principal;
import java.util.List;

//Manli
@Controller
public class ProfileViewController {
    @Autowired
    GroupService groupService;
    @Autowired
    UserService userService;
    @Autowired
    PostService postService;

    @RequestMapping("/Profile")
    public String profile(Principal principal, Model model) {
        model.addAttribute("user", userService.findByName(principal.getName()));
        model.addAttribute("username", principal.getName());
        Student student = userService.findByName(principal.getName());
        System.out.println(groupService.getGroupsStudentBelongsToById(student.getId()));
      
    }

    @RequestMapping("/adduser")
    public String adduser(Model model) {
        return "AddUserForm";
    }


}
