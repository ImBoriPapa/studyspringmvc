package review.studyspringmvc.testController.request;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpEntity;
import org.springframework.stereotype.Controller;
import org.springframework.util.StreamUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.io.Writer;
import java.nio.charset.StandardCharsets;

@Slf4j
@Controller
public class RequestBodyTextController {

    @PostMapping("/request-body-text-v1")
    public void requestBodyTextV1(HttpServletRequest request, HttpServletResponse response) throws IOException {
        ServletInputStream inputStream = request.getInputStream();
        String messageBody = StreamUtils.copyToString(inputStream, StandardCharsets.UTF_8);

        log.info("messageBody={}",messageBody);

        response.getWriter().write(messageBody);
    }

    @PostMapping("/request-body-text-v2")
    public void requestBodyTextV2(InputStream inputStream, Writer responseWriter) throws IOException {

        String messageBody = StreamUtils.copyToString(inputStream, StandardCharsets.UTF_8);

        log.info("messageBody={}",messageBody);

        responseWriter.write(messageBody);
    }

    @PostMapping("/request-body-text-v3")
    public HttpEntity<String> requestBodyTextV3(HttpEntity<String> httpEntity) throws IOException {

        String messageBody = httpEntity.getBody();

        log.info("messageBody={}",messageBody);

        return new HttpEntity<>(messageBody);
    }

    @ResponseBody
    @PostMapping("/request-body-text-v4")
    public String requestBodyTextV4(@RequestBody String messageBody) throws IOException {

        log.info("messageBody={}",messageBody);

        return messageBody;
    }
}
