package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.CartDao;
import dao.CourseDao;
import model.Cart;
import model.Course;

/**
 * Servlet implementation class CartController
 */
@WebServlet("/CartController")
public class CartController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CartController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		
		String action = request.getParameter("action");
		if(action.equalsIgnoreCase("addtocart"))
		{
			Cart c = new Cart();
			c.setUserid(Integer.parseInt(request.getParameter("userid")));
			c.setCid(Integer.parseInt(request.getParameter("cid")));
			
			int cid = Integer.parseInt(request.getParameter("cid"));
			int userid = Integer.parseInt(request.getParameter("userid"));
			
			Course c1 = CourseDao.getCourseById(cid);
			
			c.setQty(1);
			c.setCprice(c1.getCprice());
			c.setTotalprice(c1.getCprice());
			c.setSubtotal(c1.getCprice());
			c.setPayment_status("Pending");
			
			
			
			Boolean flag = CartDao.checkCart(cid, userid);
			
			if(flag == false)
			{
				CartDao.insertIntoCart(c);
				response.sendRedirect("user-courses-page.jsp");
			}
			
			else {
				request.setAttribute("msg1", "This course has already been added to Cart");
				request.getRequestDispatcher("user-courses-page.jsp").forward(request, response);
			}
			
			
		}
		
		else if(action.equalsIgnoreCase("updatecart"))
		{
			int cartid	= Integer.parseInt(request.getParameter("cartid"));
			int qty = Integer.parseInt(request.getParameter("qty"));
			
			System.out.println(cartid);
			System.out.println(qty);

			Cart c = CartDao.getCartByCartId(cartid);
			
			c.setCartid(cartid);
			c.setQty(qty);
			c.setTotalprice(qty * c.getCprice());
			int subtotal = qty * c.getCprice();
			
			c.setSubtotal(subtotal);
			
			CartDao.updateCart(c);
			
			response.sendRedirect("user-cart.jsp");
		}
		
		
		
		
		
	}

}
