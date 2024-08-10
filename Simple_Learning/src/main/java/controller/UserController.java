package controller;

import java.io.IOException;
import java.util.Random;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


import dao.UserDao;

import model.User;
import service_for_otp.Servicesss;

/**
 * Servlet implementation class UserController
 */
@WebServlet("/UserController")
public class UserController extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public UserController() {
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
		
		String action = request.getParameter("action"); 
		
		if(action.equalsIgnoreCase("register"))
		{
			User u = new User();
			
			u.setName(request.getParameter("name"));
			u.setContact(Long.parseLong(request.getParameter("contact")));
			u.setAddress(request.getParameter("address"));
			u.setEmail(request.getParameter("email"));
			u.setPassword(request.getParameter("password"));
			
			String email = request.getParameter("email");
			
			boolean flag = UserDao.checkEmail(email);
			
			if(flag == false)
			{
				UserDao.insertUser(u);
				request.setAttribute("reg", "Successfully Registered");
				request.getRequestDispatcher("user-login.jsp").forward(request, response);
			}
			
			else 
			{
				request.setAttribute("msg", "Account has been already registered");
				request.getRequestDispatcher("user-register.jsp").forward(request, response);
			}
			
			
		}
		
		else if(action.equalsIgnoreCase("login"))
		{
			User u = new User();
			
			u.setEmail(request.getParameter("email"));
			u.setPassword(request.getParameter("password"));
			
			String email = request.getParameter("email");
			
			boolean flag = UserDao.checkEmail(email);
			
			if(flag == true)
			{
				System.out.println("If Flag is true");
				User u1 =  UserDao.userLogin(u);
				
				if(u1!= null)
				{
					System.out.println("If Session is true");
					HttpSession session = request.getSession();
					
					session.setAttribute("data", u1);
					request.getRequestDispatcher("user-home.jsp").forward(request, response);
				}
				
				else {
					System.out.println("Password is Incorrect");
					request.setAttribute("pass", "Password is Incorrect");
					request.getRequestDispatcher("user-login.jsp").forward(request, response);
				}
			}
			
			else {
				request.setAttribute("msg1", "Email not register, please register");
				request.getRequestDispatcher("user-register.jsp").forward(request, response);
			}
			
			
			}
		
			/*
			 * else if(action.equalsIgnoreCase("edit")) { int id =
			 * Integer.parseInt(request.getParameter("id"));
			 * 
			 * User u = UserDao.getUserById(id);
			 * 
			 * request.setAttribute("data", u);
			 * 
			 * request.getRequestDispatcher("update.jsp").forward(request, response); }
	
			 *
			 */
		
		
		else if(action.equalsIgnoreCase("update"))
		{
			
			
			User u = new User();
			
			u.setId(Integer.parseInt(request.getParameter("id")));
			u.setName(request.getParameter("name"));
			u.setContact(Long.parseLong(request.getParameter("contact")));
			u.setAddress(request.getParameter("address"));
			u.setEmail(request.getParameter("email"));
			
			UserDao.updateProfile(u);
			
			HttpSession session = request.getSession();
			
			session.setAttribute("data", u);
			request.setAttribute("update", "Profile has been updated");
			request.getRequestDispatcher("user-home.jsp").forward(request, response);
			
			
			
			
		}
		
		else if(action.equalsIgnoreCase("cp"))
		{
			int id = Integer.parseInt(request.getParameter("id"));
			
			String op = request.getParameter("op");
			String np = request.getParameter("np");
			String cnp = request.getParameter("cnp");
			
			boolean flag = UserDao.checkOP(id, op);
			
			if(flag == true)
			{
				if(np.equals(cnp))
				{
					UserDao.updatePassword(id, np);
					response.sendRedirect("user-home.jsp");
					
					
				}
				
				else {
					request.setAttribute("msg1", "np and cnp is not matched");
					request.getRequestDispatcher("user-change-password.jsp").forward(request, response);
					
				}
				
				
			}
			
			else {
				request.setAttribute("msg", "Old password is Incorrect");
				request.getRequestDispatcher("user-change-password.jsp").forward(request, response);
				
			}
			
			
		}
		
		else if(action.equalsIgnoreCase("get-otp")) {
			
			String email = request.getParameter("email");
			boolean flag = UserDao.checkEmail(email);
			
			if(flag == true) {
				Random r = new Random();
				int num = r.nextInt(999999);
				
				Servicesss s = new Servicesss();
				
				s.sendMail(email, num);
				request.setAttribute("email", email);
				request.setAttribute("otp", num);
				
				request.getRequestDispatcher("user-verify-otp.jsp").forward(request, response);
				
				
				
			}
			
			else {
				System.out.println("If Email is not registered or wrong");
				request.setAttribute("msg", "Account not registered, Please Register");
				request.getRequestDispatcher("user-login.jsp").forward(request, response);
				
				
			}
			
		}
		
		else if(action.equalsIgnoreCase("verify"))
		{
			String email = request.getParameter("email");
			int otp1 = Integer.parseInt(request.getParameter("otp1"));
			int otp2 = Integer.parseInt(request.getParameter("otp2"));
			
			if(otp1 == otp2)
			{
				request.setAttribute("email", email);
			}
			request.getRequestDispatcher("user-new-password.jsp").forward(request, response);
		}
		
		else if(action.equalsIgnoreCase("new_p")) {
			
			String email = request.getParameter("email");
			String np = request.getParameter("np");
			String cnp = request.getParameter("cnp");
			
			if(np.equals(cnp))
			{
				UserDao.newPassword(email, np);
				
				response.sendRedirect("user-login.jsp");
			}
			
			else {
				request.setAttribute("msg","New Password and Confirm Password are not same");
				request.getRequestDispatcher("user-new-password.jsp").forward(request, response);
			}
			
		}
		
		
		
		
		
		
		
	}

}
