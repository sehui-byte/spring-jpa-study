package example.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Getter
@Setter
@Embeddable
@NoArgsConstructor
@AllArgsConstructor
public class CompositeKey implements Serializable {
    //
    private String id1;
    private String id2;
//
//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        else if (o != null && this.getClass() == o.getClass()) {
//            CompositeKey that = (CompositeKey) o;
//            return id1.equals(that.id1) && id2.equals(that.id2);
//        } else {
//            return false;
//        }
//
//    }
//
//    @Override
//    public int hashCode() {
//        return Objects.hash(id1, id2);
//    }

    public static void main(String[] args) {
        CompositeKey key1 = new CompositeKey("id1", "id2");
        CompositeKey key2 = new CompositeKey("id1", "id2");
        System.out.println(key1.equals(key2));
    }
}
