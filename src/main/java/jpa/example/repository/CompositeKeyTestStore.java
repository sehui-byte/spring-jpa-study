package jpa.example.repository;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class CompositeKeyTestStore {
    //
    private final CompositeKeyTestRepository compositeKeyTestRepository;
    //

}
