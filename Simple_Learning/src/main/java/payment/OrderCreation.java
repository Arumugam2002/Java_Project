package payment;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;

import com.razorpay.Order;
import com.razorpay.RazorpayClient;


import dao.CartDao;

@WebServlet("/OrderCreation")
public class OrderCreation extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public OrderCreation() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RazorpayClient client = null;
        String orderId = null;

        try {
            client = new RazorpayClient("rzp_test_L8oMPzGm1Bj2cF", "kIwej78eANLnME8QfH5drdaZ");
            String amount = request.getParameter("amount");
            Integer digit = Integer.parseInt(amount) * 100;
            int id = Integer.parseInt(request.getParameter("id"));

            System.out.println("Amount: " + digit);
            System.out.println("ID: " + id);

            JSONObject options = new JSONObject();
            options.put("amount", digit.toString());
            options.put("currency", "INR");
            options.put("receipt", "zxr456");
            options.put("payment_capture", true);

            Order order = client.Orders.create(options);
            orderId = order.get("id");

            System.out.println("Order ID: " + orderId);

            CartDao.updateStatus(id);

            response.getWriter().write(orderId);
        } catch (Exception e) {
            e.printStackTrace();
            response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
            response.getWriter().write("Error creating order");
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
