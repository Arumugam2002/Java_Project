package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import connection.DBConnection;
import model.WishList;

public class WishListDao {

	public static void insertWishList(WishList w)
	{
		try {
			
			Connection conn = DBConnection.driverConnection();
			String sql = "insert into wishlist(userid,cid) values(?,?)";
			
			PreparedStatement pst = conn.prepareStatement(sql);
			
			pst.setInt(1, w.getUserid());
			pst.setInt(2, w.getCid());
			
			pst.executeUpdate();
			
			System.out.println("Course added to WishList");
			
			
			
		} catch (Exception e) {
			// TODO: handle exception
			
			e.printStackTrace();
		}
	}
	
	public static boolean checkWishList(int cid, int userid)
	{
		boolean flag = false;
		
		try {
			
			Connection conn = DBConnection.driverConnection();
			String sql = "select * from wishlist where userid = ? and cid = ?";
			PreparedStatement pst = conn.prepareStatement(sql);
			
			pst.setInt(1, userid);
			pst.setInt(2, cid);
			
			ResultSet rs = pst.executeQuery();
			
			if(rs.next())
			{
				flag = true;
			}
			
			System.out.println("Course is checked and added WishList");
			
		} catch (Exception e) {
			// TODO: handle exception
			
			e.printStackTrace();
		}
		return flag;
	}
	
	public static List<WishList> getWishListByUserId(int id)
	{
		List<WishList> list = new ArrayList<WishList>();
		
		try {
			
			Connection conn = DBConnection.driverConnection();
			String sql = "select * from wishlist where userid = ?";
			PreparedStatement pst = conn.prepareStatement(sql);
			
			pst.setInt(1, id);
			
			ResultSet rs = pst.executeQuery();

			while(rs.next())
			{
				WishList w = new WishList();
				w.setWid(rs.getInt("wid"));
				w.setUserid(rs.getInt("userid"));
				w.setCid(rs.getInt("cid"));
				
				list.add(w);
			}
			
		} catch (Exception e) {
			// TODO: handle exception
			
			e.printStackTrace();
		}
		return list;
	}
	
	public static void removeCourse(int wid)
	{
		try {
			Connection conn = DBConnection.driverConnection();
			
			String sql = "delete from wishlist where wid = ?";
			PreparedStatement pst = conn.prepareStatement(sql);
			
			pst.setInt(1, wid);
			pst.executeUpdate();
			
			System.out.println("Removed From WishList");
			
			
			
		} catch (Exception e) {
			// TODO: handle exception
			
			e.printStackTrace();
		}
	}
	
	
}
