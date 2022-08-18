package review.studyspringmvc.basic.domain.lecture.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import review.studyspringmvc.basic.domain.lecture.entity.Lecture;
import review.studyspringmvc.basic.domain.lecture.repository.LectureRepository;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class BasicLectureService implements LectureService{

    private final LectureRepository lectureRepository;

    @Override
    public Lecture save(Lecture lecture) {
        return lectureRepository.save(lecture);
    }

    @Override
    public Optional<Lecture> findById(Long id) {
        return lectureRepository.findById(id);
    }

    @Override
    public List<Lecture> findAll() {
        return lectureRepository.findAll();
    }

    @Override
    public void update(Long id, Lecture updateParam) {
        lectureRepository.update(id,updateParam);
    }

    @Override
    public void clearStore() {
        lectureRepository.clearStore();
    }
}
