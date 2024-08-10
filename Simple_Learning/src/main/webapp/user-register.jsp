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
                
                <h1 class="mb-5">User Registration Page</h1>
            </div>
            <div class="row g-4">
            
            <% String msg = (String)request.getAttribute("msg");
                      
                      if(msg!=null)
                      {
                    	  
                      %> 
                      
                      <div class="col-12">
					  <h4 class="contact-title"><%out.print(msg);%></h4>
					  
					  </div>
					  <% } %>
					  
					  <% String msg1 = (String)request.getAttribute("msg1");
                      
                      if(msg1!=null)
                      {
                    	  
                      %> 
                      
                      <div class="col-12">
					  <h4 class="contact-title"><%out.print(msg1);%></h4>
					  
					  </div>
					  <% } %>
                
                
                 <div class="container-fluid contact py-5">
            <div class="container py-5">
                <div class="p-5 bg-light rounded">
                    <div class="row g-4">
                       
                     
                  
                        
                        <div class="col-lg-7">
                            <form action="UserController" class="" method="post">
                                <input type="text" name="name" class="w-100 form-control border-0 py-3 mb-4" placeholder="Enter your Name">
                                <input type="number" name="contact" class="w-100 form-control border-0 py-3 mb-4" placeholder="Enter your mobile number">
                                
                                <textarea name="address" class="w-100 form-control border-0 mb-4" rows="5" cols="10" placeholder="Enter your Address"></textarea>
                                <input type="email" name="email" class="w-100 form-control border-0 py-3 mb-4" placeholder="Enter Your Email">
                                <input type="password" name="password" class="w-100 form-control border-0 py-3 mb-4" placeholder="Enter Your Password">
                                <button class="w-100 btn form-control border-secondary py-3 bg-white text-primary " name="action" value="register" type="submit">Register</button>
                                
                            </form>
                        </div>
                        <div class="col-lg-5">
                            
                            
                            
                        </div>
                    </div>
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