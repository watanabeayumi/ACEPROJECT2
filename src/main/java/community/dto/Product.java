package community.dto;

public class Product {
	private String userName;
	private String productName;
	private int star;
	private int janCd;
	private String category;
	private String genre;
	private String bland;
	private String review;
	
	public int getStar() {
		return star;
	}
	public void setStar(int star) {
		this.star = star;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public int getJanCd() {
		return janCd;
	}
	public void setJanCd(int janCd) {
		this.janCd = janCd;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getGenre() {
		return genre;
	}
	public void setGenre(String genre) {
		this.genre = genre;
	}
	public String getBland() {
		return bland;
	}
	public void setBland(String bland) {
		this.bland = bland;
	}
	public String getReview() {
		return review;
	}
	public void setReview(String review) {
		this.review = review;
	}
}