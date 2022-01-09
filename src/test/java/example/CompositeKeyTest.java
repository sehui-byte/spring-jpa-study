package example;

import example.entity.CompositeKey;
import example.entity.CompositeKeyTestEntity;
import example.repository.CompositeKeyTestRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

@SpringBootTest(classes = JpaStudyApplicationTest.class)
public class CompositeKeyTest {
    //
    @Autowired
    private CompositeKeyTestRepository compositeKeyTestRepository;

    @Test
    void composite_key_test() {
        //
        CompositeKeyTestEntity ckte = new CompositeKeyTestEntity();
//        CompositeKey ck = new CompositeKey("id1", "id2");
        ckte.setId(new CompositeKey("id1", "id2"));
        ckte.setName("1111");
        compositeKeyTestRepository.save(ckte);

        CompositeKeyTestEntity ckte2 = new CompositeKeyTestEntity();
        CompositeKey ck2 = new CompositeKey("id1", "id2");
        ckte2.setId(ck2);
        ckte2.setName("2222");
        compositeKeyTestRepository.save(ckte2);

//        System.out.println("equals ??? " + ck.equals(ck2));
//        System.out.println("result ==> " + ckte.equals(ckte2));

        CompositeKeyTestEntity result = compositeKeyTestRepository.findById(new CompositeKey("id1", "id2")).orElse(null);
        System.out.println("result -> " + result.getName());


    }
}
