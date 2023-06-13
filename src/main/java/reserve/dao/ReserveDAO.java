package reserve.dao;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;

public class ReserveDAO extends CommonDAO{

	private static final String SELECT_BY_RESERVE = "SELECT * FROM t_reserve WHERE reserve_date=? AND time_cd=? AND concierge_cd=?";
	
	public LocalDate selectReserve(LocalDate reserveDate, int timeCd, int conciergeCd) throws DaoException {
		
		LocalDate reserve_date = null;
		try {
			getConnection();
			PreparedStatement statement = conn.prepareStatement(SELECT_BY_RESERVE);
			statement.setDate(1, Date.valueOf(reserveDate));
			statement.setInt(2, timeCd);
			statement.setInt(3, conciergeCd);
			
			ResultSet resultSet = statement.executeQuery();
			
			if(resultSet.next()) {
				reserve_date = resultSet.getDate("reserve_date").toLocalDate();
			}
			
		}catch(SQLException e){
			throw new DaoException(e);
		}finally {
			closeConnection();
		}
		
		return reserve_date;
	}
	
	 
}
