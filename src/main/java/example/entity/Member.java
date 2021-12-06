package example.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "MEMBER")
public class Member {
    //
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private String id;
    @Column(name = "NAME")
    private String username;
    private Integer age;

    public Member(String username, Integer age) {
        this.username = username;
        this.age = age;
    }

}
