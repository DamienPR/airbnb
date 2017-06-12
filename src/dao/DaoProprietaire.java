package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import beans.Proprietaire;

public class DaoProprietaire {

	Proprietaire proprio;

	public DaoProprietaire(Proprietaire proprio) {
		super();
		this.proprio = proprio;
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
			String sql = "INSERT INTO `proprietaire` (`nom`, `prenom`, `telephone`, `email`) VALUES ('"
					+ this.proprio.getNom() + "', '" + this.proprio.getPrenom() + "', '" + this.proprio.getTel()
					+ "', '" + this.proprio.getEmail() + "')";
			st.executeUpdate(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} finally {
			try {
				st.close();
				cn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	public ArrayList<Proprietaire> recupererDonnees() throws SQLException {
		ArrayList<Proprietaire> proprio = new ArrayList<Proprietaire>();
		String url = "jdbc:mysql://localhost/airbnb";
		String login = "root";
		String password = "";
		String id;
		String nom;
		String prenom;
		String tel;
		String email;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection cn = DriverManager.getConnection(url, login, password);
			String requete = "SELECT * from proprietaire";
			Statement st = cn.createStatement();
			ResultSet result = st.executeQuery(requete);
			while (result.next()) {
				this.proprio = new Proprietaire();
				id = result.getString(1);
				this.proprio.setId(id);
				nom = result.getString(2);
				this.proprio.setNom(nom);
				prenom = result.getString(3);
				this.proprio.setPrenom(prenom);
				tel = result.getString(4);
				this.proprio.setTel(tel);
				email = result.getString(5);
				this.proprio.setEmail(email);
				proprio.add(this.proprio);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
		}
		return proprio;
	}
}