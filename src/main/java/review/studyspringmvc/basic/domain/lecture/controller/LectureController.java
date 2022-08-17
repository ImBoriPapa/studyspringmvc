package review.studyspringmvc.basic.domain.lecture.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import review.studyspringmvc.basic.domain.lecture.entity.Lecture;
import review.studyspringmvc.basic.domain.lecture.repository.LectureRepository;

import javax.annotation.PostConstruct;
import java.util.List;

@Slf4j
@Controller
@RequestMapping("basic/lectures")
@RequiredArgsConstructor
public class LectureController {

    private final LectureRepository lectureRepository;

    @GetMapping
    public String lectures(Model model) {
        List<Lecture> lectures = lectureRepository.findAll();
        model.addAttribute("lectures", lectures);
        return "/basic/lectures";
    }

    /**
     * 테스트용 데이터 추가
     */
    @PostConstruct
    public void init() {
        lectureRepository.save(new Lecture("자료구조",10000,2020));
        lectureRepository.save(new Lecture("운영체제",20000,2021));
        lectureRepository.save(new Lecture("네트워크",30000,2022));
    }

}
