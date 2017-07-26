package main.java.com.nbox.miniBank;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Connector {
	
	//Create standart variable to connect to database.
	private String user = "root";
	private String password = "root";
	private String url = "jdbc:mysql://localhost:3306/minibank";
	
	private static Connection connection;
	private static PreparedStatement stmt;
	private static PreparedStatement createBill;
	private static ResultSet rs;
	public static Connector con = Connector.getInstance();


	
	
	//Getters and setters
    public static PreparedStatement getStmt() {
		return stmt;
	}
    

    public static PreparedStatement getCreateBill() {
		return createBill;
	}


	//Little override standart getter.
	public ResultSet getRs(String query) {
		try {
			this.rs = stmt.executeQuery(query);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return rs;
	}

	//Constructor with creating prepared statement.
	private Connector(){
		try{
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			connection = DriverManager.getConnection(url, user, password);
			this.stmt = connection.prepareStatement("INSERT INTO `minibank`.`accounts` (`userId`, `username`, `password`) VALUES (?, ?, ?);");
			this.createBill = connection.prepareStatement("INSERT INTO `minibank`.`bills` (`billId`, `userId`, `cash`) VALUES (?, ?, ?);");
			
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static Connector getInstance(){
		if (con == null){
			con = new Connector();
		}
		return con;
	}
	
	public Statement createStatement(String query){
		Statement stm = null;
		try {
			stm = this.connection.createStatement();
			stm.executeUpdate(query);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return stm;
	}
	
}
