package review.studyspringmvc.domain.item.repository;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import review.studyspringmvc.basic1.domain.lecture.entity.Lecture;
import review.studyspringmvc.basic1.domain.lecture.repository.LectureRepository;
import review.studyspringmvc.basic1.domain.lecture.repository.MemoryLectureRepository;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.*;


class LectureRepositoryTest {

    LectureRepository lectureRepository = new MemoryLectureRepository();

    @AfterEach
    void afterEach() {
        lectureRepository.clearStore();
    }

    @DisplayName("강의 등록")
    @Test
    public void save() throws Exception{
        //given
        Lecture lecture = new Lecture("Spring",10000,10);

        //when
        Lecture saveLecture = lectureRepository.save(lecture);
        //then
        Optional<Lecture> findLecture = lectureRepository.findById(lecture.getId());
        assertThat(findLecture.get()).isEqualTo(saveLecture);
    }

    @DisplayName("강의 목록 전체 조회")
    @Test
    public void findAll() throws Exception{
        //given
        Lecture lecture1 = new Lecture("Spring",10000,10);
        Lecture lecture2 = new Lecture("JPA",12000,15);
        Lecture lecture3 = new Lecture("Java",15000,5);

        lectureRepository.save(lecture1);
        lectureRepository.save(lecture2);
        lectureRepository.save(lecture3);
        //when
        List<Lecture> result = lectureRepository.findAll();

        //then
        assertThat(result.size()).isEqualTo(3);
        assertThat(result).contains(lecture1,lecture2,lecture3);
    }

    @DisplayName("강의 등록 수정")
    @Test
    public void updateLecture() throws Exception{
        //given
        Lecture lecture = new Lecture("Spring",10000,10);

        Lecture savedLecture = lectureRepository.save(lecture);
        Long lectureId = savedLecture.getId();

        //when
        Lecture updateParam = new Lecture("SpringMVC", 13000, 50);
        lectureRepository.update(lectureId, updateParam);

        //then
        Optional<Lecture> findLecture = lectureRepository.findById(lectureId);
        assertThat(findLecture.get().getLectureName()).isEqualTo(updateParam.getLectureName());
        assertThat(findLecture.get().getPrice()).isEqualTo(updateParam.getPrice());
        assertThat(findLecture.get().getNumberOfLecture()).isEqualTo(updateParam.getNumberOfLecture());

    }
}