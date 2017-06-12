package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import beans.Logement;

public class DaoLogement {
	Logement logement;

	public DaoLogement(Logement logement) {
		super();
		this.logement = logement;
	}

	public void sauverDonnees() {
		String url = "jdbc:mysql://localhost/airbnb";
		String login = "root";
		String password = "";
		Connection cn = null;
		Statement st = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			cn = DriverManager.getConnection(url, login, password);
			st = cn.createStatement();
			String sql = "INSERT INTO `logement` (`description`, `Proprietaire_idProprietaire`) VALUES ('"
					+ this.logement.getDescription() + "', '" + this.logement.getIdProprio() + "')";
			st.executeUpdate(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} finally {
			try {
				cn.close();
				st.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	public ArrayList<Integer> recupererIdLogement(int idProp) {
		String url = "jdbc:mysql://localhost/airbnb";
		String login = "root";
		String password = "";
		ArrayList<Integer> listeIdLogement = new ArrayList<>();
		Connection cn = null;
		Statement st = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			cn = DriverManager.getConnection(url, login, password);
			st = cn.createStatement();
			String sql = "SELECT DISTINCT idLogement "
					+ "FROM Logement "
					+ "INNER JOIN proprietaire "
					+ "ON "+ idProp +"= Proprietaire_idProprietaire";
			ResultSet rs = st.executeQuery(sql);
			while (rs.next()) {
				listeIdLogement.add(rs.getInt(1));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} finally {
			try {
				cn.close();
				st.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return listeIdLogement;
	}
	
	
	public int recupererIdLogement() {
		String url = "jdbc:mysql://localhost/airbnb";
		String login = "root";
		String password = "";
		int IdLogement = 0;
		Connection cn = null;
		Statement st = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			cn = DriverManager.getConnection(url, login, password);
			st = cn.createStatement();
			String sql = "SELECT `idLogement` FROM `Logement` ORDER BY `idLogement` DESC LIMIT 1";
			ResultSet rs = st.executeQuery(sql);
			while (rs.next()) {
				IdLogement = rs.getInt(1);
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} finally {
			try {
				cn.close();
				st.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return IdLogement;
	}


	public int recupererTotalLogementProprio(int idProprio) {
		String url = "jdbc:mysql://localhost/airbnb";
		String login = "root";
		String password = "";
		int totalLogement = 0;
		Connection cn = null;
		Statement st = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			cn = DriverManager.getConnection(url, login, password);
			st = cn.createStatement();
			String sql = "SELECT COUNT(idLogement) FROM logement WHERE Proprietaire_idProprietaire = idProprio";
			ResultSet rs = st.executeQuery(sql);
			while (rs.next()) {
				totalLogement = rs.getInt(1);

			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} finally {
			try {
				cn.close();
				st.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return totalLogement;
	}
}
