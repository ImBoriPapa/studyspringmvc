package review.studyspringmvc.domain.item.repository;


import review.studyspringmvc.domain.item.entity.Lecture;

import java.util.List;
import java.util.Optional;

public interface LectureRepository {

    Lecture save(Lecture lecture);

    Optional<Lecture> findById(Long id);

    List<Lecture> findAll();

    void update(Long id, Lecture updateParam);

    void clearStore();


}
