package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;



import connection.DBConnection;
import model.Course;

public class CourseDao {

	public static void uploadCourse(Course c)
	
	{
		
		try {
			
			Connection conn = DBConnection.driverConnection();
			String sql = "insert into course(tid,cimage,cname,cprice,ccategory,cdesc) values(?,?,?,?,?,?)";
			
			PreparedStatement pst = conn.prepareStatement(sql);
			pst.setInt(1, c.getTid());
			pst.setString(2, c.getCimage());
			pst.setString(3, c.getCname());
			pst.setInt(4, c.getCprice());
			pst.setString(5, c.getCcategory());
			pst.setString(6, c.getCdesc());
			
			pst.executeUpdate();
			System.out.println("Course has been uploaded");
			
			
			
			
		} catch (Exception e) {
			// TODO: handle exception
			
			e.printStackTrace();
		}
	}
	
	
	public static List<Course> getCourseByTid(int tid)
	{
		List<Course> list = new ArrayList<Course>();
		
		try {
			
			Connection conn = DBConnection.driverConnection();
			String sql = "select * from course where tid = ?";
			
			PreparedStatement pst = conn.prepareStatement(sql);
			
			pst.setInt(1, tid);
			ResultSet rs = pst.executeQuery();
			
			while(rs.next())
			{
				Course c = new Course();
				c.setCid(rs.getInt("cid"));
				c.setTid(rs.getInt("tid"));
				c.setCimage(rs.getString("cimage"));
				c.setCname(rs.getString("cname"));
				c.setCprice(rs.getInt("cprice"));
				c.setCcategory(rs.getString("ccategory"));
				c.setCdesc(rs.getString("cdesc"));
				
				list.add(c);

			}
			
			System.out.println("Course has been searched with teacher id");
			
		} catch (Exception e) {
			// TODO: handle exception
			
			e.printStackTrace();
		}
		return list;
	}
	
	public static Course getCourseById(int id)
	{
		Course c = null;
		
		try {
			
			Connection conn = DBConnection.driverConnection();
			String sql = "select * from course where cid = ?";
			PreparedStatement pst = conn.prepareStatement(sql);
			
			pst.setInt(1, id);
			
			ResultSet rs = pst.executeQuery();
			
			if(rs.next())
			{
				c = new Course();
				c.setCid(rs.getInt("cid"));
				c.setTid(rs.getInt("tid"));
				c.setCimage(rs.getString("cimage"));
				c.setCname(rs.getString("cname"));
				c.setCprice(rs.getInt("cprice"));
				c.setCcategory(rs.getString("ccategory"));
				c.setCdesc(rs.getString("cdesc"));
			}
			
			System.out.println("Course has been fetched by id");
			
		} catch (Exception e) {
			// TODO: handle exception
			
			e.printStackTrace();
		}
		return c;
	}
	
	public static void updateCourse(Course c)
	{
		try {
			
			Connection conn = DBConnection.driverConnection();
			String sql = "update course set cimage = ?, cname = ?, cprice =?, ccategory = ?, cdesc = ? where cid = ?";
			
			PreparedStatement pst = conn.prepareStatement(sql);
			
			
			pst.setString(1, c.getCimage());
			pst.setString(2, c.getCname());
			pst.setInt(3, c.getCprice());
			pst.setString(4, c.getCcategory());
			pst.setString(5, c.getCdesc());
			
			pst.setInt(6, c.getCid());
			
			pst.executeUpdate();
			
			System.out.println("Course has been Updated");
			
			
		} catch (Exception e) {
			// TODO: handle exception
			
			e.printStackTrace();
		}
	}
	
	public static void deleteCourse(int id)
	{
		try {
			
			Connection conn = DBConnection.driverConnection();
			String sql = "delete from course where cid = ?";
			PreparedStatement pst = conn.prepareStatement(sql);
			pst.setInt(1, id);
			pst.executeUpdate();
			
			System.out.println("Course has been deleted");
			
			
			
		} catch (Exception e) {
			
			
			// TODO: handle exception
			e.printStackTrace();
		}
		
		
		
	}
	
	public static List<Course> getAllCourses()
	{
		List<Course> list = new ArrayList<Course>();
		
		try {
			
			Connection conn = DBConnection.driverConnection();
			String sql = "select * from course";
			PreparedStatement pst = conn.prepareStatement(sql);
			
			ResultSet rs = pst.executeQuery();
			
			while(rs.next())
			{
				Course c = new Course();
				c.setCid(rs.getInt("cid"));
				c.setTid(rs.getInt("tid"));
				c.setCimage(rs.getString("cimage"));
				c.setCname(rs.getString("cname"));
				c.setCprice(rs.getInt("cprice"));
				c.setCcategory(rs.getString("ccategory"));
				c.setCdesc(rs.getString("cdesc"));
				
				list.add(c);
			}
			
			
		} catch (Exception e) {
			// TODO: handle exception
			
			e.printStackTrace();
		}
		return list;
	}
	
	
	
}
