<%@page import="dao.CourseDao"%>
<%@page import="dao.WishListDao"%>
<%@page import="model.WishList"%>
<%@page import="model.Course"%>
<%@page import="java.util.List"%>
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


	<div class="container-xxl py-5">
		<div class="container">
			<div class="text-center wow fadeInUp" data-wow-delay="0.1s">
				<h6 class="section-title bg-white text-center text-primary px-3">WishList</h6>
				<h1 class="mb-5">WishList Section</h1>
			</div>
			<div class="row g-4">
				<div class="container-fluid contact py-5">
					<div class="container py-5">
						<div class="p-5 bg-light rounded">
							<div class="row g-4">
								<%
								List<WishList> list = WishListDao.getWishListByUserId(u.getId());
								%>
								<%
								for (WishList w : list) {
								%>
								<%
								Course c = CourseDao.getCourseById(w.getCid());
								%>
								<div class="col-lg-4 col-md-6">
									<div class="course-item">
										<img src="img/<%=c.getCimage()%>" height="200" width="200"
											alt="<%=c.getCname()%>">
										<div class="feature-caption">
											<h3><%=c.getCname()%></h3>
											<div class="price">
												<span><%=c.getCprice()%></span>
											</div>
											<form id="remove-wishlist-form"
												action="user-remove-from-wishlist.jsp" method="post"
												style="display: none;">
												<input type="hidden" name="wid" value="<%=w.getWid()%>">
											</form>

											<a href="javascript:void(0);"
												onclick="document.getElementById('remove-wishlist-form').submit();">Remove
												From WishList</a>
										</div>
									</div>
								</div>
								<%
								}
								%>
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