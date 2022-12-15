package com.app.dao;

import java.util.List;
import com.app.exception.ProductsException;
import com.app.exception.SellersException;
import com.app.model.Products;
import com.app.model.Sellers;

public interface SellersDAO {
	void register(Sellers seller) throws SellersException;
	void login(String email, String password) throws SellersException;
	void addProducts(List<Products>list);
	void updateProducts(int productID) throws ProductsException;
	void removeProducts(int productID) throws ProductsException;
	void soldProducts(int sellerID) throws SellersException;
}
