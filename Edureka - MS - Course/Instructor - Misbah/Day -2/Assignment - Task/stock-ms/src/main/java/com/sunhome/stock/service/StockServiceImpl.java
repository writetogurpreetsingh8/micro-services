
package com.sunhome.stock.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.stereotype.Service;

import com.sunhome.stock.entites.ProductCatelogueEntity;
import com.sunhome.stock.entites.ProductsEntity;
import com.sunhome.stock.repository.ProductCatelogueRepository;
import com.sunhome.stock.repository.ProductRepository;
import com.sunhome.stock.resource.StockResource;

@Service
@RefreshScope
public class StockServiceImpl implements StockService {

	private static final Logger LOGGER = LoggerFactory.getLogger(StockServiceImpl.class);

	@Value("${stock.test.value}")
	private String applicationName;
	
	
	@Autowired
	private ProductCatelogueRepository  productCatelogueRepository;
	
	@Autowired
	private ProductRepository  productRepository;
	
	@Override
	public List<ProductCatelogueEntity> getProductCatelogues() {
		LOGGER.info("stock.test.value is.......................................................{}",applicationName);
		LOGGER.info("inoking get product catelogue service...........");
		return productCatelogueRepository.findAll();
	}

	@Override
	public Optional<ProductCatelogueEntity> getProductCatelogue(int catelogueId) {
		
		
		return productCatelogueRepository.findById(catelogueId);
	}

	@Override
	public Optional<ProductCatelogueEntity> getProduct(int catelogueId, int productId) {
		
		Optional<ProductCatelogueEntity> optional = productCatelogueRepository.findById(catelogueId);
		if(optional.isPresent()) {
			filterOutDesiredProduct(optional.get(),productId);
		}
		return optional;
	}
	
	private void filterOutDesiredProduct(ProductCatelogueEntity productCatelogueEntity,final int productId) {
		
		
		List<ProductsEntity> list = productCatelogueEntity.getProducts().stream().filter(product ->{
			return product.getId() == productId;
		}).collect(Collectors.toList());
		
		productCatelogueEntity.setProducts(list);
	}

	@Override
	public void deleteCatelogue() {
		productCatelogueRepository.deleteAll();
	}

	@Override
	public void deleteCatelogue(int catelogueId) {
		productCatelogueRepository.deleteById(catelogueId);
	}

	@Override
	public void deleteProduct(final int catelogueId, final int productId) {
		productRepository.deleteById(productId);
	}

	@Override
	public boolean addToCart(int productId) {
		
		Optional<ProductsEntity> product = productRepository.findById(productId);
		
		if(product.isPresent()) {
			
			if(product.get().isInTheStock()) {
				
				if(product.get().getQuantity() > 0) {
					
					product.get().setQuantity((product.get().getQuantity() - 1));
					product.get().setAddedIntoCart(true);
					productRepository.save(product.get());
					return true;
				}else {
					product.get().setInTheStock(false);
					productRepository.save(product.get());
				}
				return false;
			}
			return false;
		}
		return false;
	}

	@Override
	public List<ProductsEntity> recommandedProducts() {
		
		Set<Integer> set = productRepository.fetchProductCatelogueIds();
		
		List<ProductsEntity> proList = new ArrayList<>();
		
		for(Integer i : set) {
			proList.addAll(productRepository.fetchProductByProductCatelogueIds(i));
		}
		return proList;
	} 
}
