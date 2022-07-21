package review.studyspringmvc.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@Slf4j
//@Controller
@RestController
public class MemberController {

    @RequestMapping(value = {"/members","/users","/memberlist"},method = RequestMethod.GET)
    public String members() {
        log.info("call this");
        return "members";
    }
    /*
    @RequestMapping(value = "/mapping_method",method = RequestMethod.GET)
    @RequestMapping(value = "/mapping_method",method = RequestMethod.POST)
    @RequestMapping(value = "/mapping_method",method = RequestMethod.PATCH)
    @RequestMapping(value = "/mapping_method",method = RequestMethod.PUT)
    @RequestMapping(value = "/mapping_method",method = RequestMethod.DELETE)
     */
    /**
     * 편리한 축약 애노테이션 (코드보기) * @GetMapping
     * @PostMapping
     * @PutMapping
     * @DeleteMapping
     * @PatchMapping
     */

    @GetMapping("/membermapping")
    public String memberMapping(){
        log.info("memberMapping");
        return "membermapping";
    }
    /**
     * PathVariable 사용
     * 변수명이 같으면 생략 가능
     * @PathVariable("userId") String userId -> @PathVariable userId */
    @GetMapping("/membermapping/{userId}")
    public String memberMappingPath(@PathVariable("userId") String data){
        log.info("memberMappingPath userId ={}",data);
        return "members path = "+data;
    }



}
