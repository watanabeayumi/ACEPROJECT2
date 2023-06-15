package reserve.formbean;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

public class DeleteFormBean {
	private String name;
	private String tel;
	private String address;

	public ArrayList<String> validate(HttpServletRequest request) throws UnsupportedEncodingException {
		
		request.setCharacterEncoding("utf-8");
		name = request.getParameter("name");
		tel = request.getParameter("call");
		address = request.getParameter("mail");

		ArrayList<String> errMsg = new ArrayList<>();

		if ("".equals(name)) {
			errMsg.add("名前が入力されていません。");
		}
		if ("".equals(tel)) {
			errMsg.add("電話番号が入力されていません。");
		}
		try {
			int intTel = Integer.parseInt(tel);

		} catch (NumberFormatException e) {
			errMsg.add("数字以外の文字が含まれています。");
		}
		if ("".equals(address)) {
			errMsg.add("メールアドレスが入力されていません。");
		}
		return errMsg;
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