package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.time.LocalDateTime;

import javax.swing.JOptionPane;

public class VooDAO {
	public void create(Voo v) {
		Connection con = ConnectionFactory.getConnection();
		PreparedStatement stmt = null;

		try {
			stmt = con.prepareStatement("INSERT INTO voo(prefixo, origem, destino, horario, aviao) VALUES (?,?,?,?,?)");
			stmt.setString(1, v.getPrefixo());
			stmt.setString(2, v.getOrigem());
			stmt.setString(3, v.getDestino());
			stmt.setString(4, v.getTime());
			stmt.setInt(5, v.getAviao());

			stmt.executeUpdate();

			JOptionPane.showMessageDialog(null, "Salvo com sucesso!");

		} catch (SQLException ex) {
			JOptionPane.showMessageDialog(null, "Erro ao salvar: " + ex);

		} finally {
			ConnectionFactory.closeConnection(con, stmt);
		}

	}

	public static void select() {
		Connection con = ConnectionFactory.getConnection();
		PreparedStatement stmt = null;

		try {
			stmt = con.prepareStatement("select voo.*, aviao.nome from voo, aviao\r\n" + "where voo.aviao=aviao.id");

			ResultSet resultado = stmt.executeQuery();
			while (resultado.next()) {
				System.out.print("ID: " + resultado.getInt("id"));
				System.out.print(" // Prefixo: " + resultado.getString("prefixo"));
				System.out.print(" // Origem: " + resultado.getString("origem"));
				System.out.print(" // Destino: " + resultado.getString("destino"));
				System.out.print(" // Hora: " + resultado.getString("horario"));
				System.out.println("");
			}
			System.out.println("");
			ConnectionFactory.closeConnection(con, stmt);

		} catch (SQLException ex) {
			JOptionPane.showMessageDialog(null, "Erro ao Consultar: " + ex);
			ConnectionFactory.closeConnection(con, stmt);
		}
	}

	public static void altera(Voo c, int id) {
		Connection con = ConnectionFactory.getConnection();
		PreparedStatement stmt = null;

		try {
			stmt = con.prepareStatement(
					"update voo set destino = ?, origem = ?, prefixo = ?, horario = ?, aviao = ?  where id = ?");
			stmt.setString(1, c.getDestino());
			stmt.setString(2, c.getOrigem());
			stmt.setString(3, c.getPrefixo());
			stmt.setString(4, c.getTime());
			stmt.setInt(5, c.getAviao());
			stmt.setInt(6, id);

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
			stmt = con.prepareStatement("delete from voo where id = ?");
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
