package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ConnectionFactory {

	private static final String DRIVE = "org.postgresql.Driver";
	private static final String URL = "jdbc:postgresql://localhost:5432/Trabalho01LB2";
	private static final String USER = "postgres";
	private static final String PASS = "admin";

	public static Connection getConnection(){

		try {
			Class.forName(DRIVE);
			return DriverManager.getConnection(URL, USER, PASS);
		} catch (ClassNotFoundException | SQLException ex) {
			throw new RuntimeException("Erro de Conexão: ", ex);
		}
	}

	public static void closeConnection(Connection con) {
		try {
			if(con!=null) {
				con.close();
			}
		} catch (SQLException ex) {
			Logger.getLogger(ConnectionFactory.class.getName()).log(Level.SEVERE, null, ex);
		}
	}
	
	public static void closeConnection(Connection con, PreparedStatement stmt) {
		
		closeConnection(con);
		try {
			if(stmt !=null) {
				stmt.close();
			}
		} catch (SQLException ex) {
			Logger.getLogger(ConnectionFactory.class.getName()).log(Level.SEVERE, null, ex);
		}
	}
	
	public static void closeConnection(Connection con, PreparedStatement stmt, ResultSet rs) {
		
		closeConnection(con, stmt);
		try {
			if(rs!= null) {
				rs.close();
			}
		} catch (SQLException ex) {
			Logger.getLogger(ConnectionFactory.class.getName()).log(Level.SEVERE, null, ex);
		}
	}

}
