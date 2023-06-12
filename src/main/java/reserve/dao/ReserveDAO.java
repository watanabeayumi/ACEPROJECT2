package reserve.dao;

import java.time.LocalDate;

import reserve.dto.Reserve;

public class ReserveDAO extends CommonDAO{

	private static final String SELECT_BY_RESEARVE = "SELECT * FROM t_reserve WHERE reserve_date = ? AND time_cd = ?";
	
	public Reserve selectReserve(LocalDate reserve_date, int time_cd) throws DaoException {
		
		Reserve reserve = null;
		
		
		return reserve;
	}
}
