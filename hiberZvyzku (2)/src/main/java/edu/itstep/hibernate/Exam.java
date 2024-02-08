package edu.itstep.hibernate;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "exams")
public class Exam {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "exam_name")
    private String examName;

    @Column(name = "exam_datetime")
    private LocalDateTime examDatetime;

    @Column(name = "exam_address")
    private String examAddress;

    @ManyToMany(cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
    @JoinTable(name = "student_exams",
            joinColumns = @JoinColumn(name = "id_exam"),
            inverseJoinColumns = @JoinColumn(name = "id_student")
    )
    private List<Student> students = new ArrayList<>();

    public Exam() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getExamName() {
        return examName;
    }

    public void setExamName(String examName) {
        this.examName = examName;
    }

    public LocalDateTime getExamDatetime() {
        return examDatetime;
    }

    public void setExamDatetime(LocalDateTime examDatetime) {
        this.examDatetime = examDatetime;
    }

    public String getExamAddress() {
        return examAddress;
    }

    public void setExamAddress(String examAddress) {
        this.examAddress = examAddress;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }
}
