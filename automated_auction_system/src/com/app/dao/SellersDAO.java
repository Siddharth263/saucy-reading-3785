package com.app.dao;

import java.util.List;
import com.app.exception.ProductsException;
import com.app.exception.SellersException;
import com.app.model.Products;

public interface SellersDAO {
	void register();
	void login(int email, String password) throws SellersException;
	List<Products> addProducts(Products product);
	void updateProducts(int productID) throws ProductsException;
	void removeProducts(int productID) throws ProductsException;
	void soldProducts();
}
