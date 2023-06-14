package reserve.dto;

import java.time.LocalDate;

public class Reserve {
	private String name;
	private String timeName;
	private String conciergeName;
	private String tel;
	private String address;
	private Integer timeCd;
	private Integer conciergeCd;
	private LocalDate reserveDate;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getTimeName() {
		return timeName;
	}
	public void setTimeName(String timeName) {
		this.timeName = timeName;
	}
	public String getConciergeName() {
		return conciergeName;
	}
	public void setConciergeName(String conciergeName) {
		this.conciergeName = conciergeName;
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
	public Integer getTimeCd() {
		return timeCd;
	}
	public void setTimeCd(Integer timeCd) {
		this.timeCd = timeCd;
	}
	public Integer getConciergeCd() {
		return conciergeCd;
	}
	public void setConciergeCd(Integer conciergeCd) {
		this.conciergeCd = conciergeCd;
	}
	public LocalDate getReserveDate() {
		return reserveDate;
	}
	public void setReserveDate(LocalDate reserveDate) {
		this.reserveDate = reserveDate;
	}
	
}
