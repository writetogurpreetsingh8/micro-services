package com.sunhome.stock.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sunhome.stock.entites.ProductCatelogueEntity;

@Repository
public interface ProductCatelogueRepository extends JpaRepository<ProductCatelogueEntity, Integer> {
}
