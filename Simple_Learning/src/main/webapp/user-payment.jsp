<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Payment Page</title>
<style type="text/css">
    .bttnStyle {
        background-color: lightblue;
        border-radius: 0.50rem;
        border: 1px solid transparent;
    }
</style>
<script type="text/javascript">
    var xhttp = new XMLHttpRequest();
    var RazorpayOrderId;
    function CreateOrderID() {
        var number = document.getElementById("amount").value;
        var cid = document.getElementById("cid").value;
        xhttp.onreadystatechange = function() {
            if (this.readyState == 4) {
                if (this.status == 200) {
                    RazorpayOrderId = this.responseText.trim();
                    console.log("Order ID: " + RazorpayOrderId);
                    OpenCheckOut(number);
                } else {
                    alert("Failed to create order ID. Status: " + this.status + ", Response: " + this.responseText);
                }
            }
        };
        xhttp.open("GET", "http://localhost:8080/ELearning/OrderCreation?amount=" + number + "&id=" + cid, true);
        xhttp.send();
    }
</script>
<script src="https://checkout.razorpay.com/v1/checkout.js"></script>
<script type="text/javascript">
    function OpenCheckOut(number) {
        var options = {
            "key": "rzp_test_L8oMPzGm1Bj2cF",
            "amount": number,
            "currency": "INR",
            "name": "Arumugam",
            "description": "Test",
            "order_id": RazorpayOrderId,
            "callback_url": "http://localhost:8080/ELearning/user-home.jsp",
            "prefill": {
                "name": "Arumugam Pandaram",
                "email": "arumugampandaram65@gmail.com",
                "contact": "8347589077"
            },
            "notes": {
                "address": "Ahmedabad"
            },
            "theme": {
                "color": "#3399cc"
            }
        };
        var rzp1 = new Razorpay(options);
        rzp1.on('payment.failed', function (response) {
            alert("Payment failed");
            alert(response.error.code);
            alert(response.error.description);
            alert(response.error.source);
            alert(response.error.step);
            alert(response.error.reason);
            alert(response.error.metadata.order_id);
            alert(response.error.metadata.payment_id);
        });
        try {
            rzp1.open();
        } catch (e) {
            alert("Oops something went wrong. Error in opening checkout");
        }
    }
</script>
</head>
<body>
<div id="order_id"></div>
<% int am = Integer.parseInt(request.getParameter("amount")); %>
<% int cid = Integer.parseInt(request.getParameter("cid")); %>
<h3 style="text-align: center">Amount to pay: <% out.print(am); %></h3>
<center>
    <input type="hidden" id="amount" value="<%= am %>">
    <input type="hidden" id="cid" value="<%= cid %>">
    <button id="payButton" onclick="CreateOrderID()" class="bttnStyle">Pay Now</button>
</center>
</body>
</html>
