package review.studyspringmvc.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
//@Controller
@RestController
public class MemberController {

    @RequestMapping(value = {"/members","/users","/memberlist"})
    public String members() {
        log.info("call this");
        return "members";
    }
}
