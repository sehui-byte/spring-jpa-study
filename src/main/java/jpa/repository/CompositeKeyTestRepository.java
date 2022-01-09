package jpa.repository;

import jpa.entity.CompositeKey;
import jpa.entity.CompositeKeyTestEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CompositeKeyTestRepository extends JpaRepository<CompositeKeyTestEntity, CompositeKey> {
    //
}
