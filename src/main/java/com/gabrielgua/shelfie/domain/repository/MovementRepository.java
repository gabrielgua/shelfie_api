package com.gabrielgua.shelfie.domain.repository;

import com.gabrielgua.shelfie.domain.model.Movement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MovementRepository extends JpaRepository<Movement, Long> {
}