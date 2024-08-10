package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import connection.DBConnection;
import model.Course;
import model.Teacher;


public class TeacherDao {

	public static void insertTeacher(Teacher t)
	{
		try {
			
			Connection conn = DBConnection.driverConnection();
			
			String sql = "insert into teacher(name,contact,address,email,password) values(?,?,?,?,?)";
			
			PreparedStatement pst = conn.prepareStatement(sql);
			
			pst.setString(1, t.getName());
			pst.setLong(2, t.getContact());
			pst.setString(3, t.getAddress());
			pst.setString(4, t.getEmail());
			pst.setString(5, t.getPassword());
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
			
			String sql = "select * from teacher where email = ?";
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
	
	public static Teacher teacherLogin(Teacher t)
	{
		Teacher t1 = null;
		
		try {
			
			
			
			Connection conn = DBConnection.driverConnection();
			
			String sql = "select * from teacher where email = ? and password = ?";
			
			PreparedStatement pst = conn.prepareStatement(sql);
			
			pst.setString(1, t.getEmail());
			pst.setString(2, t.getPassword());
			
			ResultSet rs = pst.executeQuery();
			
			if(rs.next())
			{
				t1 = new Teacher();
				
				t1.setId(rs.getInt("id"));
				t1.setName(rs.getString("name"));
				t1.setContact(rs.getLong("contact"));
				t1.setAddress(rs.getString("address"));
				t1.setEmail(rs.getString("email"));
				t1.setPassword(rs.getString("password"));
			}
		} 
		
		catch (Exception e) {
			
			e.printStackTrace();
			
		}
		return t1;
		
		
		
		
	}
	
	public static void updateProfile(Teacher t)
	{
		try {
			
			Connection conn = DBConnection.driverConnection();
			
			String sql = "update teacher set name = ?, contact = ?, address = ?, email = ? where id = ?";
			
			PreparedStatement pst = conn.prepareStatement(sql);
			
			pst.setString(1, t.getName());
			pst.setLong(2, t.getContact());
			pst.setString(3, t.getAddress());
			pst.setString(4, t.getEmail());
			pst.setInt(5, t.getId());	
			
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
			
			String sql = "select * from teacher where id = ? and password = ?";
			
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
			
			String sql = "update teacher set password = ? where id = ?";
			
			PreparedStatement pst = conn.prepareStatement(sql);
			
			pst.setString(1, np);
			pst.setInt(2, id);
			pst.executeUpdate();
			
			System.out.println("Password has been updated");
			
		} catch (Exception e) {
			
			e.printStackTrace();
			
		}
	}
	
	public static void newPassword(String email, String np)
	{
		try {
			Connection conn = DBConnection.driverConnection();
			
			String sql = "update teacher set password = ? where email = ?";
			
			PreparedStatement pst = conn.prepareStatement(sql);
			
			pst.setString(1, np);
			pst.setString(2, email);
			pst.executeUpdate();
			
			System.out.println("Password Updated");
		} 
		
		catch (Exception e) {
			// TODO: handle exception
			
			e.printStackTrace();
		}
		
		
	}
	
	public static List<Teacher> getTeacherName()
	{
		List<Teacher> list = new ArrayList<Teacher>();
		
		try {
			
			Connection conn = DBConnection.driverConnection();
			String sql = "select * from teacher";
			PreparedStatement pst = conn.prepareStatement(sql);
			
			ResultSet rs = pst.executeQuery();
			
			while(rs.next())
			{
				Teacher t = new Teacher();
				
				t.setId(rs.getInt("id"));
				t.setName(rs.getString("name"));
				t.setContact(rs.getLong("contact"));
				t.setAddress(rs.getString("address"));
				t.setEmail(rs.getString("email"));
				t.setPassword(rs.getString("password"));
				
				list.add(t);
			}
			
			
		} catch (Exception e) {
			// TODO: handle exception
			
			e.printStackTrace();
		}
		return list;
	}

	
}
