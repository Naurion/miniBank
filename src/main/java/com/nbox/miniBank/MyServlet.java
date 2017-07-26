package main.java.com.nbox.miniBank;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import main.java.com.nbox.miniBank.Connector;;

@WebServlet("/MyServlet")
public class MyServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF8");
		//Get data from start page.
		String username = (String) request.getParameter("username");
		String password = (String) request.getParameter("password");
		
		//Create new account
		Account acc = new Account(username, password);
		Bill bill = new Bill(acc.getUserId(), 0.0);
		
		
		//Create new account and bill in database.
		try {
			Connector.con.getStmt().setString(1, acc.getUserId());
			Connector.con.getStmt().setString(2, acc.getUsername());
			Connector.con.getStmt().setString(3, acc.getPassword());
			Connector.con.getStmt().execute();
			Connector.con.getCreateBill().setString(1, bill.getBillId());
			Connector.con.getCreateBill().setString(2, bill.getUserId());
			Connector.con.getCreateBill().setDouble(3, bill.getCash());
			Connector.con.getCreateBill().execute();

			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		//Send query to database and get answer.
		ResultSet res =  Connector.con.getRs("SELECT * FROM `minibank`.`accounts` WHERE userId = " + acc.getUserId() + ";");
		
		//Send attributes to request.
		request.setAttribute("res", res);

		
		//Action to .jsp.
		request.getRequestDispatcher("table.jsp").forward(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
