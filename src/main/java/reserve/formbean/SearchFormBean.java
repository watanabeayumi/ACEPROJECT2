package reserve.formbean;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

public class SearchFormBean {
	private String reserve_date;
	private String name;
	private String call;
	private String mail;
	
	
	public ArrayList<String> validate(HttpServletRequest request){
	
	reserve_date=request.getParameter("reserve_date");
	name=request.getParameter("name");
	call=request.getParameter("call");
	mail=request.getParameter("mail");
	
	ArrayList<String> errMsg=new ArrayList<>();
	
	if("".equals(name)) {
		errMsg.add("名前が入力されていません。");
	}
	
	if("".equals(call)) {
		errMsg.add("電話番号が入力されていません。");
	}
	
    try{
    	int callnumber=Integer.parseInt(call);
    	}catch(NumberFormatException e){
    		errMsg.add("数字以外が入力されています。");
    		}
    if("".equals(mail)) {
		errMsg.add("メールアドレスが入力されていません。");
	}else{
        if(call.length() * 3 ==call.getBytes().length){
           errMsg.add("全角が含まれています。");
           }
        }
    return errMsg;
}
	public String getReserve_date() {
		return reserve_date;
	}
	public void setReserve_date(String reserve_date) {
		this.reserve_date = reserve_date;
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
