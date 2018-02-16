package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import metier.entites.Article;

public class ArticleDaoImpl implements IArticleDao {

	@Override
	public Article saveArticle(Article a) {
		
		Connection connection = SingleConnect.getConnection();
		
		try {
			PreparedStatement ps1 = connection.prepareStatement
					("INSERT INTO articles (designation, prix, quantite) VALUES (?, ?, ?)");
			ps1.setString(1, a.getDesignation());
			ps1.setDouble(2, a.getPrix());
			ps1.setInt(3, a.getQuantite());
			
			ps1.executeUpdate();
			
			PreparedStatement ps2 = connection.prepareStatement
					("SELECT MAX(id_article) as max_id FROM articles");
			ResultSet rs = ps2.executeQuery();
			
			if(rs.next()) {
				a.setIdArticle(rs.getLong("max_id"));
			}
			
			ps1.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return a;
	}

	@Override
	public List<Article> getArticleParMotCle(String mc) {
		
		List<Article> articles = new ArrayList<Article>();
		Connection connection = SingleConnect.getConnection();
		
		try {
			PreparedStatement ps = connection.prepareStatement
					("SELECT * FROM articles WHERE designation LIKE ?");
			
			ps.setString(1, mc);
			
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				Article a = new Article();
				a.setIdArticle(rs.getLong("id_article"));
				a.setDesignation(rs.getString("designation"));
				a.setPrix(rs.getDouble("prix"));
				a.setQuantite(rs.getInt("quantite"));
				articles.add(a);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return articles;
	}

	@Override
	public Article getArticle(Long idArticle) {
		Article a = null;
		Connection connection = SingleConnect.getConnection();
		try {
			PreparedStatement ps = connection.prepareStatement
					("SELECT * FROM articles WHERE id_article = ?");
			
			ps.setLong(1, idArticle);
			
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				a = new Article();
				a.setIdArticle(rs.getLong("id_article"));
				a.setDesignation(rs.getString("designation"));
				a.setPrix(rs.getDouble("prix"));
				a.setQuantite(rs.getInt("quantite"));
			};
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return a;
	}

	@Override
	public Article updateArticle(Article a) {
		Connection connection = SingleConnect.getConnection();
		
		try {
			PreparedStatement ps1 = connection.prepareStatement
					("UPDATE articles SET designation=?, prix=?, quantite=? WHERE id_article=?");
			
			ps1.setString(1, a.getDesignation());
			ps1.setDouble(2, a.getPrix());
			ps1.setInt(3, a.getQuantite());
			ps1.setLong(4, a.getIdArticle());
			
			ps1.executeUpdate();
			
			ps1.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return a;
	}

	@Override
	public void deleteArticle(Long idArticle) {
		
		Connection connection = SingleConnect.getConnection();
		
		try {
			PreparedStatement ps1 = connection.prepareStatement
					("DELETE FROM articles WHERE id_article = ?");
			ps1.setLong(1, idArticle);
			ps1.executeUpdate();
			ps1.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

}
