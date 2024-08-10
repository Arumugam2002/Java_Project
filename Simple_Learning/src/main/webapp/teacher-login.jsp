<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@include file="header.jsp" %>

<!DOCTYPE html>
<html lang="en">



<body>
    <!-- Spinner Start -->
   
    <!-- Navbar End -->


    <!-- Header Start -->
    
    <!-- Header End -->


    <!-- Contact Start -->
    <div class="container-xxl py-5">
        <div class="container">
            <div class="text-center wow fadeInUp" data-wow-delay="0.1s">
                
                <h1 class="mb-5">Faculty Login Page</h1>
            </div>
            <div class="row g-4">
            
            <% String reg = (String)request.getAttribute("reg");
                      
                      if(reg!=null)
                      {
                    	  
                      %> 
                      
                      <div class="col-12">
					  <h4 class="contact-title"><%out.print(reg);%></h4>
					  
					  </div>
					  <% } %>
					  
		 <% String pass = (String)request.getAttribute("pass");
                      
                      if(pass!=null)
                      {
                    	  
                      %> 
                      
                      <div class="col-12">
					  <h4 class="contact-title"><%out.print(pass);%></h4>
					  
					  </div>
					  <% } %>
					  
		<% String msg = (String)request.getAttribute("msg");
                      
                      if(msg!=null)
                      {
                    	  
                      %> 
                      
                      <div class="col-12">
					  <h4 class="contact-title"><%out.print(msg);%></h4>
					  
					  </div>
					  <% } %>
                
                
                 <div class="container-fluid contact py-5">
            <div class="container py-5">
                <div class="p-5 bg-light rounded">
                    <div class="row g-4">
                       
                     
                  
                        
                         <div class="col-lg-7">
                            <form action="TeacherController" class="" method="post">
                               
                                <input type="email" name="email" class="w-100 form-control border-0 py-3 mb-4" placeholder="Enter Your Email">
                                
                                <input type="password" name="password" class="w-100 form-control border-0 py-3 mb-4" placeholder="Enter Your Password">
                                <button class="w-100 btn form-control border-secondary py-3 bg-white text-primary " name="action" value="login" type="submit">Login</button>
                                
                            </form>
                        </div>
                        
                    </div>
                    <br>
                     <div class="col-lg-5">
                            
                            <h4><a href="teacher-forgot-pass.jsp">Forgot Password?</a></h4>
                            
                        </div>
                        
                         <a href="teacher-register.jsp">Sign Up</a>
                </div>
            </div>
        </div>
            </div>
        </div>
    </div>
    <!-- Contact End -->


    <!-- Footer Start -->
    
    
    <%@include file="footer.jsp" %>


    
</body>

</html>