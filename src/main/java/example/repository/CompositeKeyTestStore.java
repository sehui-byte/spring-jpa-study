package example.repository;

import example.entity.CompositeKeyTestEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class CompositeKeyTestStore {
    //
    private final CompositeKeyTestRepository compositeKeyTestRepository;
    //

}
