package jpa.example.repository;

import jpa.example.entity.CompositeKey;
import jpa.example.entity.CompositeKeyTestEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CompositeKeyTestRepository extends JpaRepository<CompositeKeyTestEntity, CompositeKey> {
    //
}
