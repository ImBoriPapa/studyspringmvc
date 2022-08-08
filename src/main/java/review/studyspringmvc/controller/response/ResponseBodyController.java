package review.studyspringmvc.controller.response;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import review.studyspringmvc.controller.Student;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Slf4j
@RestController
public class ResponseBodyController {

    @GetMapping("/response-body-v1")
    public void responseBodyV1(HttpServletResponse response) throws IOException {
        log.info("responseBodyV1");
        response.getWriter().write("ok");
    }

    @GetMapping("/response-body-v2")
    public ResponseEntity<String> responseBodyV2() {
        log.info("responseBodyV2");
        return new ResponseEntity<>("ok", HttpStatus.OK);
    }


    @GetMapping("/response-body-v3")
    public String responseBodyV3() {
        log.info("responseBodyV3");
        return "ok";
    }

    @GetMapping("/response-body-student-v1")
    public ResponseEntity<Student> responseBodyStudentV1() {
        log.info("responseBodyStudentV1");
        Student student = new Student();
        student.setName("학생1");
        student.setAge(20);

        return new ResponseEntity<>(student, HttpStatus.OK);
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/response-body-student-v2")
    public Student responseBodyStudentV2() {
        log.info("responseBodyStudentV2");
        Student student = new Student();
        student.setName("학생1");
        student.setAge(20);

        return student;
    }


}
