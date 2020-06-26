package com.sunhome.stock.repository;

import java.util.List;
import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.sunhome.stock.entites.ProductsEntity;

@Repository
public interface ProductRepository extends JpaRepository<ProductsEntity, Integer> {
	
	@Query(value = "select PRODUCT_CATELOGUE_ID_FK from PRODUCT as p where p.IS_IN_THE_STOCK and IS_ADDED_INTO_CART",nativeQuery = true)
	Set<Integer> fetchProductCatelogueIds(); 
	
	@Query(value = "select * from PRODUCT as p where p.PRODUCT_CATELOGUE_ID_FK=?1 and p.IS_IN_THE_STOCK and p.IS_ADDED_INTO_CART = false ",nativeQuery = true)
	List<ProductsEntity> fetchProductByProductCatelogueIds(int productCatelogue); 
	
}
