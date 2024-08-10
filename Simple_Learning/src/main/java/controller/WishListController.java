package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.WishListDao;
import model.WishList;

/**
 * Servlet implementation class WishListController
 */
@WebServlet("/WishListController")
public class WishListController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public WishListController() {
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
		if(action.equalsIgnoreCase("addtowishlist"))
		{
			WishList w = new WishList();
			
			w.setUserid(Integer.parseInt(request.getParameter("userid")));
			w.setCid(Integer.parseInt(request.getParameter("cid")));
			
			int cid = Integer.parseInt(request.getParameter("cid"));
			int userid = Integer.parseInt(request.getParameter("userid"));
			
			Boolean flag = WishListDao.checkWishList(cid, userid);
			
			if(flag == false)
			{
				WishListDao.insertWishList(w);
				response.sendRedirect("user-courses-page.jsp");
			}
			
			else {
				request.setAttribute("msg", "This course has already been added to WishList");
				request.getRequestDispatcher("user-courses-page.jsp").forward(request, response);
			}
			
			
		}
	}

}
