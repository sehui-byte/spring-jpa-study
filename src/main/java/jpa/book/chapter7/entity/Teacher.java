package jpa.book.chapter7.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Table;

@Table
@Entity
@AllArgsConstructor
@Getter
@Setter
public class Teacher extends BaseEntity {
    //
    @Enumerated(EnumType.STRING)
    private Subject subject;

    public Teacher() {
        //
        super();
    }

    public static void main(String[] args) {
        Teacher teacher = new Teacher(Subject.English);
        teacher.setEmail("test@test.com");
        System.out.println(teacher.getEmail());
    }
}
