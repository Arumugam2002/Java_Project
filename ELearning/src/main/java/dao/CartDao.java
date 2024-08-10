package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import connection.DBConnection;
import model.Cart;

public class CartDao {

	public static void insertIntoCart(Cart c) {
		try {

			Connection conn = DBConnection.driverConnection();

			String sql = "insert into cart(userid, cid, qty, cprice, totalprice, subtotal, payment_status) values(?,?,?,?,?,?,?)";

			PreparedStatement pst = conn.prepareStatement(sql);
			pst.setInt(1, c.getUserid());
			pst.setInt(2, c.getCid());
			pst.setInt(3, c.getQty());
			pst.setInt(4, c.getCprice());
			pst.setInt(5, c.getTotalprice());
			pst.setInt(6, c.getSubtotal());
			pst.setString(7, c.getPayment_status());

			pst.executeUpdate();

			System.out.println("Added Course to Cart");

		} catch (Exception e) {
			// TODO: handle exception

			e.printStackTrace();
		}
	}

	public static List<Cart> getCartByUserId(int id) {
		List<Cart> list = new ArrayList<Cart>();

		try {

			Connection conn = DBConnection.driverConnection();
			String sql = "select * from cart where userid = ?";
			PreparedStatement pst = conn.prepareStatement(sql);

			pst.setInt(1, id);

			ResultSet rs = pst.executeQuery();

			while (rs.next()) {
				Cart c = new Cart();

				c.setCartid(rs.getInt("cartid"));
				c.setUserid(rs.getInt("userid"));
				c.setCid(rs.getInt("cid"));
				c.setQty(rs.getInt("qty"));
				c.setCprice(rs.getInt("cprice"));
				c.setTotalprice(rs.getInt("totalprice"));
				c.setSubtotal(rs.getInt("subtotal"));
				c.setPayment_status(rs.getString("payment_status"));

				list.add(c);
			}

		} catch (Exception e) {
			// TODO: handle exception

			e.printStackTrace();
		}
		return list;
	}

	public static boolean checkCart(int cid, int userid) {
		boolean flag = false;

		try {

			Connection conn = DBConnection.driverConnection();
			String sql = "select * from cart where userid = ? and cid = ?";
			PreparedStatement pst = conn.prepareStatement(sql);

			pst.setInt(1, userid);
			pst.setInt(2, cid);

			ResultSet rs = pst.executeQuery();

			if (rs.next()) {
				flag = true;
			}

			System.out.println("Course is checked and added CartList");

		} catch (Exception e) {
			// TODO: handle exception

			e.printStackTrace();
		}
		return flag;
	}

	public static Cart getCartByCartId(int cartid) {
		Cart c = null;
		try {

			Connection conn = DBConnection.driverConnection();
			String sql = "select * from cart where cartid = ?";
			PreparedStatement pst = conn.prepareStatement(sql);

			pst.setInt(1, cartid);
			ResultSet rs = pst.executeQuery();

			while (rs.next()) {
				c = new Cart();

				c.setCartid(rs.getInt("cartid"));
				c.setUserid(rs.getInt("userid"));
				c.setCid(rs.getInt("cid"));
				c.setQty(rs.getInt("qty"));
				c.setCprice(rs.getInt("cprice"));
				c.setTotalprice(rs.getInt("totalprice"));
				c.setSubtotal(rs.getInt("subtotal"));
				c.setPayment_status(rs.getString("payment_status"));

			}

		} catch (Exception e) {
			// TODO: handle exception

			e.printStackTrace();
		}
		return c;
	}

	public static Cart getSingleCartByUserId(int userid) {
		Cart c = null;

		try {

			Connection conn = DBConnection.driverConnection();
			String sql = "select * from cart where userid = ?";
			PreparedStatement pst = conn.prepareStatement(sql);

			pst.setInt(1, userid);

			ResultSet rs = pst.executeQuery();

			while (rs.next()) {
				c = new Cart();
				c.setCartid(rs.getInt("cartid"));
				c.setUserid(rs.getInt("userid"));
				c.setCid(rs.getInt("cid"));
				c.setQty(rs.getInt("qty"));
				c.setCprice(rs.getInt("cprice"));
				c.setTotalprice(rs.getInt("totalprice"));
				c.setSubtotal(rs.getInt("subtotal"));
				c.setPayment_status(rs.getString("payment_status"));

			}

		} catch (Exception e) {
			// TODO: handle exception

			e.printStackTrace();
		}
		return c;
	}

	public static void removeCourseFromCart(int cartid) {
		try {
			Connection conn = DBConnection.driverConnection();

			String sql = "delete from cart where cartid = ?";
			PreparedStatement pst = conn.prepareStatement(sql);

			pst.setInt(1, cartid);
			pst.executeUpdate();

			System.out.println("Removed From Cart");

		} catch (Exception e) {
			// TODO: handle exception

			e.printStackTrace();
		}
	}

	public static void updateCart(Cart c) {
		try {
			Connection conn = DBConnection.driverConnection();

			String sql = "update cart set qty = ?, totalprice = ?, subtotal = ? where cartid = ?";
			PreparedStatement pst = conn.prepareStatement(sql);

			pst.setInt(1, c.getQty());
			pst.setInt(2, c.getTotalprice());
			pst.setInt(3, c.getSubtotal());
			pst.setInt(4, c.getCartid());

			pst.executeUpdate();

			System.out.println("Cart Updated");

		} catch (Exception e) {
			// TODO: handle exception

			e.printStackTrace();
		}
	}

	public static void updateStatus(int cartid) {
		try {

			Connection conn = DBConnection.driverConnection();

			String sql = "update cart set payment_status = 'successful' where cartid = ?";
			PreparedStatement pst = conn.prepareStatement(sql);

			pst.setInt(1, cartid);

			pst.executeUpdate();

			System.out.println("Payment Status has been Updated");

		} catch (Exception e) {
			// TODO: handle exception

			e.printStackTrace();
		}
	}

}
