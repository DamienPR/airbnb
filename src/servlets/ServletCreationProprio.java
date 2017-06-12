package servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.Proprietaire;
import dao.DaoProprietaire;

@WebServlet("/creationProprio")
public class ServletCreationProprio extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public ServletCreationProprio() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.getServletContext().getRequestDispatcher("/CreationProprio.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String msg = "msgErreur";
		String nom = request.getParameter("nom");
		String prenom = request.getParameter("prenom");
		String tel = request.getParameter("tel");
		String email = request.getParameter("email");
		Proprietaire proprio = new Proprietaire();

		try {
			validerChamp(nom);
		} catch (Exception e) {
			request.setAttribute(msg, e.getMessage());

		}

		proprio.setNom(nom);
		proprio.setPrenom(prenom);
		proprio.setTel(tel);
		proprio.setEmail(email);
		
		DaoProprietaire daoProprio = new DaoProprietaire(proprio);

		daoProprio.sauverDonnees();
		this.getServletContext().getRequestDispatcher("/CreationProprio.jsp").forward(request, response);
	}

	private void validerChamp(String champ) throws Exception {
		if (champ == null || champ.trim().length() == 0) {
			throw new Exception("Renseignez le champ!!");
		}

	}

}
