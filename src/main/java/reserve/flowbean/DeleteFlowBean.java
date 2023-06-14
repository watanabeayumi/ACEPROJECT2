package reserve.flowbean;

import java.time.LocalDate;

public class DeleteFlowBean {
	
	private String Name;
	private String Tel;
	private String Address;
	private LocalDate reserveDate;
	private String conciergeName;
	private String timeName;
	
	public LocalDate getReserveDate() {
		return reserveDate;
	}
	public void setReserveDate(LocalDate reserveDate) {
		this.reserveDate = reserveDate;
	}
	public String getConciergeName() {
		return conciergeName;
	}
	public void setConciergeName(String conciergeName) {
		this.conciergeName = conciergeName;
	}
	public String getTimeName() {
		return timeName;
	}
	public void setTimeName(String timeName) {
		this.timeName = timeName;
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
