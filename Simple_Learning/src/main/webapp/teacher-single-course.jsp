<%@page import="dao.CourseDao"%>
<%@page import="model.Course"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@include file="teacher-header.jsp"%>
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

				<h1 class="mb-5">Manage Courses</h1>
			</div>
			<div class="row g-4">





				<div class="container-fluid contact py-5">
					<div class="container py-5">
						<div class="p-5 bg-light rounded">
							<div class="row g-4">




								<div class="col-lg-7">
									<form action="CourseController" class="" method="post"
										enctype="multipart/form-data">


										<input type="hidden" name="cid"
											class="w-100 form-control border-0 py-3 mb-4"
											value="<%=c.getCid()%>">

										<!-- <div class="col-8"> -->

										<img src="img/<%=c.getCimage()%>" height="200" width="200">
										<!-- <div class = "form-group"> -->

										<input type="file" name="cimage"
											class="w-100 form-control border-0 py-3 mb-4">

										<!--  </div> -->


										<!-- </div> -->


										<input type="text" name="cname"
											class="w-100 form-control border-0 py-3 mb-4"
											value="<%=c.getCname()%>"> <input type="text"
											name="cprice" class="w-100 form-control border-0 py-3 mb-4"
											value="<%=c.getCprice()%>"> <input type="text"
											name="ccategory"
											class="w-100 form-control border-0 py-3 mb-4"
											value="<%=c.getCcategory()%>">


										<textarea name="cdesc"
											class="w-100 form-control border-0 mb-4" rows="5" cols="10"
											value="<%=c.getCdesc()%>"></textarea>

										<button
											class="w-100 btn form-control border-secondary py-3 bg-white text-primary "
											name="action" value="update-course" type="submit">Update
											Course</button>

									</form>
								</div>
								<div class="col-lg-5"></div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	<%@include file="teacher-footer.jsp"%>
</body>
</html>