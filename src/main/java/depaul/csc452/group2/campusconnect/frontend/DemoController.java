package depaul.csc452.group2.campusconnect.frontend;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("hello")
public class DemoController {
    @GetMapping
    public ModelAndView something () {
        ModelAndView mv = new ModelAndView("hellos");
        return mv;
    }
}
