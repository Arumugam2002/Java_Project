<%@page import="dao.TeacherDao"%>
<%@page import="dao.CourseDao"%>
<%@page import="model.Course"%>
<%@page import="model.Teacher"%>
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
	<!-- <div class="container-fluid bg-primary py-5 mb-5 page-header">
        <div class="container py-5">
            <div class="row justify-content-center">
                <div class="col-lg-10 text-center">
                    <h1 class="display-3 text-white animated slideInDown">Courses</h1>
                    <nav aria-label="breadcrumb">
                        <ol class="breadcrumb justify-content-center">
                            <li class="breadcrumb-item"><a class="text-white" href="#">Home</a></li>
                            <li class="breadcrumb-item"><a class="text-white" href="#">Pages</a></li>
                            <li class="breadcrumb-item text-white active" aria-current="page">Courses</li>
                        </ol>
                    </nav>
                </div>
            </div>
        </div>
    </div> -->
	<!-- Header End -->


	<!-- Categories Start -->
	<!-- <div class="container-xxl py-5 category">
        <div class="container">
            <div class="text-center wow fadeInUp" data-wow-delay="0.1s">
                <h6 class="section-title bg-white text-center text-primary px-3">Categories</h6>
                <h1 class="mb-5">Courses Categories</h1>
            </div>
            <div class="row g-3">
                <div class="col-lg-7 col-md-6">
                    <div class="row g-3">
                        <div class="col-lg-12 col-md-12 wow zoomIn" data-wow-delay="0.1s">
                            <a class="position-relative d-block overflow-hidden" href="">
                                <img class="img-fluid" src="img/cat-1.jpg" alt="">
                                <div class="bg-white text-center position-absolute bottom-0 end-0 py-2 px-3" style="margin: 1px;">
                                    <h5 class="m-0">Web Design</h5>
                                    <small class="text-primary">49 Courses</small>
                                </div>
                            </a>
                        </div>
                        <div class="col-lg-6 col-md-12 wow zoomIn" data-wow-delay="0.3s">
                            <a class="position-relative d-block overflow-hidden" href="">
                                <img class="img-fluid" src="img/cat-2.jpg" alt="">
                                <div class="bg-white text-center position-absolute bottom-0 end-0 py-2 px-3" style="margin: 1px;">
                                    <h5 class="m-0">Graphic Design</h5>
                                    <small class="text-primary">49 Courses</small>
                                </div>
                            </a>
                        </div>
                        <div class="col-lg-6 col-md-12 wow zoomIn" data-wow-delay="0.5s">
                            <a class="position-relative d-block overflow-hidden" href="">
                                <img class="img-fluid" src="img/cat-3.jpg" alt="">
                                <div class="bg-white text-center position-absolute bottom-0 end-0 py-2 px-3" style="margin: 1px;">
                                    <h5 class="m-0">Video Editing</h5>
                                    <small class="text-primary">49 Courses</small>
                                </div>
                            </a>
                        </div>
                    </div>
                </div>
                <div class="col-lg-5 col-md-6 wow zoomIn" data-wow-delay="0.7s" style="min-height: 350px;">
                    <a class="position-relative d-block h-100 overflow-hidden" href="">
                        <img class="img-fluid position-absolute w-100 h-100" src="img/cat-4.jpg" alt="" style="object-fit: cover;">
                        <div class="bg-white text-center position-absolute bottom-0 end-0 py-2 px-3" style="margin:  1px;">
                            <h5 class="m-0">Online Marketing</h5>
                            <small class="text-primary">49 Courses</small>
                        </div>
                    </a>
                </div>
            </div>
        </div>
    </div> -->
	<!-- Categories Start -->


	<!-- Courses Start -->
	<div class="container-xxl py-5">
		<div class="container">
			<div class="text-center wow fadeInUp" data-wow-delay="0.1s">

				<%
				String msg = (String) request.getAttribute("msg");

				if (msg != null) {
				%>

				<div class="col-12">
					<h4 class="contact-title">
						<%
						out.print(msg);
						%>
					</h4>

				</div>
				<%
				}
				%>
				
				<%
				String msg1 = (String) request.getAttribute("msg1");

				if (msg1 != null) {
				%>

				<div class="col-12">
					<h4 class="contact-title">
						<%
						out.print(msg1);
						%>
					</h4>

				</div>
				<%
				}
				%>
				<h6 class="section-title bg-white text-center text-primary px-3">Courses</h6>
				<h1 class="mb-5">Popular Courses</h1>
			</div>
			<div class="row g-4 justify-content-center">
				<div class="col-lg-12 wow fadeInUp" data-wow-delay="0.1s">
					<div class="d-flex flex-wrap justify-content-center">
						<%
						List<Course> list = CourseDao.getAllCourses();
						List<Teacher> list1 = TeacherDao.getTeacherName();
						%>
						<%
						for (Course c : list) {
							Teacher t1 = null;
							for (Teacher t : list1) {
								if (t.getId() == c.getTid()) {
							t1 = t;
							break;
								}
							}
							if (t1 != null) {
						%>
						<div class="course-item bg-light m-2"
							style="flex: 1 0 21%; max-width: 21%; position: relative;">
							<div class="position-relative overflow-hidden">
								<img src="img/<%=c.getCimage()%>" class="img-fluid"
									style="height: 200px; width: 100%; object-fit: cover;">
							</div>
							<div class="text-center p-4 pb-0">
								<h3 class="mb-0"><%=c.getCprice()%></h3>

								<h5 class="mb-4">
									<a href="user-single-course.jsp?id=<%=c.getCid()%>"><%=c.getCname()%></a>
								</h5>
								<div class="icon-overlay text-center mb-3">
									<form action="CartController" method="post"
										style="display: inline-block;">
										<input type="hidden" name="action" value="addtocart">
										<input type="hidden" name="userid" value="<%=u.getId()%>">
										<input type="hidden" name="cid" value="<%=c.getCid()%>">
										<button type="submit" class="text-primary mx-2">
											<i class="fa fa-shopping-cart"></i>
										</button>
									</form>

									<form action="WishListController" method="post"
										style="display: inline-block;">
										<input type="hidden" name="action" value="addtowishlist">
										<input type="hidden" name="userid" value="<%=u.getId()%>">
										<input type="hidden" name="cid" value="<%=c.getCid()%>">
										<button type="submit" class="text-primary mx-2"
											style="background: none; border: none; padding: 0;">
											<i class="fa fa-heart"></i>
										</button>
									</form>

								</div>
								<div class="d-flex border-top">
									<h6 class="mb-4">
										<span><%=t1.getName()%></span>
									</h6>
								</div>
							</div>
						</div>
						<%
						}
						}
						%>
					</div>
				</div>
			</div>
		</div>
	</div>











	<!-- Courses End -->


	<!-- Testimonial Start -->
	<div class="container-xxl py-5 wow fadeInUp" data-wow-delay="0.1s">
		<div class="container">
			<div class="text-center">
				<h6 class="section-title bg-white text-center text-primary px-3">Testimonial</h6>
				<h1 class="mb-5">Our Students Say!</h1>
			</div>
			<div class="owl-carousel testimonial-carousel position-relative">
				<div class="testimonial-item text-center">
					<img class="border rounded-circle p-2 mx-auto mb-3"
						src="img/testimonial-1.jpg" style="width: 80px; height: 80px;">
					<h5 class="mb-0">Client Name</h5>
					<p>Profession</p>
					<div class="testimonial-text bg-light text-center p-4">
						<p class="mb-0">Tempor erat elitr rebum at clita. Diam dolor
							diam ipsum sit diam amet diam et eos. Clita erat ipsum et lorem
							et sit.</p>
					</div>
				</div>
				<div class="testimonial-item text-center">
					<img class="border rounded-circle p-2 mx-auto mb-3"
						src="img/testimonial-2.jpg" style="width: 80px; height: 80px;">
					<h5 class="mb-0">Client Name</h5>
					<p>Profession</p>
					<div class="testimonial-text bg-light text-center p-4">
						<p class="mb-0">Tempor erat elitr rebum at clita. Diam dolor
							diam ipsum sit diam amet diam et eos. Clita erat ipsum et lorem
							et sit.</p>
					</div>
				</div>
				<div class="testimonial-item text-center">
					<img class="border rounded-circle p-2 mx-auto mb-3"
						src="img/testimonial-3.jpg" style="width: 80px; height: 80px;">
					<h5 class="mb-0">Client Name</h5>
					<p>Profession</p>
					<div class="testimonial-text bg-light text-center p-4">
						<p class="mb-0">Tempor erat elitr rebum at clita. Diam dolor
							diam ipsum sit diam amet diam et eos. Clita erat ipsum et lorem
							et sit.</p>
					</div>
				</div>
				<div class="testimonial-item text-center">
					<img class="border rounded-circle p-2 mx-auto mb-3"
						src="img/testimonial-4.jpg" style="width: 80px; height: 80px;">
					<h5 class="mb-0">Client Name</h5>
					<p>Profession</p>
					<div class="testimonial-text bg-light text-center p-4">
						<p class="mb-0">Tempor erat elitr rebum at clita. Diam dolor
							diam ipsum sit diam amet diam et eos. Clita erat ipsum et lorem
							et sit.</p>
					</div>
				</div>
			</div>
		</div>
	</div>
	<!-- Testimonial End -->


	<!-- Footer Start -->
	<%@include file="user-footer.jsp"%>
</body>
</html>