package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.TeacherDao;
import dao.UserDao;
import model.Teacher;
import model.User;

/**
 * Servlet implementation class TeacherController
 */
@WebServlet("/TeacherController")
public class TeacherController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TeacherController() {
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
		
String action = request.getParameter("action"); 
		
		if(action.equalsIgnoreCase("register"))
		{
			Teacher t = new Teacher();
			
			t.setName(request.getParameter("name"));
			t.setContact(Long.parseLong(request.getParameter("contact")));
			t.setAddress(request.getParameter("address"));
			t.setEmail(request.getParameter("email"));
			t.setPassword(request.getParameter("password"));
			
			String email = request.getParameter("email");
			
			boolean flag = TeacherDao.checkEmail(email);
			
			if(flag == false)
			{
				TeacherDao.insertTeacher(t);
				request.setAttribute("reg", "Successfully Registered");
				request.getRequestDispatcher("teacher-login.jsp").forward(request, response);
			}
			
			else 
			{
				request.setAttribute("msg", "Account has been already registered");
				request.getRequestDispatcher("teacher-register.jsp").forward(request, response);
			}
			
			
		}
		
		if(action.equalsIgnoreCase("login"))
		{
			Teacher t = new Teacher();
			
			t.setEmail(request.getParameter("email"));
			t.setPassword(request.getParameter("password"));
			
			String email = request.getParameter("email");
			
			boolean flag = TeacherDao.checkEmail(email);
			
			if(flag == true)
			{
				System.out.println("If Flag is true");
				Teacher t1 =  TeacherDao.teacherLogin(t);
				
				if(t1!= null)
				{
					System.out.println("If Session is true");
					HttpSession session = request.getSession();
					
					session.setAttribute("data", t1);
					request.getRequestDispatcher("teacher-home.jsp").forward(request, response);
				}
				
				else {
					System.out.println("Password is Incorrect");
					request.setAttribute("pass", "Password is Incorrect");
					request.getRequestDispatcher("teacher-login.jsp").forward(request, response);
				}
			}
			
			else {
				request.setAttribute("msg1", "Email not register, please register");
				request.getRequestDispatcher("teacher-register.jsp").forward(request, response);
			}
			
			
			}
		
		if(action.equalsIgnoreCase("update"))
		{
			
			
			Teacher t = new Teacher();
			
			t.setId(Integer.parseInt(request.getParameter("id")));
			t.setName(request.getParameter("name"));
			t.setContact(Long.parseLong(request.getParameter("contact")));
			t.setAddress(request.getParameter("address"));
			t.setEmail(request.getParameter("email"));
			
			TeacherDao.updateProfile(t);
			
			HttpSession session = request.getSession();
			
			session.setAttribute("data", t);
			request.setAttribute("update", "Profile has been updated");
			request.getRequestDispatcher("teacher-home.jsp").forward(request, response);
			
			
			
			
		}
		
		if(action.equalsIgnoreCase("cp"))
		{
			int id = Integer.parseInt(request.getParameter("id"));
			
			String op = request.getParameter("op");
			String np = request.getParameter("np");
			String cnp = request.getParameter("cnp");
			
			boolean flag = TeacherDao.checkOP(id, op);
			
			if(flag == true)
			{
				if(np.equals(cnp))
				{
					TeacherDao.updatePassword(id, np);
					response.sendRedirect("teacher-home.jsp");
					
					
				}
				
				else {
					request.setAttribute("msg1", "np and cnp is not matched");
					request.getRequestDispatcher("teacher-change-password.jsp").forward(request, response);
					
				}
				
				
			}
			
			else {
				request.setAttribute("msg", "Old password is Incorrect");
				request.getRequestDispatcher("teacher-change-password.jsp").forward(request, response);
				
			}
			
			
		}
		
		
		
	}

}
