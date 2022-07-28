package review.studyspringmvc.controller.request;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

@Slf4j
@Controller
public class RequestParamController {

    @RequestMapping("/request-parameter-v1")
    public void requestParameterV1(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String product = request.getParameter("product");
        int product_code = Integer.parseInt(request.getParameter("product_code"));
        log.info("product = {}, product_code ={}", product, product_code);

        response.getWriter().write("OK");

    }

    /**
     * @requestParam
     * @param product
     * @param product_code
     * @return
     */
    @ResponseBody
    @RequestMapping("/request-parameter-v2")
    public String requestParameterV2(
            @RequestParam("product") String product,
            @RequestParam("product_code") int product_code) {
        log.info("product = {}, product_code ={}", product, product_code);
        return "OK";
    }

    @ResponseBody
    @RequestMapping("/request-parameter-v3")
    public String requestParameterV3(
            @RequestParam String product,
            @RequestParam int product_code) {
        log.info("product = {}, product_code ={}", product, product_code);
        return "OK";
    }

    @ResponseBody
    @RequestMapping("/request-parameter-v4")
    public String requestParameterV4(String product, int product_code) {
        log.info("product = {}, product_code ={}", product, product_code);
        return "OK";
    }

    @ResponseBody
    @RequestMapping("/request-parameter-v5")
    public String requestParameterV5(
            @RequestParam(required = true) String product,
            @RequestParam(required = false) Integer product_code) {

        log.info("product = {}, product_code ={}", product, product_code);
        return "OK";
    }

    @ResponseBody
    @RequestMapping("/request-parameter-v6")
    public String requestParameterV6(
            @RequestParam(required = true,defaultValue = "nothing") String product,
            @RequestParam(required = false,defaultValue = "-1") Integer product_code) {

        log.info("product = {}, product_code ={}", product, product_code);
        return "OK";
    }

    @ResponseBody
    @RequestMapping("/request-parameter-v7")
    public String requestParameterV7(@RequestParam Map<String,Object> paramMap) {

        log.info("product = {}, product_code ={}", paramMap.get("product"), paramMap.get("product_code"));
        return "OK";
    }
}
