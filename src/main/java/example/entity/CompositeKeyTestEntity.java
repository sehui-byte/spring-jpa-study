package example.entity;

import jdk.jfr.StackTrace;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class CompositeKeyTestEntity {
    //
    @EmbeddedId
    private CompositeKey id;
    private String name;
}
