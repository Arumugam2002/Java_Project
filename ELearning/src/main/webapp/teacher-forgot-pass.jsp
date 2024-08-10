<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <%@include file="header.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
 <div class="container-xxl py-5">
        <div class="container">
            <div class="text-center wow fadeInUp" data-wow-delay="0.1s">
                
                <h1 class="mb-5">Faculty Forgot Password</h1>
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
					  
		 
                
                
                 <div class="container-fluid contact py-5">
            <div class="container py-5">
                <div class="p-5 bg-light rounded">
                    <div class="row g-4">
                       
                     
                  
                        
                         <div class="col-lg-7">
                            <form action="TeacherController" class="" method="post">
                               
                                <input type="email" name="email" class="w-100 form-control border-0 py-3 mb-4" placeholder="Enter Your Email">
                                
                                
                                <button class="w-100 btn form-control border-secondary py-3 bg-white text-primary " name="action" value="get-otp" type="submit">Get-OTP</button>
                                
                            </form>
                        </div>
                       
                    </div>
                    <br>
                     
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