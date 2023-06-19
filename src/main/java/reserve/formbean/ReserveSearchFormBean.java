package reserve.formbean;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

public class ReserveSearchFormBean {
	private int reserveDate;
	private String name;
	private String call;
	private String mail;
	
	public ArrayList<String> checkDate(HttpServletRequest request){
		
		String reserve_date=request.getParameter("reserveDate");
		
		ArrayList<String> reserveErr =new ArrayList<>();
		if("".equals(reserve_date)) {
			reserveErr.add("チェックボックスが選択されていません。");
		}else {
			try{
				reserveDate = Integer.parseInt(reserve_date);
			}catch(NumberFormatException e){
				reserveErr.add("日時が選択されていません。");
			}
		}
		return reserveErr;
	}
	
	public ArrayList<String> checkName(HttpServletRequest request){
		
		name=request.getParameter("name");
		
		ArrayList<String> nameErr =new ArrayList<>();
		if("".equals(name)) {
			nameErr.add("名前が入力されていません。");
		}
		return nameErr;
	}
	
	public ArrayList<String> checkCall(HttpServletRequest request){
		
		call=request.getParameter("call");
		
		ArrayList<String> callErr =new ArrayList<>();
		if("".equals(call)) {
			callErr.add("電話番号が入力されていません。");
		}else{
			if(call.length() * 3 ==call.getBytes().length){
				callErr.add("電話番号が入力に誤りがあります。");
				}
			try {
				long longCall = Long.parseLong(call);
			}catch(NumberFormatException e){
				callErr.add("数字以外が入力されています。");
			}
		}
		return callErr;
	}
	
	public ArrayList<String> checkMail(HttpServletRequest request){
		
		mail=request.getParameter("mail");
		
		ArrayList<String> mailErr =new ArrayList<>();
		if("".equals(mail)) {
			mailErr.add("メールアドレスが入力されていません。");
		}
		return mailErr;
	}
	
	public int getReserveDate() {
		return reserveDate;
	}

	public void setReserveDate(int reserveDate) {
		this.reserveDate = reserveDate;
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCall() {
		return call;
	}
	public void setCall(String call) {
		this.call = call;
	}
	public String getMail() {
		return mail;
	}
	public void setMail(String mail) {
		this.mail = mail;
	}
}
