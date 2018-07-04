package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;

import javax.swing.JOptionPane;

public class BilheteDAO {
	public void create(Bilhete b) {
		Connection con = ConnectionFactory.getConnection();
		PreparedStatement stmt = null;
		
		try {
			stmt = con.prepareStatement("INSERT INTO Bilhete (localizador, idcliente, idvoo, horacompra) VALUES (?,?,?,?)");
			stmt.setString(1, b.getLocalizador() );
			stmt.setInt(2, b.getCliente());
			stmt.setInt(3, b.getVoo());
			stmt.setString(4, b.getDataHora());
			stmt.executeUpdate();
			
			JOptionPane.showMessageDialog(null, "Salvo com sucesso!");
			ConnectionFactory.closeConnection(con,stmt);
			
		} catch (SQLException ex) {
			JOptionPane.showMessageDialog(null, "Erro ao salvar: "+ex);
			ConnectionFactory.closeConnection(con,stmt);
		}		
	}
	
	public static void select() {
		Connection con = ConnectionFactory.getConnection();
		PreparedStatement stmt = null;
		
		try {
			stmt = con.prepareStatement("select * from bilhete, cliente, voo\r\n" + 
					"where bilhete.idcliente= cliente.id\r\n" + 
					"and bilhete.idvoo = voo.id");
						
			
			ResultSet resultado = stmt.executeQuery();
			while (resultado.next()) {
				System.out.print("ID: " + resultado.getInt("id"));
				System.out.print(" // localizador: " + resultado.getString("localizador"));
				System.out.print(" // Cliente: " + resultado.getString("nomecliente"));
				System.out.print(" // Hora compra: " + resultado.getString("horacompra"));
				System.out.print(" // Origem: "+resultado.getString("origem"));
				System.out.print(" // Destino: "+resultado.getString("destino"));
				System.out.print(" // Horario: "+resultado.getString("horario"));
				System.out.println("");
			}
			System.out.println("");
			ConnectionFactory.closeConnection(con,stmt);
			
		} catch (SQLException ex) {
			JOptionPane.showMessageDialog(null, "Erro ao Consultar: "+ex);
			ConnectionFactory.closeConnection(con,stmt);
		}		
	}
	public static void deleta(int id) {
		Connection con = ConnectionFactory.getConnection();
		PreparedStatement stmt = null;

		try {
			stmt = con.prepareStatement("delete from bilhete where id = ?");
			stmt.setInt(1, id);

			stmt.executeUpdate();

			JOptionPane.showMessageDialog(null, "Salvo com sucesso!");
			ConnectionFactory.closeConnection(con, stmt);

		} catch (SQLException ex) {
			JOptionPane.showMessageDialog(null, "Erro ao salvar: " + ex);
			ConnectionFactory.closeConnection(con, stmt);
		}
	}
}
