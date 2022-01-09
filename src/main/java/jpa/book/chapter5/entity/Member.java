package jpa.book.chapter5.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity(name = "book_MEMBER")
@Table(name = "BOOK_MEMBER")
@NoArgsConstructor
@AllArgsConstructor
public class Member {
    //
    @Id
    @Column(name = "MEMBER_ID")
    private String id;
    private String name;

    //연관관계 매핑
    @ManyToOne
    @JoinColumn(name = "TEAM_ID")
    private Team team;

    public Member(String id, String name) {
        this.id = id;
        this.name = name;
    }
}
