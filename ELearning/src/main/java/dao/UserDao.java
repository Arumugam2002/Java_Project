package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import connection.DBConnection;
import model.Seller;
import model.User;


public class UserDao {

	public static void insertUser(User u)
	{
		try {
			
			Connection conn = DBConnection.driverConnection();
			
			String sql = "insert into user(name,contact,address,email,password) values(?,?,?,?,?)";
			
			PreparedStatement pst = conn.prepareStatement(sql);
			
			pst.setString(1, u.getName());
			pst.setLong(2, u.getContact());
			pst.setString(3, u.getAddress());
			pst.setString(4, u.getEmail());
			pst.setString(5, u.getPassword());
			pst.executeUpdate();
			
			System.out.println("Data has been inserted");
			
			
			
		} catch (Exception e) {
			
			e.printStackTrace();
		}
	}
	
	public static boolean checkEmail(String email)
	{
		boolean flag = false;
		
		try {
			
			Connection conn = DBConnection.driverConnection();
			
			String sql = "select * from user where email = ?";
			PreparedStatement pst = conn.prepareStatement(sql);
			
			pst.setString(1, email);
			
			ResultSet rs = pst.executeQuery();
			
			if(rs.next())
			{
				flag = true;
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		return flag;
	}
	
	public static User userLogin(User u)
	{
		User u1 = null;
		
		try {
			
			
			
			Connection conn = DBConnection.driverConnection();
			
			String sql = "select * from user where email = ? and password = ?";
			
			PreparedStatement pst = conn.prepareStatement(sql);
			
			pst.setString(1, u.getEmail());
			pst.setString(2, u.getPassword());
			
			ResultSet rs = pst.executeQuery();
			
			if(rs.next())
			{
				u1 = new User();
				
				u1.setId(rs.getInt("id"));
				u1.setName(rs.getString("name"));
				u1.setContact(rs.getLong("contact"));
				u1.setAddress(rs.getString("address"));
				u1.setEmail(rs.getString("email"));
				u1.setPassword(rs.getString("password"));
			}
		} 
		
		catch (Exception e) {
			
			e.printStackTrace();
			
		}
		
		return u1;
		
		
	}
	
	public static void updateProfile(User u)
	{
		try {
			
			Connection conn = DBConnection.driverConnection();
			
			String sql = "update user set name = ?, contact = ?, address = ?, email = ? where id = ?";
			
			PreparedStatement pst = conn.prepareStatement(sql);
			
			pst.setString(1, u.getName());
			pst.setLong(2, u.getContact());
			pst.setString(3, u.getAddress());
			pst.setString(4, u.getEmail());
			pst.setInt(5, u.getId());	
			
			pst.executeUpdate();
			
			System.out.println("Data has been updated");
			
			
			
		} 
		
		catch (Exception e) {
			e.printStackTrace();
			
		}
		
		
				
	}
	
	public static boolean checkOP(int id, String op)
	{
		boolean flag = false;
		
		try {
			
			Connection conn = DBConnection.driverConnection();
			
			String sql = "select * from user where id = ? and password = ?";
			
			PreparedStatement pst = conn.prepareStatement(sql);
			
			pst.setInt(1, id);
			
			pst.setString(2, op);
			
			ResultSet rs = pst.executeQuery();
			
			if(rs.next())
			{
				flag = true;
			}
			
			System.out.println("Data has been Updated");
			
		} 
		
		
		catch (Exception e) {
			e.printStackTrace();
		}
		
		return flag;
	}
	
	public static void updatePassword(int id, String np)
	{
		try {
			
			Connection conn = DBConnection.driverConnection();
			
			String sql = "update user set password = ? where id = ?";
			
			PreparedStatement pst = conn.prepareStatement(sql);
			
			pst.setString(1, np);
			pst.setInt(2, id);
			pst.executeUpdate();
			
			System.out.println("Password has been updated");
			
		} catch (Exception e) {
			
			e.printStackTrace();
			
		}
	}
	
	
	
	
}
