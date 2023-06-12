package reserve.dao;
public class DaoException extends Exception {

	private static final long serialVersionUID = 1L;
	
	public DaoException(Exception e) {
		System.out.println("------データベースエラーが発生しました。------");
		e.printStackTrace();
	}
}
