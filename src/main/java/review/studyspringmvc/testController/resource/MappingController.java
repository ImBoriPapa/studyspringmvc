package review.studyspringmvc.testController.resource;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/mapping/items")
public class MappingController {

    @GetMapping
    public String items() {
        return "items";
    }

    @PostMapping
    public String saveItem() {
        return "saveItem";
    }

    @GetMapping("/{itemId}")
    public String findItem(@PathVariable String itemId) {
        return "findItem =" + itemId;
    }

    @PatchMapping("/{itemId}")
    public String updateItem(@PathVariable String itemId) {
        return "update Item ="+itemId;
    }

    @DeleteMapping("/{itemId}")
    public String deleteItem(@PathVariable String itemId) {
        return "delete item=" + itemId;
    }



}
