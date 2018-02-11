package metier.entites;

import java.io.Serializable;

public class Article implements Serializable {
	
	private Long idArticle;
	private String designation;
	private double prix;
	private int quantite;
	
	public Article() {
		super();
	}

	public Article(String designation, double prix, int quantite) {
		super();
		this.designation = designation;
		this.prix = prix;
		this.quantite = quantite;
	}

	public Long getIdArticle() {
		return idArticle;
	}

	public void setIdArticle(Long idArticle) {
		this.idArticle = idArticle;
	}

	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}

	public double getPrix() {
		return prix;
	}

	public void setPrix(double prix) {
		this.prix = prix;
	}

	public int getQuantite() {
		return quantite;
	}

	public void setQuantite(int quantite) {
		this.quantite = quantite;
	}

	@Override
	public String toString() {
		return "Article [idArticle=" + idArticle + ", designation=" + designation + ", prix=" + prix + ", quantite="
				+ quantite + "]";
	}
	
	
	
}
