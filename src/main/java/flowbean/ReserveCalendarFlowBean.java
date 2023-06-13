package flowbean;

import java.time.LocalDate;

public class ReserveCalendarFlowBean {
	
	private LocalDate reserveDate;
	private Integer timeCd;
	private String timeName;
	private Integer conciergeCd;
	private String conciergeName;
	private String name;
	private String tel;
	private String address;
	
	
	public LocalDate getReserveDate() {
		return reserveDate;
	}
	public void setReserveDate(LocalDate reserveDate) {
		this.reserveDate = reserveDate;
	}
	public Integer getTimeCd() {
		return timeCd;
	}
	public void setTimeCd(Integer timeCd) {
		this.timeCd = timeCd;
	}
	public String getTimeName() {
		return timeName;
	}
	public void setTimeName(String timeName) {
		this.timeName = timeName;
	}
	public Integer getConciergeCd() {
		return conciergeCd;
	}
	public void setConciergeCd(Integer conciergeCd) {
		this.conciergeCd = conciergeCd;
	}
	public String getConciergeName() {
		return conciergeName;
	}
	public void setConciergeName(String conciergeName) {
		this.conciergeName = conciergeName;
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

