package com.app.dao;

import com.app.exception.BuyersException;
import com.app.exception.ProductsException;
import com.app.model.Buyers;

public interface BuyerDAO {
	void register(Buyers buyer);
	void login(String email, String password) throws BuyersException;
	void searchByCategory(String category) throws ProductsException;
	void purchaseProduct(int productID);
}
