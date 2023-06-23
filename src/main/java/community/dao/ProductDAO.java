package community.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import reserve.dao.CommonDAO;
import reserve.dao.DaoException;

public class ProductDAO extends CommonDAO {
	
	private static final String SELECT_REVIEW_JAN = "SELECT * FROM p_review WHERE jan_code=?";
	
	public List<String> selectJan(int jan_code) throws DaoException{
		
		List<String> reviewList = new ArrayList<>();
		
		getConnection();
		try {
			PreparedStatement statement = conn.prepareStatement(SELECT_REVIEW_JAN);
			statement.setInt(1, jan_code);
			
			ResultSet resultSet = statement.executeQuery();
			while(resultSet.next()) {
				
			}
		} catch (SQLException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}
		
		return reviewList;
	}

}
