CREATE TABLE exams
(
    id            INT PRIMARY KEY AUTO_INCREMENT,
    exam_name     VARCHAR(255) NOT NULL,
    exam_datetime DATETIME     NOT NULL,
    exam_address  VARCHAR(255) NOT NULL
);

CREATE TABLE students
(
    id            INT PRIMARY KEY AUTO_INCREMENT,
    first_name    VARCHAR(50) NOT NULL,
    last_name     VARCHAR(50) NOT NULL,
    school_number INT         NOT NULL
);

CREATE TABLE student_exams
(
    student_id INT,
    exam_id    INT,
    FOREIGN KEY (student_id) REFERENCES students (id),
    FOREIGN KEY (exam_id) REFERENCES exams (id),
    PRIMARY KEY (student_id, exam_id)
);