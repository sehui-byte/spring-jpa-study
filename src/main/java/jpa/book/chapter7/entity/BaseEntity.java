package jpa.book.chapter7.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;


@Getter@Setter
@MappedSuperclass
public abstract class BaseEntity {
    //
    @Id
    @GeneratedValue
    protected Long id;
    protected String name;
    private String email;

    @Temporal(TemporalType.TIMESTAMP)
    private Date registeredDate;
    @Temporal(TemporalType.TIMESTAMP)
    private Date modifiedDate;


}
