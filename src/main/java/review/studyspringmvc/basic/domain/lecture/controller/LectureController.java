package review.studyspringmvc.basic.domain.lecture.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import review.studyspringmvc.basic.domain.lecture.entity.Lecture;
import review.studyspringmvc.basic.domain.lecture.service.LectureService;

import javax.annotation.PostConstruct;
import java.util.List;
import java.util.Optional;

@Slf4j
@Controller
@RequestMapping("/basic/lectures") // url /basic/lectures 으로 요청을 처리한다. 하위에서 /basic/lectures 을 생략할 수 있다.
@RequiredArgsConstructor
public class LectureController {

    private final LectureService lectureService;

    /**
     * Url 매핑 /basic/lectures 이 생략됨
     *
     * 저장된 Lecture 를 조회해서
     * model.addAttribute() 로 뷰에 전달
     */
    @GetMapping
    public String lectures(Model model) {
        List<Lecture> lectures = lectureService.findAll();
        model.addAttribute("lectures", lectures);
        return "basic/lecture/lectures";
    }

    /**
     * Url 매핑 /basic/lectures/{lectureId}
     * GetMapping 으로 쿼리 파라미터에 조회할 강의에 lectureId를 받아 조회 후 결과값을 뷰로 전달
     * lecture.get() - Optional.get() 예제를 간단히 하기 위해 사용
     */
    @GetMapping("/{lectureId}")
    public String lecture(@PathVariable long lectureId,Model model) {
        Optional<Lecture> lecture = lectureService.findById(lectureId);

        model.addAttribute("lecture", lecture.get());

        return "basic/lecture/lecture";
    }

    /**
     * Url 매핑 /basic/lectures/add
     * GetMapping 으로 요청시 addForm 뷰를 응답
     */
    @GetMapping("/add")
    public String addForm() {
        return "basic/lecture/addForm";
    }

    /**
     * Url 매핑 /basic/lectures/add
     * PostMapping 으로 요청시
     * @ModelAttribute Lecture lecture 로 전달된 값을 저장
     * RedirectAttributes redirectAttributes : 저장 된 후 응답을 redirect 할 때 필요한 정보를 담는다.
     */
    @PostMapping("/add")
    public String addLecture(@ModelAttribute Lecture lecture, RedirectAttributes redirectAttributes) {

        Lecture savedLecture = lectureService.save(lecture);
        redirectAttributes.addAttribute("lectureId", savedLecture.getId());
        redirectAttributes.addAttribute("status", true);
        return "redirect:/basic/lectures/{lectureId}";
    }

    /**
     * Url 매핑 /basic/lectures/{lectureId}/edit
     * GetMapping 으로 요청시
     * lectureId 로 조회 한 결과를 수정 뷰로 전달해서 응답
     */
    @GetMapping("/{lectureId}/edit")
    public String editForm(@PathVariable Long lectureId, Model model) {
        Optional<Lecture> optionalLecture = lectureService.findById(lectureId);
        model.addAttribute("lecture", optionalLecture.get());
        return "basic/lecture/editForm";
    }

    /**
     * Url 매핑 /basic/lectures/{lectureId}/edit
     * PostMapping 으로 요청시
     * lectureId 로 조회 한 결과에 @ModelAttribute Lecture lecture 로 전달된 내용으로 업데이트 후
     * 리다이렉트
     */
    @PostMapping("/{lectureId}/edit")
    public String edit(@PathVariable Long lectureId,@ModelAttribute Lecture lecture) {
        lectureService.update(lectureId,lecture);
        return "redirect:/basic/lectures/{lectureId}";
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
