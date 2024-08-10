<%@page import="dao.CourseDao"%>
<%@page import="model.Course"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@include file="user-header.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
	int id = Integer.parseInt(request.getParameter("id"));
	%>
	<%
	Course c = CourseDao.getCourseById(id);
	%>

	<div class="container-xxl py-5">
		<div class="container">
			<div class="text-center wow fadeInUp" data-wow-delay="0.1s">

				<!-- <h1 class="mb-5">Manage Courses</h1> -->
			</div>
			<div class="row g-4">





				<div class="container-fluid contact py-5">
					<div class="container py-5">
						<div class="p-5 bg-light rounded">
							<div class="row g-4">




								<div class="col-lg-7">





									<!-- <div class="col-8"> -->

									<img src="img/<%=c.getCimage()%>">
									<!-- <div class = "form-group"> -->

									

									<!--  </div> -->


									<!-- </div> -->

									<div class="feature-caption">
										<h3><%=c.getCname()%></h3>
										<p><%=c.getCcategory()%></p>

										<div class="price">

											<span><%=c.getCprice()%></span>
										</div>
										
									<a href="user-cart.jsp" class = "white-btn mr-10">Add To Cart</a>
									</div>

								</div>

							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	<%@include file="user-footer.jsp"%>
</body>
</html>