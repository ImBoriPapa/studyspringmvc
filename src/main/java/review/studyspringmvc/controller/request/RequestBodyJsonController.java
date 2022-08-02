package review.studyspringmvc.controller.request;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpEntity;
import org.springframework.stereotype.Controller;
import org.springframework.util.StreamUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import review.studyspringmvc.controller.Student;

import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

@Slf4j
@Controller
public class RequestBodyJsonController {

    private ObjectMapper objectMapper = new ObjectMapper();

    @PostMapping("/request-body-json-v1")
    public void requestBodyForJsonV1(HttpServletRequest request, HttpServletResponse response)throws IOException {
        ServletInputStream inputStream = request.getInputStream();
        String messageBody = StreamUtils.copyToString(inputStream, StandardCharsets.UTF_8);

        log.info("messageBody={}",messageBody);
        Student helloData = objectMapper.readValue(messageBody, Student.class);
        log.info("name={}, age={}",helloData.getName(),helloData.getAge());

        response.getWriter().write("ok");

    }

    @ResponseBody
    @PostMapping("/request-body-json-v2")
    public String requestBodyForJsonV2(@RequestBody String messageBody)throws IOException {

        log.info("messageBody={}",messageBody);
        Student student = objectMapper.readValue(messageBody, Student.class);
        log.info("name={}, age={}",student.getName(),student.getAge());

        return "ok";

    }

    @ResponseBody
    @PostMapping("/request-body-json-v3")
    public String requestBodyForJsonV3(@RequestBody Student student) {

        log.info("name={}, age={}",student.getName(),student.getAge());

        return "ok";

    }

    @ResponseBody
    @PostMapping("/request-body-json-v4")
    public String requestBodyForJsonV4(HttpEntity<Student> httpEntity) {
        Student student = httpEntity.getBody();

        log.info("name={}, age={}",student.getName(),student.getAge());

        return "ok";

    }

    @ResponseBody
    @PostMapping("/request-body-json-v5")
    public Student requestBodyForJsonV5(@RequestBody Student student) {

        log.info("name={}, age={}",student.getName(),student.getAge());

        return student;

    }
}
