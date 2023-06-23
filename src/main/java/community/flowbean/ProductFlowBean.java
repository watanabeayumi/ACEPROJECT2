package community.flowbean;

import com.fasterxml.jackson.databind.JsonNode;

public class ProductFlowBean {
	private String janCd;
	private JsonNode productName;
	private JsonNode categoryName;
	private JsonNode prodCategoryName;
	private JsonNode brandName;

	public JsonNode getBrandName() {
		return brandName;
	}

	public void setBrandName(JsonNode brandName) {
		this.brandName = brandName;
	}

	public JsonNode getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(JsonNode categoryName) {
		this.categoryName = categoryName;
	}

	public JsonNode getProdCategoryName() {
		return prodCategoryName;
	}

	public void setProdCategoryName(JsonNode prodCategoryName) {
		this.prodCategoryName = prodCategoryName;
	}

	public String getJanCd() {
		return janCd;
	}

	public void setJanCd(String janCd) {
		this.janCd = janCd;
	}

	public JsonNode getProductName() {
		return productName;
	}

	public void setProductName(JsonNode productName) {
		this.productName = productName;
	}
}
