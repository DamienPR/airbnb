package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import beans.Adresse;

public class DaoAdresse {
	Adresse adresse;

	public DaoAdresse(Adresse adresse) {
		super();
		this.adresse = adresse;
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
			String sql = "INSERT INTO `adresse` (`rue`, `ville`, `Logement_idLogement`) VALUES ('"
					+ this.adresse.getRue() + "', '" + this.adresse.getVille() + "', '" + this.adresse.getIdLogement()
					+ "')";
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

	public Adresse getAdresse() {
		return adresse;
	}

	public void setAdresse(Adresse adresse) {
		this.adresse = adresse;
	}

}
