package web;

import java.io.IOException;
import java.util.List;

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
		
		String path = request.getServletPath();
		
		if(path.equals("/index.do")) {
			request.getRequestDispatcher("articles.jsp").forward(request, response);
		}
		else if(path.equals("/chercher.do")) {
			
			String motCle = request.getParameter("motCle");
			
			ArticleModel model = new ArticleModel();
			model.setMotCle(motCle);
			
			List<Article> articles = metier.getArticleParMotCle("%"+motCle+"%");
			model.setArticles(articles);
			
			request.setAttribute("model", model);
			request.getRequestDispatcher("articles.jsp").forward(request, response);
		}
		else {
			response.sendError(response.SC_NOT_FOUND);
		}
	}

}
