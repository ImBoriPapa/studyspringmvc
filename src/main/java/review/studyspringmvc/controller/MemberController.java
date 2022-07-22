package review.studyspringmvc.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@Slf4j
//@Controller
@RestController
public class MemberController {

    @RequestMapping(value = {"/members", "/users", "/memberlist"}, method = RequestMethod.GET)
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
     * 편리한 축약 애노테이션
     *
     * @GetMapping
     * @PostMapping
     * @PutMapping
     * @DeleteMapping
     * @PatchMapping
     */

    @GetMapping("/membermapping")
    public String memberMapping() {
        log.info("memberMapping");
        return "membermapping";
    }

    /**
     * PathVariable 사용
     * 변수명이 같으면 생략 가능
     *
     * @PathVariable("userId") String userId -> @PathVariable userId
     */
    @GetMapping("/memberMapping/{userId}")
    public String memberMappingPath(@PathVariable("userId") String data) {
        log.info("memberMappingPath userId ={}", data);
        return "members path = " + data;
    }

    /**
     * PathVariable 사용 다중
     */
    @GetMapping("/memberMapping/{userId}/address/{location}/post/{postNumber}")
    public String memberMappingPath2(@PathVariable("userId") String data,
                                     @PathVariable String location,
                                     @PathVariable int postNumber) {
        log.info("memberMappingPath userId ={}, location={}", data, location);
        return "members path = " + data + ", location =" + location + ", postNumber =" + postNumber;
    }

    /**
     * 파라미터로 추가 매핑
     * params="isWorking",
     * params="!isWorking"
     * params="isWorking=isWorking"
     * params="isWorking!=isWorking" (! = )
     * params = {"mode=debug","data=good"}
     */
    @GetMapping(value = "/memberMapping-param", params = "isWorking")
    public String memberMappingParam() {
        log.info("memberMapping-param");
        return "memberMapping-param";
    }

    /**
     * 특정 헤더로 추가 매핑
     * isWorking
     */
    @GetMapping(value = "/memberMapping-header", headers = "this=isWorking")
    public String memberMappingHeader() {
        log.info("memberMappingHeader");
        return "memberMappingHeader - is Working";
    }

    /**
     * Content-Type 헤더 기반 추가 매핑 Media Type * consumes="application/json"
     * * consumes="!application/json"
     * * consumes="application/*"
     * * consumes="*\/*"
     * * MediaType.APPLICATION_JSON_VALUE
     */
    @PostMapping(value = "/memberMapping-consume", consumes = "application/json")
    public String memberMappingConsumes() {
        log.info("memberMappingConsumes");
        return "ok";
    }

    /**
     * Accept 헤더 기반 Media Type * produces = "text/html"
     * produces = "!text/html" * produces = "text/*"
     * produces = "*\/*"
     */
    @PostMapping(value = "/memberMapping-produce", produces = "text/html")
    public String memberMappingProduces() {
        log.info("memberMappingProduces");
        return "ok";
    }
}

