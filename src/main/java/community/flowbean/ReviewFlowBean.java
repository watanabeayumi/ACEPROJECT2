package community.flowbean;

import com.fasterxml.jackson.databind.JsonNode;

public class ReviewFlowBean {
	private JsonNode productName;
	private String janCd;

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
