package example.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "TEAM")
public class Team {
    //
    @Id
    @GeneratedValue(generator = "USER_GENERATOR")
    @GenericGenerator(name = "USER_GENERATOR", strategy = "uuid")
    private String id;
    private String name;
    @Lob
    private String description;
    @Temporal(TemporalType.DATE)
    private Date date;

    @Transient
    private List<Member> members;

    public static Team sample() {
        //
        Calendar calendar = Calendar.getInstance();
        Date date = calendar.getTime();

        List<Member> memberList = new ArrayList<>();
        memberList.add(new Member("홍길동", 30));
        memberList.add(new Member("이순신", 50));
        memberList.add(new Member("피터 파커", 17));
        memberList.add(new Member("김길동", 80));
        memberList.add(new Member("마동석", 40));
        memberList.add(new Member("아이언맨", 35));
        memberList.add(new Member("스칼렛요한슨", 21));
        memberList.add(new Member("캡틴아메리카", 28));

        return new Team(UUID.randomUUID().toString(),
                "길동이 팀",
                "안녕하세요. 홍길동네 팀입니다.",
                date, memberList);
    }
}
