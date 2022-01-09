package jpa.book.chapter5.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity(name = "book_TEAM")
@Table(name = "BOOK_TEAM")
public class Team {
    //
    @Id
    @Column
    private String id;
    private String name;


}
