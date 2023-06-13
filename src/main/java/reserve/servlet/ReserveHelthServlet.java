package reserve.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/reserveHelth")
public class ReserveHelthServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		

		//ReseaveDAOから明日の予約情報を持ってくる
		
		
		//flowbeanに入れて、次のページに持ってくる
		
		
		//ReseaveDAOから明後日の予約情報を持ってくる
		
		//flowbeanに入れて、次のページに持ってくる
		
		
		//ReseaveDAOから明々後日の予約情報を持ってくる
		
		//flowbeanに入れて、次のページに持ってくる
		
		//これを一週間分
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
