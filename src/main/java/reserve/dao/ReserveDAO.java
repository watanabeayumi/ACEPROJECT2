package reserve.dao;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;

import reserve.dto.Reserve;

public class ReserveDAO extends CommonDAO{

	private static final String SELECT_BY_RESERVE = "SELECT * FROM t_reserve WHERE reserve_date=? AND time_cd=? AND concierge_cd=?";
	
	public Reserve selectReserve(LocalDate reserveDate, int timeCd, int conciergeCd) throws DaoException {
		
		Reserve reserve = null;
		try {
			getConnection();
			PreparedStatement statement = conn.prepareStatement(SELECT_BY_RESERVE);
			statement.setDate(1, Date.valueOf(reserveDate));
			statement.setInt(2, timeCd);
			statement.setInt(3, conciergeCd);
			ResultSet resultSet = statement.executeQuery();
			
			if(resultSet.next()) {
				reserve = new Reserve();
				reserve.setReserveDate(resultSet.getDate("reserve_date").toLocalDate());
				reserve.setTimeCd(resultSet.getInt("time_cd"));
				reserve.setConciergeCd(resultSet.getInt("concierge_cd"));
				reserve.setName(resultSet.getString("name"));
				reserve.setTel(resultSet.getInt("tel"));
				reserve.setAddress(resultSet.getString("Address"));
			}
			
		}catch(SQLException e){
			throw new DaoException(e);
		}finally {
			closeConnection();
		}
		
		return reserve;
	}
	
	 
}
