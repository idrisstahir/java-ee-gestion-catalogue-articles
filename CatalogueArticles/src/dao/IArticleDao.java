package dao;

import java.util.List;

import metier.entites.Article;

public interface IArticleDao {
	
	public Article saveArticle(Article a);
	public List<Article> getArticleParMotCle(String mc);
	public Article getArticle(Long idArticle);
	public Article updateArticle(Article a);
	public void deleteArticle(Long idArticle);

}
