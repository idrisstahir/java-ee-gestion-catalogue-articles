package web;

import java.io.IOException;
import java.util.List;

import javax.security.auth.message.callback.PrivateKeyCallback.Request;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.ArticleDaoImpl;
import dao.IArticleDao;
import metier.entites.Article;


public class ControleurServlet extends HttpServlet {
	
	private IArticleDao metier;
	
	@Override
	public void init() throws ServletException {
		metier = new ArticleDaoImpl();
	}
	
	@Override
	protected void doGet
	(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String chemin = request.getServletPath();
		
		if(chemin.equals("/index.do"))
		{
			request.getRequestDispatcher("articles.jsp").forward(request, response);
		}
		else if(chemin.equals("/chercher.do"))
		{
			String motCle = request.getParameter("motCle");
			
			ArticleModel model = new ArticleModel();
			model.setMotCle(motCle);
			
			List<Article> articles = metier.getArticleParMotCle("%"+motCle+"%");
			model.setArticles(articles);
			
			request.setAttribute("model", model);
			request.getRequestDispatcher("articles.jsp").forward(request, response);
		}
		else if(chemin.equals("/saisie.do"))
		{
			request.setAttribute("article", new Article());
			request.getRequestDispatcher("saisieArticle.jsp").forward(request, response);
		
		}
		else if(chemin.equals("/saveArticle.do") && (request.getMethod().equals("POST"))) 
		{
			String desi = request.getParameter("designation");
			double prix = Double.parseDouble(request.getParameter("prix"));
			int qte= Integer.parseInt(request.getParameter("quantite"));
			Article a = metier.saveArticle(new Article(desi, prix, qte));
			request.setAttribute("article", a);
			request.getRequestDispatcher("confirmation.jsp").forward(request, response);
		}
		else if(chemin.equals("/supprimerArticle.do")) {
			
			Long idArticle = Long.parseLong(request.getParameter("id"));
			metier.deleteArticle(idArticle);
			
			//request.getRequestDispatcher("articles.jsp").forward(request, response);
			response.sendRedirect("chercher.do?motCle=");
		}
		else if(chemin.equals("/editerArticle.do")) {
			
			Long idArticle = Long.parseLong(request.getParameter("id"));
			Article a = metier.getArticle(idArticle);
			request.setAttribute("article", a);
			request.getRequestDispatcher("editionArticle.jsp").forward(request, response);
		}
		else if(chemin.equals("/updateArticle.do") && (request.getMethod().equals("POST"))) 
		{
			Long idArticle = Long.parseLong(request.getParameter("id"));
			String desi = request.getParameter("designation");
			double prix = Double.parseDouble(request.getParameter("prix"));
			int qte= Integer.parseInt(request.getParameter("quantite"));
			
			Article a = new Article(desi, prix, qte);
			a.setIdArticle(idArticle);
			
			metier.updateArticle(a);
			
			request.setAttribute("article", a);
			request.getRequestDispatcher("confirmation.jsp").forward(request, response);
		}
		else
		{
			response.sendError(response.SC_NOT_FOUND);
		}
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
