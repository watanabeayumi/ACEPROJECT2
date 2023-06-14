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
	
	public int selectinsert(LocalDate date, int time, int no, String name,  String call, String mail)
			throws DaoException{
				int insert = 0;
				try {
					getConnection();
					PreparedStatement statement=conn.prepareStatement("insert into t_reserve values(?, ?, ?, ?, ?, ?)");
					
					statement.setDate(1, Date.valueOf(date));
					statement.setInt(2, time);
					statement.setInt(3, no);
					statement.setString(4, name);
					statement.setString(5, call);
					statement.setString(6, mail);
					insert=statement.executeUpdate();
					
					
				
					
				}catch(SQLException e) {
						throw new DaoException(e);
				}finally {
						closeConnection();
				}
				return insert;
					
				}
	 
	
	
	public int selectDelete(String name,  String call, String mail)
			throws DaoException{
				int delete = 0;
				try {
					getConnection();
					PreparedStatement statement=conn.prepareStatement("delete from t_reserve where name=? and tel=? and address=?");
					
					
					
					statement.setString(1, name);
					statement.setString(2, call);
					statement.setString(3, mail);
					delete=statement.executeUpdate();
					
					
				
					
				}catch(SQLException e) {
						throw new DaoException(e);
				}finally {
						closeConnection();
				}
				return delete;
					
				}
	 
}
