package review.studyspringmvc.basic.domain.lecture.repository;

import org.springframework.stereotype.Repository;
import review.studyspringmvc.basic.domain.lecture.entity.Lecture;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

@Repository
public class MemoryLectureRepository implements LectureRepository{

    private static final Map<Long, Lecture> store = new ConcurrentHashMap<>();

    private static AtomicLong sequence = new AtomicLong();

    public Lecture save(Lecture lecture) {
        lecture.setId(sequence.incrementAndGet() );
        store.put(lecture.getId(), lecture);
        return lecture;
    }

    public Optional<Lecture> findById(Long id) {
        return Optional.ofNullable(store.get(id));
    }

    public List<Lecture> findAll() {
        return new ArrayList<>(store.values());
    }

    public void update(Long id, Lecture updateParam) {
        Optional<Lecture> findLecture = findById(id);

        findLecture.get().setLectureName(updateParam.getLectureName());
        findLecture.get().setPrice(updateParam.getPrice());
        findLecture.get().setNumberOfLecture(updateParam.getNumberOfLecture());
    }

    public void clearStore() {
        store.clear();
    }
}
