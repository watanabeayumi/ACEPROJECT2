package reserve.formbean;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

public class DeleteFormBean {
	private String Name;
	private String Tel;
	private String Address;

	public ArrayList<String> validate(HttpServletRequest request) {
		Name = request.getParameter("Name");
		Tel = request.getParameter("Tel");
		Address = request.getParameter("Address");

		ArrayList<String> errMsg = new ArrayList<>();

		if ("".equals(Name)) {
			errMsg.add("名前が入力されていません。");
		}
		if ("".equals(Tel)) {
			errMsg.add("電話番号が入力されていません。");
		}
		try {
			int tel = Integer.parseInt(tel);

		} catch (NumberFormatException e) {
			errMsg.add("数字以外の文字が含まれています。");
		}
		if ("".equals(Address)) {
			errMsg.add("メールアドレスが入力されていません。");
		} else {
			if (Address.length() * 3 == Address.getBytes().length) {
				errMsg.add("全角が含まれています。");
			}
		}

		return errMsg;

	}

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}

	public String getTel() {
		return Tel;
	}

	public void setTel(String tel) {
		Tel = tel;
	}

	public String getAddress() {
		return Address;
	}

	public void setAddress(String address) {
		Address = address;
	}

	
	
	
	
}