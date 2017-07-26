package main.java.com.nbox.miniBank;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private String username;
	private String password;
	private ResultSet res;
       
    public Login() {
        super();
    }
    
    @Override
    public void init(ServletConfig config) throws ServletException{
    	
    	config.getServletContext().setAttribute("str", "something");
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//private variable initialization
		this.username = request.getParameter("username");
		this.password = request.getParameter("password");
		res = Connector.con.getRs("SELECT * FROM minibank.accounts WHERE username = '"+username+"' AND password='"+password+"';");
//		request.setAttribute("str", username);
		init();
		
		try {
			if (res.first()){
				String userId = res.getString(1);
				ResultSet resForBill = Connector.con.getRs("SELECT * FROM minibank.bills WHERE userId='"+userId+"';");
				resForBill.next();
				request.setAttribute("billId", resForBill.getString(1));
				request.setAttribute("cash", resForBill.getDouble(3));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		request.getRequestDispatcher("cabinet.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
