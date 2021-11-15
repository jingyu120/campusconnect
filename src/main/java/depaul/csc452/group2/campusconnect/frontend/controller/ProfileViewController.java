package depaul.csc452.group2.campusconnect.frontend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.security.Principal;
import java.util.List;

//Manli
@Controller
public class ProfileViewController {
    	private final Logger LOG = LoggerFactory.getLogger(getClass());

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
