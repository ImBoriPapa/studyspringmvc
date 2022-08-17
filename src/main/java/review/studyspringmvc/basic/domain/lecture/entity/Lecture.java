package review.studyspringmvc.basic.domain.lecture.entity;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class Lecture {
    private Long id;
    private String lectureName;
    private Integer price;
    private Integer numberOfLecture;

    public Lecture() {
    }

    public Lecture(String lectureName, Integer price, Integer numberOfLecture) {
        this.lectureName = lectureName;
        this.price = price;
        this.numberOfLecture = numberOfLecture;
    }
}
