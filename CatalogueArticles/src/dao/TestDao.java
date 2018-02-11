package dao;

import java.util.List;

import metier.entites.Article;

public class TestDao {

	public static void main(String[] args) {
		
		ArticleDaoImpl dao = new ArticleDaoImpl();
		
		//Article a1 = dao.save(new Article("ASUS", 590, 4));
		//Article a2 = dao.save(new Article("DELL", 750, 2));
		
		//System.out.println(a1.toString());
		//System.out.println(a2.toString());
		
		System.out.println("Chercher des articles!!!");
		List<Article> articles = dao.getArticleParMotCle("%L%");
		for (Article a : articles) {
			System.out.println(a.toString());
		}
	}

}
