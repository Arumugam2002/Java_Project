<%@page import="model.Course"%>
<%@page import="dao.CourseDao"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	
	<%@include file = "teacher-header.jsp" %>
	
	
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<div class="container-xxl py-5">
		<div class="container">
			<div class="row g-4">


				<table class="table">
					<thead>
						<tr>
							<th scope="col">Image</th>
							<th scope="col">Course Name</th>
							<th scope="col">Course Price</th>
							<th scope="col">Course Category</th>
							<th scope="col">Course Description</th>
							<th scope="col">Edit</th>
							<th scope="col">Delete</th>
							
							
							
						</tr>
					</thead>
					<tbody>
					
					<%List<Course> list = CourseDao.getCourseByTid(t.getId()); %>
					<%for(Course c: list) { %>
					
					
						<tr>
							
							<td> <img src="img/<%= c.getCimage()%>" height="200" width = "200"></td>
							<td><h5><%=c.getCname()%></h5></td>
							<td><h5><%=c.getCprice()%></h5></td>
							<td><h5><%=c.getCcategory()%></h5></td>
							<td><h5><%=c.getCdesc()%></h5></td>
							
							<td><a href="teacher-single-course.jsp?id=<%=c.getCid() %>" class="nav-item nav-link active">Edit</a></td>
							<td><a href="teacher-delete-course.jsp?id=<%=c.getCid() %>" class="nav-item nav-link active">Delete</a></td>
						</tr>
						
						<%} %>
						
					</tbody>
				</table>


			</div>
		</div>
	</div>

<%@include file="teacher-footer.jsp" %>
</body>
</html>