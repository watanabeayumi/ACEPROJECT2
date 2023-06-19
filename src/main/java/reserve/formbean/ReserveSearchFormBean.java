package reserve.formbean;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

public class ReserveSearchFormBean {
	private int reserveDate;
	private String name;
	private String call;
	private String mail;
	
	public ArrayList<String> validate(HttpServletRequest request){
	
	String reserve_date=request.getParameter("reserveDate");
	name=request.getParameter("name");
	call=request.getParameter("call");
	mail=request.getParameter("mail");
	
	ArrayList<String> errMsg=new ArrayList<>();
	
	ArrayList<String> reserveErr =new ArrayList<>();
	if("".equals(reserve_date)) {
		errMsg.add("チェックボックスが選択されていません。");
		reserveErr.add("チェックボックスが選択されていません。");
	}else {
		try{
	    	reserveDate = Integer.parseInt(reserve_date);
	    }catch(NumberFormatException e){
	    	reserveErr.add("日時が選択されていません。");
	    	request.setAttribute("ReserveErr", reserveErr);
	    	}
		}
	if("".equals(name)) {
		errMsg.add("名前が入力されていません。");
		String nameErr = "名前が入力されていません。";
		request.setAttribute("NameErr", nameErr);
	}
	
	ArrayList<String> callErr =new ArrayList<>();
	if("".equals(call)) {
		errMsg.add("電話番号が入力されていません。");
		callErr.add("電話番号が入力されていません。");
	}else{
        if(call.length() * 3 ==call.getBytes().length){
            errMsg.add("電話番号の入力に誤りがあります。");
            callErr.add("電話番号が入力に誤りがあります。");
            }
        try {
        	long longCall = Long.parseLong(call);
        }catch(NumberFormatException e){
        	errMsg.add("数字以外が入力されています。");
        	callErr.add("数字以外が入力されています。");
        	request.setAttribute("CallErr", callErr);
        }
         }
    if("".equals(mail)) {
		errMsg.add("メールアドレスが入力されていません。");
		String mailErr = "メールアドレスが入力されていません。";
		request.setAttribute("MailErr", mailErr);
	}
    return errMsg;
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
