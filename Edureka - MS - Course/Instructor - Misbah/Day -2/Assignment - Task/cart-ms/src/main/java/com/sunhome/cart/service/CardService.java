package com.sunhome.cart.service;

import java.util.List;

import com.sunhome.cart.model.CartResponse;
import com.sunhome.cart.model.Products;

public interface CardService {
 
	CartResponse addToCard(int productId);
}
