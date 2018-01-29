package br.com.curso.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DefaultConnection {
	private Connection con;
	private final String url = "jdbc:postgresql://localhost:5432/curso" ;
	private final String user = "postgres";
	private final String passaword = "123";

	public DefaultConnection( ) {
		try {
			Class.forName("org.postgresql.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	public Connection getConnection() {
		if(con != null) {
			return con;
		}
		
		try {
			con = DriverManager.getConnection(url,user,passaword);
			con.setAutoCommit(true);
			System.out.println("Conectou!");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		return con;
	}
	
	public void closeConnection() {
		try {
			con.close();
			con = null;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public static void main(String args[]){
		new DefaultConnection().getConnection();
	}
}
