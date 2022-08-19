package review.studyspringmvc.basic.domain.lecture.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import review.studyspringmvc.basic.domain.lecture.entity.Lecture;
import review.studyspringmvc.basic.domain.lecture.service.LectureService;

import javax.annotation.PostConstruct;
import java.util.List;
import java.util.Optional;

@Slf4j
@Controller
@RequestMapping("/basic/lectures")
@RequiredArgsConstructor
public class LectureController {

    private final LectureService lectureService;

    @GetMapping
    public String lectures(Model model) {
        List<Lecture> lectures = lectureService.findAll();
        model.addAttribute("lectures", lectures);
        return "/basic/lecture/lectures";
    }

    @GetMapping("/{lectureId}")
    public String lecture(@PathVariable long lectureId,Model model) {
        Optional<Lecture> lecture = lectureService.findById(lectureId);

        model.addAttribute("lecture", lecture.get());

        return "/basic/lecture/lecture";
    }

    /**
     * 테스트용 데이터 추가
     */
    @PostConstruct
    public void init() {
        lectureService.save(new Lecture("자료구조",10000,2020));
        lectureService.save(new Lecture("운영체제",20000,2021));
        lectureService.save(new Lecture("네트워크",30000,2022));
    }

}
