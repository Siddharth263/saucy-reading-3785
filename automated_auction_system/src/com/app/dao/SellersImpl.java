package com.app.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import com.app.connection.DBUtil;
import com.app.exception.ProductsException;
import com.app.exception.SellersException;
import com.app.model.Products;
import com.app.model.Sellers;
import com.app.model.Sold;

public class SellersImpl implements SellersDAO{

	@Override
	public void register(Sellers seller) throws SellersException{
		
		try (Connection conn = DBUtil.provideConnection()) {
			
			PreparedStatement ps = conn.prepareStatement("insert into sellers(sellerName,sellerMob,sellerEmail,sellerPassword) values(?,?,?,?)");
			
			ps.setString(1, seller.getSeller_name());
			ps.setString(2, seller.getSeller_mob());
			ps.setString(3, seller.getSeller_email());
			ps.setString(4, seller.getseller_password());
			
			int x = ps.executeUpdate();
			
			if(x>0) {
				System.out.println("Account Succesfully created");
				System.out.println("Welcome "+seller.getSeller_name());
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
			throw new SellersException(e.getMessage());
		}
		
	}

	@Override
	public void login(String email, String password) throws SellersException {
		try (Connection conn = DBUtil.provideConnection()) {
			
			PreparedStatement ps = conn.prepareStatement("select sellerName from sellers where sellerEmail = ? and sellerPassword = ?");
			ps.setString(1, email);
			ps.setString(2, password);
			
			ResultSet rs = ps.executeQuery();
			
			if(rs!=null) {
				System.out.println("Welcome "+rs.getString(1));
			} else throw new SellersException("Invalid Credentials");
		} catch (Exception e) {
			e.printStackTrace();
			throw new SellersException("Invalid Credentials");
		}
	}

	@Override
	public void addProducts(List<Products> list) {
		list.stream().forEach(product -> {
			try (Connection conn = DBUtil.provideConnection()) {
				PreparedStatement ps = conn.prepareStatement("insert into products(prodId,sellerID,prodName,category,price,status) values(?,?,?,?,?,?)");
				int x = ps.executeUpdate();
				if(x>0) System.out.println("Product has been added");
			} catch (Exception e) {
				e.printStackTrace();
			} 
		});
	}

	@Override
	public void updateProducts(int productID) throws ProductsException {
		
	}

	@Override
	public void removeProducts(int productID) throws ProductsException {
		try (Connection conn = DBUtil.provideConnection()) {
			
			PreparedStatement ps = conn.prepareStatement("delete from products where prodID = ?");
			ps.setInt(1, productID);
			int x = ps.executeUpdate();
			if(x>0) System.out.println("Product has been removed!");
			
		} catch (SQLException e) {
			e.printStackTrace();
			throw new ProductsException(e.getMessage());
		}
	}

	@Override
	public void soldProducts(int sellerID) throws SellersException{
		List<Sold> list = new ArrayList<>();
		
		try (Connection conn = DBUtil.provideConnection()) {
			
			PreparedStatement ps = conn.prepareStatement("select * from sold where sellerID = ?");
			ps.setInt(1, sellerID);
			ResultSet rs = ps.executeQuery();
			if(rs!=null) {
				while(rs.next()) {
					Sold s = new Sold(rs.getInt(1), rs.getInt(2), rs.getInt(3), rs.getInt(4), rs.getInt(5), rs.getString(6));
					list.add(s);
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new SellersException(e.getMessage());
		}
		
		System.out.println(list);
	}

}
