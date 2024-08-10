<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <%@include file="teacher-header.jsp" %>
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
                
                <h1 class="mb-5">Course Upload Page</h1>
            </div>
            <div class="row g-4">
            
           
                      
                      
                
                 <div class="container-fluid contact py-5">
            <div class="container py-5">
                <div class="p-5 bg-light rounded">
                    <div class="row g-4">
                       
                     
                  
                        
                        <div class="col-lg-7">
                            <form action="CourseController" class="" method="post" enctype="multipart/form-data">
                                <input type="hidden" name="tid" class="w-100 form-control border-0 py-3 mb-4" value="<%=t.getId()%>">
                                <input type="file" name="cimage" class="w-100 form-control border-0 py-3 mb-4">
                                <input type="text" name="cname" class="w-100 form-control border-0 py-3 mb-4" placeholder="Course Name">
                                
                                <input type="text" name="cprice" class="w-100 form-control border-0 py-3 mb-4" placeholder="Course Price">
                                <input type="text" name="ccategory" class="w-100 form-control border-0 py-3 mb-4" placeholder="Course Category">
                                
                                
                                <textarea name="cdesc" class="w-100 form-control border-0 mb-4" rows="5" cols="10" placeholder="Course Description"></textarea>
                                
                                <button class="w-100 btn form-control border-secondary py-3 bg-white text-primary " name="action" value="upload-course" type="submit">Upload Course</button>
                                
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



<%@include file="teacher-footer.jsp" %>
</body>
</html>