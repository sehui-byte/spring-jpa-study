package jpa;

import jpa.book.chapter7.entity.Subject;
import jpa.book.chapter7.entity.Teacher;
import jpa.book.chapter7.repository.TeacherRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(classes = JpaStudyApplicationTest.class)
public class Chapter7Test {
    //
    @Autowired
    private TeacherRepository teacherRepository;

    @Test
    void insertTeacher() {
        //
        Teacher teacher = new Teacher(Subject.Math);
        teacherRepository.save(teacher);
    }
}
