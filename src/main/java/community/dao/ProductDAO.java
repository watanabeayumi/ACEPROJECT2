package community.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import community.dto.Product;
import reserve.dao.CommonDAO;
import reserve.dao.DaoException;

public class ProductDAO extends CommonDAO {
	
	private static final String SELECT_REVIEW_JAN = "SELECT * FROM p_review WHERE jan_code=?";
	
	public List<Product> selectJan(int jan_code) throws DaoException{
		
		List<Product> reviewList = new ArrayList<>();
		
		getConnection();
		try {
			PreparedStatement statement = conn.prepareStatement(SELECT_REVIEW_JAN);
			statement.setInt(1, jan_code);
			
			ResultSet resultSet = statement.executeQuery();
			while(resultSet.next()) {
				Product product = new Product();
				product.setUserName(resultSet.getString("user_name"));
				product.setProductName(resultSet.getString("product_name"));
				product.setStar(resultSet.getInt("star"));
				product.setJanCd(resultSet.getInt("jan_code"));
				product.setCategory(resultSet.getString("category"));
				product.setGenre(resultSet.getString("genre"));
				product.setBland(resultSet.getString("bland"));
				product.setReview(resultSet.getString("review"));
				reviewList.add(product);
			}
		} catch (SQLException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}
		
		return reviewList;
	}

}
