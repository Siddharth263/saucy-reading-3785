package com.app.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.app.connection.DBUtil;
import com.app.exception.BuyersException;
import com.app.exception.ProductsException;
import com.app.model.Buyers;
import com.app.model.Products;

public class BuyerImpl implements BuyerDAO{

	@Override
	public void register(Buyers buyer) throws BuyersException{
		try (Connection conn = DBUtil.provideConnection()) {
			
			PreparedStatement ps = conn.prepareStatement("insert into users(name,email, mobile, password) values(?,?,?,?)");
			ps.setString(1, buyer.getName());
			ps.setString(2, buyer.getEmail());
			ps.setString(3, buyer.getMobile());
			ps.setString(4, buyer.getPassword());
			int x = ps.executeUpdate();
			if(x>0) {
				System.out.println("Account Successfully Created!!");
				System.out.println("Welcome "+buyer.getName());
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new BuyersException("Please enter correct details");
		}
		
	}

	@Override
	public void login(String email, String password) throws BuyersException {
		try (Connection conn = DBUtil.provideConnection()){
			
			PreparedStatement ps = conn.prepareStatement("select * from users where email = ? and password = ?");
			ps.setString(1, email);
			ps.setString(2, password);
			
			ResultSet rs = ps.executeQuery();
			if(rs.next()!=false) {
				System.out.println("Welcome "+rs.getString(1));
			} 
		} catch (SQLException e) {
			e.printStackTrace();
			throw new BuyersException("Invalid Credentials");
		}
	}

	@Override
	public void searchByCategory(String category) throws ProductsException {
		List<Products> lists = new ArrayList<>();
		
		try (Connection conn = DBUtil.provideConnection()) {
			
			PreparedStatement ps = conn.prepareStatement("Select * from products where category=?");
			ps.setString(1, category);

			ResultSet rs = ps.executeQuery();
			
			if(rs!=null) {
				while(rs.next()) {
					Products p = new Products(rs.getInt(2), rs.getString(3), rs.getString(4), rs.getInt(5), rs.getString(6));
					lists.add(p);
				}
			} 
		} catch (Exception e) {
			e.printStackTrace();
			throw new ProductsException("Please enter appropriate category");
		}
	}

	@Override
	public void purchaseProduct(int productID) {
		
		
	}

}
