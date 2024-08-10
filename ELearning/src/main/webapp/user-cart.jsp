<%@page import="model.Course"%>
<%@page import="dao.CourseDao"%>
<%@page import="dao.CartDao"%>
<%@page import="model.Cart"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="user-header.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<style>
      body {
            font-family: Arial, sans-serif;
        }
        .container-xxl {
            padding: 20px;
        }
        .table {
            width: 100%;
            border-collapse: collapse;
            margin: 20px 0;
        }
        .table th, .table td {
            border: 1px solid #ddd;
            padding: 8px;
        }
        .table th {
            background-color: #f2f2f2;
            text-align: center;
        }
        .table tbody tr:hover {
            background-color: #f1f1f1;
        }
        .table td h5, .table td h6 {
            margin: 0;
        }
        .table form {
            display: inline;
        }
        .table a {
            color: #007bff;
            text-decoration: none;
        }
        .table a:hover {
            text-decoration: underline;
        }
        form table {
            width: 100%;
            border: 1px solid #ddd;
            margin: 20px 0;
        }
        form table th, form table td {
            padding: 10px;
            text-align: left;
        }
        form table th {
            background-color: #f2f2f2;
        }
        form table td label {
            display: block;
            margin-bottom: 5px;
        }
        form table input[type="text"], form table input[type="number"] {
            width: 100%;
            padding: 8px;
            box-sizing: border-box;
            border: 1px solid #ddd;
            border-radius: 4px;
        }
        form table input[type="submit"] {
            background-color: #4CAF50;
            color: white;
            padding: 10px 20px;
            border: none;
            border-radius: 4px;
            cursor: pointer;
        }
        form table input[type="submit"]:hover {
            background-color: #45a049;
        }
    </style>
</head>

    

<body>
    <div class="container-xxl py-5">
        <div class="container">
            <div class="row g-4">
                <table class="table">
                    <thead>
                        <tr>
                            <th scope="col">Course Name</th>
                            <th scope="col">Course Price</th>
                            <th scope="col">Quantity</th>
                            <th scope="col">Total</th>
                            <th scope="col">Action</th>
                        </tr>
                    </thead>
                    <tbody>
                        <%
                        List<Cart> list = CartDao.getCartByUserId(u.getId());
                        int subtotal = 0;

                        for (Cart c : list) {
                            subtotal = subtotal + c.getTotalprice();
                            Course c1 = CourseDao.getCourseById(c.getCid());
                        %>
                        <tr>
                            <td><h5><%=c1.getCname()%></h5></td>
                            <td><h5><%=c1.getCprice()%></h5></td>
                            <td>
                                <form action="CartController" method="post">
                                    <input type="hidden" name="action" value="updatecart">
                                    <input type="hidden" name="cartid" value="<%=c.getCartid()%>">
                                    <input type="number" name="qty" value="<%=c.getQty()%>" onchange="this.form.submit();">
                                </form>
                            </td>
                            <td><%=c.getTotalprice()%></td>
                            <td>
                                <form id="remove-cart-form-<%=c.getCartid()%>" action="user-remove-from-cart.jsp" method="post" style="display: none;">
                                    <input type="hidden" name="cartid" value="<%=c.getCartid()%>">
                                </form>
                                <a href="javascript:void(0);" onclick="document.getElementById('remove-cart-form-<%=c.getCartid()%>').submit();">Remove From Cart</a>
                            </td>
                        </tr>
                        <%
                        }
                        %>
                        <tr>
                            <td colspan="3"><h5>Sub total</h5></td>
                            <td><h6><%=subtotal%></h6></td>
                            <td></td>
                        </tr>
                    </tbody>
                </table>

                <%
                Cart c = CartDao.getSingleCartByUserId(u.getId());
                %>

                <form action="user-payment.jsp?amount=<%= subtotal %>&cid=<%=c.getCartid() %>" method="post">
                    <table border="1">
                        <tbody>
                            <tr>
                                <th>S.NO</th>
                                <th>Label</th>
                                <th>Value</th>
                            </tr>
                            <tr>
                                <td>1</td>
                                <td><label>Amount</label></td>
                                <td><input type="text" name="TAX_Amount" value="<%=subtotal%>"></td>
                            </tr>
                            <tr>
                                <td></td>
                                <td></td>
                                <td><input value="checkout" type="submit"></td>
                            </tr>
                        </tbody>
                    </table>
                </form>
            </div>
        </div>
    </div>

    <%@include file="user-footer.jsp"%>
</body>



</html>