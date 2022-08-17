package review.studyspringmvc.testController.response;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class ResponseViewController {

    @RequestMapping("/response-view-v1")
    public ModelAndView responseViewV1() {
        ModelAndView modelAndView = new ModelAndView("response/home")
                .addObject("data","welcome home!");
        return modelAndView;
    }

    @RequestMapping("/response-view-v2")
    public String responseViewV2(Model model) {
        model.addAttribute("data", "welcome home!");
        return "response/home";
    }

    @RequestMapping("/response/home")
    public void responseViewV3(Model model) {
        model.addAttribute("data", "welcome home!");
    }
}

