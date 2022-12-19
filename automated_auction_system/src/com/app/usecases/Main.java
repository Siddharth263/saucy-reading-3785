package com.app.usecases;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import com.app.connection.DBUtil;
import com.app.dao.AdminDAO;
import com.app.dao.AdminImpl;
import com.app.dao.BuyerDAO;
import com.app.dao.BuyerImpl;
import com.app.dao.SellersDAO;
import com.app.dao.SellersImpl;
import com.app.exception.AdminException;
import com.app.exception.BuyersException;
import com.app.exception.DisputeException;
import com.app.exception.ProductsException;
import com.app.exception.SellersException;
import com.app.model.Admin;
import com.app.model.Buyers;
import com.app.model.Products;
import com.app.model.Sellers;

public class Main {

	static Scanner sc = new Scanner(System.in);
	
	public static void main(String[] args) {
		System.out.println("Welcome to Automated Auction System");
		System.out.println("Login/Signup to Proceed: ");
		System.out.println("Enter: ");
		System.out.println("1 for Buyer");
		System.out.println("2 for Seller");
		System.out.println("3 for Administrator");
		int input = sc.nextInt();
		
		switch (input) {
		case 1: {
			BuyerDAO b = new BuyerImpl();
			System.out.println("Enter 1 for Login or 2 for Signup: ");
			int x = sc.nextInt();
			
			if(x==1)
				try {
					System.out.println("Enter your Email: ");
					String email = sc.next();
					System.out.println("Enter your password: ");
					String password = sc.next();
					b.login(email, password);
				} catch (BuyersException e) {
					e.printStackTrace();
					System.out.println(e.getMessage());
				}
			else if(x==2)
				try {
					System.out.println("Enter your name: ");
					String name = sc.next();
					System.out.println("Enter your email: ");
					String email = sc.next();
					System.out.println("Enter your mobile no: ");
					String mob = sc.next();
					System.out.println("Enter your password: ");
					String password = sc.next();
					Buyers b1 = new Buyers(name, email, mob, password);
					b.register(b1);
				} catch (BuyersException e) {
					e.printStackTrace();
				}
			else {
				System.out.println("Invalid Input please try again!!");
			}
		};
		break;
		case 2: {
			SellersDAO s = new SellersImpl();
			System.out.println("Enter 1 for Login or 2 for Sign-up: ");
			int x = sc.nextInt();
					
			if(x==1) {
				System.out.println("Enter your Email: ");
				String email = sc.next();
				System.out.println("Enter your password: ");
				String password = sc.next();
				
				try {
					s.login(email, password);
				} catch (SellersException e) {
					e.printStackTrace();
				}
			}
			else if(x==2) {
				
				System.out.println("Enter your name: ");
				String name = sc.next();
				System.out.println("Enter your email: ");
				String email = sc.next();
				System.out.println("Enter your mobile no: ");
				String mob = sc.next();
				System.out.println("Enter your password: ");
				String password = sc.next();
				Sellers s1 = new Sellers(name, mob, email, password);
				try {
					s.register(s1);
				} catch (SellersException e) {
					e.printStackTrace();
				}
			}
			else {
				System.out.println("Invalid Input please try again!!");
			}
		};
		break;
		case 3: {
			AdminDAO a = new AdminImpl();
			System.out.println("Enter 1 for Login or 2 for Sign-up: ");
			int x = sc.nextInt();
			
			if(x==1) {
				System.out.println("Enter your Email: ");
				String email = sc.next();
				System.out.println("Enter your password: ");
				String password = sc.next();
				try {
					a.login(email, password);
				} catch (AdminException e) {
					e.printStackTrace();
				}
			}
			else if(x==2) {
				System.out.println("Enter your name: ");
				String name = sc.next();
				System.out.println("Enter your Email: ");
				String email = sc.next();
				System.out.println("Enter your password: ");
				String password = sc.next();
				
				Admin a1 = new Admin(name, email, password);
				
				try {
					a.register(a1);
				} catch (AdminException e) {
					e.printStackTrace();
				}
			}
			else {
				System.out.println("Invalid Input please try again!!");
			}
			
		};
		break;
		default:
			throw new IllegalArgumentException("Unexpected value: " + input);
		}
	}

	public static void useCaseAdmin(Admin a) {
		AdminDAO a1 = new AdminImpl();
		System.out.println("Enter:");
		System.out.println("A: See the list of Buyers");
		System.out.println("B: See the list of Sellers");
		System.out.println("C: See the Dispute Report");
		System.out.println("D: See the sold products list");
		System.out.println("E: Update the dispute reports");
		String input = sc.next();
		
		if(input.equals("A")) {
			a1.showAllBuyers();
		} else if (input.equals("B")) {
			a1.showAllSellers();
		} else if (input.equals("C")) {
			a1.showDisputeReport();
		} else if (input.equals("D")) {
			a1.showSoldProducts();
		} else if (input.equals("E")) {
			try {
				a1.updateDisputeReport();
			} catch (DisputeException | BuyersException | SellersException e) {
				e.printStackTrace();
			}
		}
	}
	
	public static void useCasesSeller(Sellers s) {
		SellersDAO s1 = new SellersImpl();
		
		System.out.println("Enter:");
		System.out.println("A: Updated products details");
		System.out.println("B: Add New Products");
		System.out.println("C: Remove products from up for selling list");
		System.out.println("D: See the sold products list");
		String input = sc.next();
		
		if(input.equals("A")) {
			System.out.println("Enter product id: ");
			int id = sc.nextInt();
			try {
				s1.updateProducts(id);
			} catch (ProductsException e) {
				e.printStackTrace();
			}
		} else if (input.equals("B")) {
			System.out.println("Enter the number of products: ");
			int count = sc.nextInt();
			List<Products> list = new ArrayList<>();
			while(count>0) {
				System.out.println("Enter Product details: ");
				System.out.println("Enter Product Name: ");
				String name = sc.next();
				System.out.println("Enter Product Category: ");
				String cat = sc.next();
				System.out.println("Enter price: ");
				int price = sc.nextInt();
				System.out.println("For sale type 'Yes' otherwise 'No'");
				String status = sc.next();
				int sellerId = 0;
				try (Connection conn = DBUtil.provideConnection()) {
					
					PreparedStatement ps = conn.prepareStatement("select sellerId from sellers where email = ?");
					ps.setString(1, s.getSeller_email());
					ResultSet rs = ps.executeQuery();
					if(rs!=null) 
						sellerId = rs.getInt(1);
					
				} catch (Exception e) {
					e.printStackTrace();
				}
				Products p = new Products(sellerId, name, cat, price, status) ;
				list.add(p);
			}
			s1.addProducts(list);
		} else if (input.equals("C")) {
			
			System.out.println("Enter product id; ");
			int x = sc.nextInt();
						
			try {
				s1.removeProducts(x);
			} catch (ProductsException e) {
				e.printStackTrace();
			}
			
		} else if (input.equals("D")) {
			int sellerId = 0;
			try (Connection conn = DBUtil.provideConnection()) {
				
				PreparedStatement ps = conn.prepareStatement("select sellerId from sellers where email = ?");
				ps.setString(1, s.getSeller_email());
				ResultSet rs = ps.executeQuery();
				if(rs!=null) 
					sellerId = rs.getInt(1);
				
			} catch (Exception e) {
				e.printStackTrace();
			}
			try {
				s1.soldProducts(sellerId);
			} catch (SellersException e) {
				e.printStackTrace();
			}
		}
		
	}

	public static void useCasesBuyers(Buyers b) {
		BuyerDAO b1 = new BuyerImpl();
		
		System.out.println("Enter:");
		System.out.println("A: Search product by category");
		System.out.println("B: View Sellers and Products category wise");
		System.out.println("C: Select Products to buy");
		String input = sc.next();
		
		if(input.equals("A")) {
			System.out.println("Enter the name of category: ");
			String cat = sc.next();
			try {
				b1.searchByCategory(cat);
			} catch (ProductsException e) {
				e.printStackTrace();
			}
		} else if (input.equals("B")) {
			
		} else if (input.equals("C")) {
			System.out.println("Enter product id: ");
			int id = sc.nextInt();
			b1.purchaseProduct(id);
		}		
	}
}
