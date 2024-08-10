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
                
                <h1 class="mb-5"> User Forgot Password</h1>
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
                            <form action="UserController" class="" method="post">
                            <%String email = (String)request.getAttribute("email"); %>
                            <input type="hidden" name="email" value="<%=email %>">
                               
                                <input type="password" name="np" class="w-100 form-control border-0 py-3 mb-4" placeholder="New Password">
                                
                                <input type="password" name="cnp" class="w-100 form-control border-0 py-3 mb-4" placeholder="Confirm New Password">
                                
                                
                                <button class="w-100 btn form-control border-secondary py-3 bg-white text-primary " name="action" value="new_p" type="submit">New Password</button>
                                
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