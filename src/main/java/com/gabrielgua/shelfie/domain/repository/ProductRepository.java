package com.gabrielgua.shelfie.domain.repository;

import com.gabrielgua.shelfie.domain.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
}