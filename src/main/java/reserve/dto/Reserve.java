package reserve.dto;

import java.time.LocalDate;

public class Reserve {
	private String Name;
	private String TimeName;
	private String ConciergeName;
	private Integer Tel;
	private Integer Address;
	private Integer TimeCd;
	private Integer ConciergeCd;
	private LocalDate ReserveDate;
	
	
	
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public String getTimeName() {
		return TimeName;
	}
	public void setTimeName(String timeName) {
		TimeName = timeName;
	}
	public Integer getTel() {
		return Tel;
	}
	public void setTel(Integer tel) {
		Tel = tel;
	}
	public Integer getAddress() {
		return Address;
	}
	public void setAddress(Integer address) {
		Address = address;
	}
	public Integer getTimeCd() {
		return TimeCd;
	}
	public void setTimeCd(Integer timeCd) {
		TimeCd = timeCd;
	}
	public LocalDate getReserveDate() {
		return ReserveDate;
	}
	public void setReserveDate(LocalDate reserveDate) {
		ReserveDate = reserveDate;
	   
	}
	public String getConciergeName() {
		return ConciergeName;
	}
	public void setConciergeName(String conciergeName) {
		ConciergeName = conciergeName;
	}
	public Integer getConciergeCd() {
		return ConciergeCd;
	}
	public void setConciergeCd(Integer conciergeCd) {
		ConciergeCd = conciergeCd;
	}
	
	
	
}
