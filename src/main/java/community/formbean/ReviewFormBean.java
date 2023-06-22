package community.formbean;

import javax.servlet.http.HttpServletRequest;

public class ReviewFormBean {
	private String jan;

	public String checkJan(HttpServletRequest request){
		
		jan = request.getParameter("jan");
		
		String janErr = null;
		if("".equals(jan)) {
			janErr="バーコードを読み込めていません。";
		}
		return janErr;
	}
	public String getJan() {
		return jan;
	}

	public void setJan(String jan) {
		this.jan = jan;
	}
	

}
