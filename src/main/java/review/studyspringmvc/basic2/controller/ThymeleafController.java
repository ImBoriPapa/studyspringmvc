package review.studyspringmvc.basic2.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/thymeleaf")
public class ThymeleafController {

    @GetMapping
    public String home() {
        return "thymeleaf/thymeleaf_home";
    }

    @GetMapping("/text-basic")
    public String textBasic(Model model) {
        model.addAttribute("text1", "Hello thymeleaf!!");
        model.addAttribute("text2", "Hello <b>thymeleaf</b>!!");
        return "thymeleaf/text-basic";
    }

}
