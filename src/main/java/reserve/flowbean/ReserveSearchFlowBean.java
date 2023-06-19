package reserve.flowbean;

import java.time.LocalDate;

public class ReserveSearchFlowBean {
	private LocalDate reserveDate;
	private String name;
	private String call;
	private String mail;
	private int timeCd;
	private String timeName;
	private int conciergeCd;
	
	public int getConciergeCd() {
		return conciergeCd;
	}
	public void setConciergeCd(int conciergeCd) {
		this.conciergeCd = conciergeCd;
	}
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
	public LocalDate getReserveDate() {
		return reserveDate;
	}
	public void setReserveDate(LocalDate reserveDate) {
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

