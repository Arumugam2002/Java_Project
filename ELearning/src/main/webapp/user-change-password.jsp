<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@include file ="user-header.jsp" %>
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
                
                <h1 class="mb-5">Change Password Page</h1>
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
                            
                            
                            <input type="hidden" name ="id" class="w-100 form-control border-0 py-3 mb-4" value = <%= u.getId() %>>
                               
                                
                                
                                <input type="password" name="op" class="w-100 form-control border-0 py-3 mb-4" placeholder="Old Password">
                                <input type="password" name = "np" class="w-100 form-control border-0 py-3 mb-4" placeholder="New Password">
                                <input type="password" name="cnp" class="w-100 form-control border-0 py-3 mb-4" placeholder="Confirm New Password">
                                <button class="w-100 btn form-control border-secondary py-3 bg-white text-primary " name="action" value="cp" type="submit">Change Password</button>
                                
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
    
    
    <%@include file="user-footer.jsp" %>



</body>
</html>