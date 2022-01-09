package example.repository;

import example.entity.CompositeKey;
import example.entity.CompositeKeyTestEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CompositeKeyTestRepository extends JpaRepository<CompositeKeyTestEntity, CompositeKey> {
    //
}
