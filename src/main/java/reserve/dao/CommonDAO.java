package reserve.dao;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class CommonDAO {

	protected Connection conn;

	/**
	 * データベースをクローズする。
	 * @throws DaoException
	 */
	protected void closeConnection() throws DaoException {
		try {
			if (conn != null) {
				conn.close();
			}
		} catch (SQLException e) {
			throw new DaoException(e);
		}
	}

	/**
	 * データベースコネクションを取得する。
	 * @throws DaoException
	 */
	protected void getConnection() throws DaoException {

		try {
			Class.forName("org.postgresql.Driver");
			String url = "jdbc:postgresql://localhost:5432/groupproject";
			conn = DriverManager.getConnection(url, "postgres", "postgres");

		} catch (ClassNotFoundException e) {
			throw new DaoException(e);
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DaoException(e);
		}
	}
}
