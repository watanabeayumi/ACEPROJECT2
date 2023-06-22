package reserve.formbean;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

public class DeleteFormBean {
	private String name;
	private String tel;
	private String address;

	public String checkName(HttpServletRequest request) throws UnsupportedEncodingException {
		request.setCharacterEncoding("utf-8");
		name = request.getParameter("name");
		
		String nameErr = null;
		
		if ("".equals(name)) {
			nameErr = "名前が入力されていません。";
		}
		return nameErr;
	}
	
	public ArrayList<String> checkCall(HttpServletRequest request){
		tel = request.getParameter("call");
		
		ArrayList<String> callErr =new ArrayList<>();
		if("".equals(tel)) {
			callErr.add("電話番号が入力されていません。");
		}else{
			if(tel.length() * 3 ==tel.getBytes().length){
				callErr.add("電話番号が入力に誤りがあります。");
				}
			try {
				long longCall = Long.parseLong(tel);
			}catch(NumberFormatException e){
				callErr.add("数字以外が入力されています。");
			}
		}
		return callErr;
	}
	
	public String checkMail(HttpServletRequest request){
		address = request.getParameter("mail");
		
		String mailErr = null;
		if("".equals(address)) {
			mailErr = "メールアドレスが入力されていません。";
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