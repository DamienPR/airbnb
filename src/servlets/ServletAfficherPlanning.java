package servlets;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.Logement;
import beans.Proprietaire;
import dao.DaoLogement;
import dao.DaoProprietaire;

@WebServlet("/ServletAfficherPlanning")
public class ServletAfficherPlanning extends HttpServlet {

	private static final long serialVersionUID = 1L;
	public static final String NOM = "leNom";
	public static final String APPART = "appart";
	public static final String VILLE = "ville";
	public static final String ADRESSE = "adresse";

	public ServletAfficherPlanning() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int idProp = Integer.parseInt(request.getParameter("listeNom"));
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
		// Début de la méthode qui sert à afficher les listes de logement du
		// proprietaire
		Logement monLog = new Logement();
		DaoLogement daoAppart = new DaoLogement(monLog);
		ArrayList<Integer> listeIdLogement = new ArrayList<>();
		String ville = "Paris";
		String adresse = "rue simplon";
		try {
			listeIdLogement = daoAppart.recupererIdLogement(idProp);
			request.setAttribute("listeLogement", listeIdLogement);
			request.setAttribute(VILLE, ville);
			request.setAttribute(ADRESSE, adresse);
		} catch (Exception e) {
			e.printStackTrace();
		}
		this.getServletContext().getRequestDispatcher("/Planning.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}
}
