package reserve.flowbean;

import java.time.LocalDate;

public class ReserveSearchFlowBean {
	LocalDate reserve_date;
	String name;
	String call;
	String mail;
	int timeCd;
	String timeName;
	
	public String getTimeName() {
		return timeName;
	}
	public void setTimeName(String timeName) {
		this.timeName = timeName;
	}
	public int getTimeCd() {
		return timeCd;
	}
	public void setTimeCd(int timeCd) {
		this.timeCd = timeCd;
	}
	public LocalDate getReserve_date() {
		return reserve_date;
	}
	public void setReserve_date(LocalDate reserve_date) {
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
