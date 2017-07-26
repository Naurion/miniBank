package main.java.com.nbox.miniBank;

import java.io.IOException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/UpdateBill")
public class UpdateBill extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public UpdateBill() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		double balance = Double.parseDouble(request.getParameter("balance"));
		String userId = (String) request.getParameter("userid");
		Statement stmt = Connector.con.createStatement("UPDATE `minibank`.`bills` SET `cash`='" + balance + "' WHERE `userId`='" + userId + "';");
		request.getRequestDispatcher("confirm.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
