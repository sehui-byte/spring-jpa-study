package jpa.book.chapter7.repository;

import jpa.book.chapter7.entity.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;


public interface TeacherRepository extends JpaRepository<Teacher, Long> {
    //

}
