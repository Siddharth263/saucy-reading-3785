package com.app.dao;

import com.app.exception.AdminException;
import com.app.exception.BuyersException;
import com.app.exception.DisputeException;
import com.app.exception.SellersException;

public interface AdminDAO {
	void register();
	void login(int email, String password) throws AdminException;
	void showAllBuyers();
	void showAllSellers();
	void showDisputeReport();
	void showSoldProducts();
	void updateDisputeReport() throws DisputeException, BuyersException, SellersException;
}
