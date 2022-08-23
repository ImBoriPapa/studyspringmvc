package review.studyspringmvc.basic2.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import review.studyspringmvc.basic2.dto.MemberDTO;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import static review.studyspringmvc.basic2.dto.MemberDTO.MemberRole.*;

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

    @GetMapping("/variable")
    public String variable(Model model) {
        MemberDTO memberA = new MemberDTO("memberA", GUEST);
        MemberDTO memberB = new MemberDTO("memberB", VIP);
        MemberDTO memberC = new MemberDTO("memberC", VIP);

        ArrayList<MemberDTO> list = new ArrayList<>();
        list.add(memberA);
        list.add(memberB);
        list.add(memberC);

        Map<String, MemberDTO> map = new HashMap<>();
        map.put("memberA", memberA);
        map.put("memberB", memberB);
        map.put("memberC", memberC);

        model.addAttribute("member", memberA);
        model.addAttribute("members", list);
        model.addAttribute("memberMap", map);

        return "thymeleaf/variable";
    }





}
