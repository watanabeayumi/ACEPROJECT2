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
<<<<<<< HEAD
			String url = "jdbc:postgresql://infini2.azurewebsites.net:5432/groupproject0707-database";
=======
			String url = "jdbc:postgresql://groupproject0707-server.postgres.database.azure.com:5432/groupproject0707-database";
>>>>>>> branch 'master' of https://github.com/watanabeayumi/ACEPROJECT2.git
			conn = DriverManager.getConnection(url, "mtcdpkkkak", "tebasaki1234!");

		} catch (ClassNotFoundException e) {
			throw new DaoException(e);
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DaoException(e);
		}
	}
} 
