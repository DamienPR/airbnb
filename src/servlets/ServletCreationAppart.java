package servlets;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.Adresse;
import beans.Logement;
import beans.Proprietaire;
import dao.DaoAdresse;
import dao.DaoLogement;
import dao.DaoProprietaire;

@WebServlet("/ServletCreationAppart")
public class ServletCreationAppart extends HttpServlet {

	private static final long serialVersionUID = 1L;
	public static final String NOM = "leNom";

	public ServletCreationAppart() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Proprietaire proprio = new Proprietaire();
		DaoProprietaire daoProprio = new DaoProprietaire(proprio);
		ArrayList<Proprietaire> maListe;
		String leNom = "";
		try {
			maListe = daoProprio.recupererDonnees();
			for (int i = 0; i < maListe.size(); i++) {
				proprio = maListe.get(i);
				leNom += "<option value = '" + proprio.getId() + "'>" + proprio.getNom() + "</option>";
				request.setAttribute(NOM, leNom);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		this.getServletContext().getRequestDispatcher("/ServletAfficherPlanning.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String id = request.getParameter("listeNom");
		int resultId = Integer.parseInt(id);

		String descriptionAppartement = request.getParameter("descriptionAppartement");
		String rue = request.getParameter("rue");
		String ville = request.getParameter("ville");

		Logement logement = new Logement();
		Adresse adresse = new Adresse();

		adresse.setRue(rue);
		adresse.setVille(ville);

		logement.setDescription(descriptionAppartement);
		logement.setIdProprio(resultId);

		DaoLogement daoLogement = new DaoLogement(logement);
		DaoAdresse daoAdresse = new DaoAdresse(adresse);

		daoLogement.sauverDonnees();
		int idLogement = daoLogement.recupererIdLogement();
		daoAdresse.getAdresse().setIdLogement(idLogement);
		daoAdresse.sauverDonnees();

		this.getServletContext().getRequestDispatcher("/ServletAfficherPlanning.jsp").forward(request, response);
	}
}
