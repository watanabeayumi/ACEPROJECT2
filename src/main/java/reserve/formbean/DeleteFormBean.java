package reserve.formbean;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

public class DeleteFormBean {
	private String name;
	private String tel;
	private String address;

	public ArrayList<String> checkName(HttpServletRequest request) throws UnsupportedEncodingException {
		request.setCharacterEncoding("utf-8");
		name = request.getParameter("name");
		
		ArrayList<String> nameErr = new ArrayList<>();
		
		if ("".equals(name)) {
			nameErr.add("名前が入力されていません。");
		}
		return nameErr;
	}
	
	public ArrayList<String> checkCall(HttpServletRequest request){
		tel = request.getParameter("call");
		
		ArrayList<String> callErr = new ArrayList<>();
		
		if ("".equals(tel)) {
			callErr.add("電話番号が入力されていません。");
		}
		return callErr;
	}
	
	public ArrayList<String> checkMail(HttpServletRequest request){
		address = request.getParameter("mail");
		
		ArrayList<String> mailErr = new ArrayList<>();
		
		if ("".equals(tel)) {
			mailErr.add("電話番号が入力されていません。");
		}
		return mailErr;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}
	
}