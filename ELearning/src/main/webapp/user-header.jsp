<%@page import="dao.WishListDao"%>
<%@page import="dao.CartDao"%>
<%@page import="model.WishList"%>
<%@page import="java.util.List"%>
<%@ page import="model.User" %>
<%@ page import="model.Cart" %>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>Simple Learning</title>
    <meta content="width=device-width, initial-scale=1.0" name="viewport">
    <meta content="" name="keywords">
    <meta content="" name="description">

    <!-- Favicon -->
    <link href="img/favicon.png" rel="icon">

    <!-- Google Web Fonts -->
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Heebo:wght@400;500;600&family=Nunito:wght@600;700;800&display=swap" rel="stylesheet">

    <!-- Icon Font Stylesheet -->
    <link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.10.0/css/all.min.css" rel="stylesheet">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.4.1/font/bootstrap-icons.css" rel="stylesheet">

    <!-- Libraries Stylesheet -->
    <link href="lib/animate/animate.min.css" rel="stylesheet">
    <link href="lib/owlcarousel/assets/owl.carousel.min.css" rel="stylesheet">

    <!-- Customized Bootstrap Stylesheet -->
    <link href="css/bootstrap.min.css" rel="stylesheet">

    <!-- Template Stylesheet -->
    <link href="css/style.css" rel="stylesheet">
</head>
<body>

<%
    User u = null;
    
    if(session.getAttribute("data")!=null)
    {
    	u = (User) session.getAttribute("data");
    }
    
    else{
    	response.sendRedirect("user-login.jsp");
    	
    }
    
    %>
<div id="spinner" class="show bg-white position-fixed translate-middle w-100 vh-100 top-50 start-50 d-flex align-items-center justify-content-center">
        <div class="spinner-border text-primary" style="width: 3rem; height: 3rem;" role="status">
            <span class="sr-only">Loading...</span>
        </div>
    </div>
    <!-- Spinner End -->


    <!-- Navbar Start -->
    <nav class="navbar navbar-expand-lg bg-white navbar-light shadow sticky-top p-0">
    <a href="index.jsp" class="navbar-brand d-flex align-items-center px-4 px-lg-5">
        <h2 class="m-0 text-primary"><i class="fa fa-book me-3"></i>Simple Learning</h2>
    </a>
    <button type="button" class="navbar-toggler me-4" data-bs-toggle="collapse" data-bs-target="#navbarCollapse">
        <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse" id="navbarCollapse">
        <div class="navbar-nav ms-auto p-4 p-lg-0">
            <a href="user-home.jsp" class="nav-item nav-link active">Home</a>
            <a href="user-about-page.jsp" class="nav-item nav-link">About</a>
            <a href="user-courses-page.jsp" class="nav-item nav-link">Courses</a>
            <div class="nav-item dropdown">
                <a href="#" class="nav-link dropdown-toggle" data-bs-toggle="dropdown">Pages</a>
                <div class="dropdown-menu fade-down m-0">
                    <a href="team-page.jsp" class="dropdown-item">Our Team</a>
                    <a href="testimonial-page.jsp" class="dropdown-item">Testimonial</a>
                    <a href="404.html" class="dropdown-item">404 Page</a>
                </div>
            </div>
            <div class="nav-item dropdown">
                <a href="#" class="nav-link dropdown-toggle" data-bs-toggle="dropdown"><%= u.getName() %></a>
                <div class="dropdown-menu fade-down m-0">
                    <a href="user-profile.jsp" class="dropdown-item">Profile</a>
                    <a href="user-change-password.jsp" class="dropdown-item">Change Password</a>
                    <a href="user-logout.jsp" class="dropdown-item">Logout</a>
                </div>
            </div>
            <a href="user-contact-page.jsp" class="nav-item nav-link">Contact</a>
            <%List<Cart> cList = CartDao.getCartByUserId(u.getId());%>
            <a href="user-cart.jsp" class="nav-item nav-link"><i class="fa fa-shopping-cart"><%out.print(cList.size()); %></i></a>
            <%List<WishList> wList = WishListDao.getWishListByUserId(u.getId()); %>
            <a href="user-wishlist.jsp" class="nav-item nav-link"><i class="fa fa-heart"><%out.print(wList.size()); %></i></a>
        </div>
        <a href="" class="btn btn-primary py-4 px-lg-5 d-none d-lg-block">Join Now<i class="fa fa-arrow-right ms-3"></i></a>
    </div>
</nav>

    
   
</body>
</html>