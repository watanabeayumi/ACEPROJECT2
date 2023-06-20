package reserve.dao;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import reserve.dto.Reserve;

public class ReserveDAO extends CommonDAO {

	private static final String SELECT_BY_RESERVE = "SELECT * FROM t_reserve WHERE reserve_date=? AND time_cd=? AND concierge_cd=?";
	private static final String SELECT_BY_RESERVEDATA = "SELECT * FROM t_reserve WHERE name=? AND tel=? AND address=? AND reserve_date>=?";
	private static final String SELECT_BY_TIME ="SELECT * FROM t_time WHERE time_cd=?";
	private static final String SELECT_BY_CONCIRGE ="SELECT * FROM t_concierge WHERE concierge_cd=?";
	private static final String SELECT_BY_INSERT="INSERT INTO t_reserve values (?, ?, ?, ?, ?, ?)";
	private static final String SELECT_BY_DELETE="DELETE FROM t_reserve where name=? and tel=? and address=?";
	
	/**
	 * 指定した日付と時間帯で予約が入っているかを確認するためのメソッドです。
	 * @author 渡辺友里
	 * @version 1.0
	 * @param timeCd 時間帯コード
	 * @return timeName
	 * @throws DaoException
	 */
	public List<LocalDate> selectReserve(LocalDate reserveDate, int conciergeCd) throws DaoException {
		
		List<LocalDate> reserveDateList = new ArrayList<>();
		
		try {
			getConnection();
			
			//時間帯コード1∼10を繰り返す
			for(int j=1; j<=10; j++) {
				//日付を明日の日付から8日後の日付を繰り返す
				for(int i=1; i<=7; i++) {
					LocalDate reserve_date = null;
					
					PreparedStatement statement = conn.prepareStatement(SELECT_BY_RESERVE);
					statement.setDate(1, Date.valueOf(reserveDate.plusDays(i)));
					statement.setInt(2, j);
					statement.setInt(3, conciergeCd);
					
					ResultSet resultSet = statement.executeQuery();
					if (resultSet.next()) {
						//予約情報が入っていた場合予約日が入り、予約情報が無かった場合nullが入る。
						reserve_date = resultSet.getDate("reserve_date").toLocalDate();
					}
					reserveDateList.add(reserve_date);
				}
			}
		} catch (SQLException e) {
			throw new DaoException(e);
		} finally {
			closeConnection();
		}

		return reserveDateList;
	}

	/**
	 * 予約情報を挿入するためのメソッドです。
	 * @author 黒田
	 * @version 1.0
	 * @param date 予約日
	 * @param time 時間帯コード
	 * @param no コンシェルジュコード
	 * @param name 名前
	 * @param call 電話番号
	 * @param mail メールアドレス
	 * @return insert
	 * @throws DaoException
	 */
	public int selectinsert(LocalDate date, int time, int no, String name,  String call, String mail) throws DaoException{
		int insert = 0;
		try {
			getConnection();
			PreparedStatement statement=conn.prepareStatement(SELECT_BY_INSERT);
			
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
	
	/**
	 * 予約情報を削除するためのメソッドです。
	 * @author 黒田
	 * @version 1.0
	 * @param name 名前
	 * @param call 電話番号
	 * @param mail メールアドレス
	 * @return delete
	 * @throws DaoException
	 */
	public int selectDelete(String name, String call, String mail) throws DaoException {
		int delete = 0;
		try {
			getConnection();
			PreparedStatement statement = conn.prepareStatement(SELECT_BY_DELETE);
					
			statement.setString(1, name);
			statement.setString(2, call);
			statement.setString(3, mail);
			delete = statement.executeUpdate();
		} catch (SQLException e) {
			throw new DaoException(e);
		} finally {
			closeConnection();
		}
		return delete;
	}
	
	/**
	 * 名前と電話番号とメールアドレスを条件に、今日以降の予約が入ってるかどうかを確認するメソッド
	 * @author 渡辺友里
	 * @version 1.0
	 * @param name 名前
	 * @param tel 電話番号
	 * @param address メールアドレス
	 * @param reserve_date 予約日
	 * @return reserve
	 * @throws DaoException
	 */
	public Reserve reserve(String name, String tel, String address, LocalDate reserve_date) throws DaoException {
		Reserve reserve = null;
		try {
			getConnection();
			PreparedStatement statement = conn.prepareStatement(SELECT_BY_RESERVEDATA);
			statement.setString(1, name);
			statement.setString(2, tel);
			statement.setString(3, address);
			statement.setDate(4, Date.valueOf(reserve_date));
			
			ResultSet resultSet = statement.executeQuery();
			
			if (resultSet.next()) {
				reserve = new Reserve();
				reserve.setReserveDate(resultSet.getDate("reserve_date").toLocalDate());
				reserve.setConciergeCd(resultSet.getInt("concierge_cd"));
				reserve.setTimeCd(resultSet.getInt("time_cd"));
			}
		} catch (SQLException e) {
			throw new DaoException(e);
		} finally {
			closeConnection();
		}
		return reserve;
	}
	
	/**
	 * 時間帯コードから時間帯名を取得するメソッド
	 * @author 渡辺友里
	 * @version 1.0
	 * @param timeCd 時間帯コード
	 * @return timeName
	 * @throws DaoException
	 */
	public String time(int timeCd) throws DaoException{
		String timeName = null;
		
		try {
			getConnection();
			PreparedStatement statement = conn.prepareStatement(SELECT_BY_TIME);
			statement.setInt(1, timeCd);

			ResultSet resultSet = statement.executeQuery();

			if (resultSet.next()) {
				timeName = resultSet.getString("time_name");
			}

		} catch (SQLException e) {
			throw new DaoException(e);
		} finally {
			closeConnection();
		}
		
		return timeName;
	}
	/**
	 * コンシェルジュコードからコンシェルジュ名を取得するメソッド
	 * @author 渡辺友里
	 * @param conciergeCd コンシェルジュコード
	 * @return conciergeName
	 * @throws DaoException
	 */
	public String concierge(int conciergeCd) throws DaoException{
		String conciergeName = null;
		
		try {
			getConnection();
			PreparedStatement statement = conn.prepareStatement(SELECT_BY_CONCIRGE);
			statement.setInt(1, conciergeCd);

			ResultSet resultSet = statement.executeQuery();

			if (resultSet.next()) {
				conciergeName = resultSet.getString("concierge_name");
			}

		} catch (SQLException e) {
			throw new DaoException(e);
		} finally {
			closeConnection();
		}
		
		return conciergeName;
	}

}
