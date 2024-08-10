package controller;

import java.io.File;
import java.io.IOException;


import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import dao.CourseDao;
import model.Course;

/**
 * Servlet implementation class CourseController
 */
@WebServlet("/CourseController")
@MultipartConfig(fileSizeThreshold = 1024 * 1024 * 512, maxFileSize = 1024 * 1024 * 512, maxRequestSize = 1024 * 1024
* 512)
public class CourseController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CourseController() {
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
	
	private String extractfilename(Part file) {
		String cd = file.getHeader("content-disposition");
		System.out.println(cd);
		String[] items = cd.split(";");
		for (String string : items) {
			if (string.trim().startsWith("filename")) {
				return string.substring(string.indexOf("=") + 2, string.length() - 1);
			}
		}
		return "";
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		
		String action = request.getParameter("action");
		
		if(action.equalsIgnoreCase("upload-course"))
		{
			
			String savePath = "C:\\Users\\arumu\\eclipse-workspace\\ELearning\\src\\main\\webapp\\img";
			
			File fileSaveDir = new File(savePath);
			
				if(!fileSaveDir.exists())
				{
					fileSaveDir.exists();
				}
			
			
			Part file1 = request.getPart("cimage");
			String fileName = extractfilename(file1);
			
			file1.write(savePath + File.separator + fileName);
			
			String filePath = savePath + File.separator + fileName;
			
			String savePath2 = "C:\\Users\\arumu\\eclipse-workspace\\ELearning\\src\\main\\webapp\\img";
			
			File imgSaveDir = new File(savePath2);
			
			if(!imgSaveDir.exists())
			{
				imgSaveDir.mkdir();
			}
			
			Course c = new Course();
			c.setTid(Integer.parseInt(request.getParameter("tid")));
			c.setCimage(fileName);
			c.setCname(request.getParameter("cname"));
			c.setCprice(Integer.parseInt(request.getParameter("cprice")));
			c.setCcategory(request.getParameter("ccategory"));
			c.setCdesc(request.getParameter("cdesc"));
			
			CourseDao.uploadCourse(c);
			response.sendRedirect("teacher-home.jsp");
					
			
			
		}
		
		else if(action.equalsIgnoreCase("update-course"))
			
		{
			String savePath = "C:\\Users\\arumu\\eclipse-workspace\\ELearning\\src\\main\\webapp\\img";
			
			File fileSaveDir = new File(savePath);
			
			if(!fileSaveDir.exists())
			{
				fileSaveDir.exists();
			}
		
		
		Part file1 = request.getPart("cimage");
		String fileName = extractfilename(file1);
		
		file1.write(savePath + File.separator + fileName);
		
		String filePath = savePath + File.separator + fileName;
		
		String savePath2 = "C:\\Users\\arumu\\eclipse-workspace\\ELearning\\src\\main\\webapp\\img";
		
		File imgSaveDir = new File(savePath2);
		
		if(!imgSaveDir.exists())
		{
			imgSaveDir.mkdir();
		}
		
		Course c = new Course();
		c.setCid(Integer.parseInt(request.getParameter("cid")));
		c.setCimage(fileName);
		c.setCname(request.getParameter("cname"));
		c.setCprice(Integer.parseInt(request.getParameter("cprice")));
		c.setCcategory(request.getParameter("ccategory"));
		c.setCdesc(request.getParameter("cdesc"));
		
		
		CourseDao.updateCourse(c);
		response.sendRedirect("manage-course.jsp");
			
		}
			
		
		
		
		
		
	}
	
	

}
