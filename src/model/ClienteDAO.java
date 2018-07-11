package model;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

public class ClienteDAO {

	public void create(Cliente c) {
		Connection con = ConnectionFactory.getConnection();
		PreparedStatement stmt = null;

		try {
			stmt = con.prepareStatement("INSERT INTO cliente (nomecliente, rg, telefone) VALUES (?,?,?)");
			stmt.setString(1, c.getNome());
			stmt.setInt(2, c.getRg());
			stmt.setString(3, c.getTelefone());

			stmt.executeUpdate();

			ConnectionFactory.closeConnection(con, stmt);

		} catch (SQLException ex) {
			JOptionPane.showMessageDialog(null, "Erro ao salvar: " + ex);
			ConnectionFactory.closeConnection(con, stmt);
		}
	}

	public static void select() {
		Connection con = ConnectionFactory.getConnection();
		PreparedStatement stmt = null;

		try {
			stmt = con.prepareStatement("select * from cliente");

			ResultSet resultado = stmt.executeQuery();
			while (resultado.next()) {
				System.out.print("ID: " + resultado.getInt("id"));
				System.out.print(" // Nome: " + resultado.getString("nomecliente"));
				System.out.print(" // RG: " + resultado.getInt("rg"));
				System.out.print(" // Telefone: " + resultado.getString("telefone"));
				System.out.println("");
			}
			System.out.println("");
			ConnectionFactory.closeConnection(con, stmt);

		} catch (SQLException ex) {
			JOptionPane.showMessageDialog(null, "Erro ao Consultar: " + ex);
			ConnectionFactory.closeConnection(con, stmt);
		}
	}

	public static void altera(Cliente c, int id) {
		Connection con = ConnectionFactory.getConnection();
		PreparedStatement stmt = null;

		try {
			stmt = con.prepareStatement("update cliente set nomecliente = ?, rg = ?, telefone = ?  where id = ?");
			stmt.setString(1, c.getNome());
			stmt.setInt(2, c.getRg());
			stmt.setString(3, c.getTelefone());
			stmt.setInt(4, id);

			stmt.executeUpdate();

			JOptionPane.showMessageDialog(null, "Salvo com sucesso!");
			ConnectionFactory.closeConnection(con, stmt);

		} catch (SQLException ex) {
			JOptionPane.showMessageDialog(null, "Erro ao salvar: " + ex);
			ConnectionFactory.closeConnection(con, stmt);
		}
	}

	public static void deleta(int id) {
		Connection con = ConnectionFactory.getConnection();
		PreparedStatement stmt = null;

		try {
			stmt = con.prepareStatement("delete from cliente where id = ?");
			stmt.setInt(1, id);

			stmt.executeUpdate();

			JOptionPane.showMessageDialog(null, "Salvo com sucesso!");
			ConnectionFactory.closeConnection(con, stmt);

		} catch (SQLException ex) {
			JOptionPane.showMessageDialog(null, "Erro ao salvar: " + ex);
			ConnectionFactory.closeConnection(con, stmt);
		}
	}
	
	public static List<Cliente> listar() {
		List<Cliente> listaCliente = new ArrayList<>();
		
		Connection con = ConnectionFactory.getConnection();
		PreparedStatement stmt = null;

		try {
			stmt = con.prepareStatement("select * from cliente");
			
			ResultSet resultado = stmt.executeQuery();
			while (resultado.next()) {
				int id = resultado.getInt("id");
				String nome = resultado.getString("nomecliente");
				int rg = resultado.getInt("rg");
				String telefone = resultado.getString("telefone");
				Cliente dao = new Cliente(rg, nome, telefone);
				listaCliente.add(dao);
			}
			
			ConnectionFactory.closeConnection(con, stmt);

		} catch (SQLException ex) {
			JOptionPane.showMessageDialog(null, "Erro ao Consultar: " + ex);
			ConnectionFactory.closeConnection(con, stmt);
		}
		return (listaCliente);
	}  
	
}
