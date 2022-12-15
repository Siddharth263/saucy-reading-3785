package com.app.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.app.connection.DBUtil;
import com.app.exception.AdminException;
import com.app.exception.BuyersException;
import com.app.exception.DisputeException;
import com.app.exception.SellersException;
import com.app.model.Admin;
import com.app.model.Buyers;
import com.app.model.Dispute;
import com.app.model.Sellers;
import com.app.model.Sold;

public class AdminImpl implements AdminDAO{

	@Override
	public void register(Admin admin) throws AdminException{
		try (Connection conn = DBUtil.provideConnection()){
			
			PreparedStatement ps = conn.prepareStatement("insert into admin(adminName, adminEmail, adminPassword) values(?,?,?)");
			ps.setString(1, admin.getName());
			ps.setString(2, admin.getEmail());
			ps.setString(3, admin.getPassword());
			
			int x = ps.executeUpdate();
			if(x>0) {
				System.out.println("Account Sucessfully Createad!!");
				System.out.println("Welcome "+admin.getName());
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			throw new AdminException(e.getMessage());
		}
		
	}

	@Override
	public void login(String email, String password) throws AdminException {
		try (Connection conn = DBUtil.provideConnection()) {
			
			PreparedStatement ps = conn.prepareStatement("select adminName from admin where email=? and password=?");
			ps.setString(1, email);
			ps.setString(2, password);
			
			ResultSet rs = ps.executeQuery();
			if(rs!=null) {
				String name = rs.getString(1);
				System.out.println("Welcome "+name);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new AdminException("Invalid Credentials");
		}
	}

	@Override
	public void showAllBuyers() {
		List<Buyers> list = new ArrayList<>();
		try (Connection conn = DBUtil.provideConnection()) {
			
			PreparedStatement ps = conn.prepareStatement("Select * from users");
			ResultSet rs = ps.executeQuery();
			while(rs.next() && rs!=null) {
				Buyers b = new Buyers(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5));
				list.add(b);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		System.out.println(list);
	}

	@Override
	public void showAllSellers() {
		List<Sellers> list = new ArrayList<>();
		
		try (Connection conn = DBUtil.provideConnection()) {
			
			PreparedStatement ps = conn.prepareStatement("Select * from sellers");
			ResultSet rs = ps.executeQuery();
			while(rs!=null && rs.next()) {
				Sellers s = new Sellers(rs.getInt(1), rs.getInt(2), rs.getString(3), rs.getString(4), rs.getString(5),rs.getString(6));
				list.add(s);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println(list);
	}

	@Override
	public void showDisputeReport() {
		List<Dispute> list = new ArrayList<>();
		
		try (Connection conn = DBUtil.provideConnection()) {
			
			PreparedStatement ps = conn.prepareStatement("Select * from dispute");
			ResultSet rs = ps.executeQuery();
			while(rs!=null && rs.next()) {
				Dispute d = new Dispute(rs.getInt(1), rs.getInt(2), rs.getInt(3), rs.getInt(4), rs.getString(5), rs.getString(6), rs.getString(7));
				list.add(d);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println(list);
	}

	@Override
	public void showSoldProducts() {
		List<Sold> list = new ArrayList<>();
		
		try (Connection conn = DBUtil.provideConnection()) {
			
			PreparedStatement ps = conn.prepareStatement("Select * from dispute");
			ResultSet rs = ps.executeQuery();
			while(rs!=null && rs.next()) {
				Sold s = new Sold(rs.getInt(1), rs.getInt(2), rs.getInt(3), rs.getInt(4), rs.getInt(5), rs.getString(6));
				list.add(s);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println(list);
	}

	@Override
	public void updateDisputeReport() throws DisputeException, BuyersException, SellersException {
		
	}

}
