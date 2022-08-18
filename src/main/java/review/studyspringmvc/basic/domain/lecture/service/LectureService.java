package review.studyspringmvc.basic.domain.lecture.service;

import review.studyspringmvc.basic.domain.lecture.entity.Lecture;

import java.util.List;
import java.util.Optional;

public interface LectureService {


    Lecture save(Lecture lecture);

    Optional<Lecture> findById(Long id);

    List<Lecture> findAll();

    void update(Long id, Lecture updateParam);

    void clearStore();
}
