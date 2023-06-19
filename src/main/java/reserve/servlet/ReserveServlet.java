package reserve.servlet;

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import reserve.dao.DaoException;
import reserve.dao.ReserveDAO;
import reserve.flowbean.ReserveSearchFlowBean;

/**
 * 予約可能日時カレンダーと入力内容を開くためのサーブレットです
 * @author 渡辺友里
 * @version 1.0
 */
@WebServlet("/reserve")
public class ReserveServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//1.コンシェルジュコードをセッションに入れる
		HttpSession session=request.getSession(true);
		ReserveSearchFlowBean flowbean = new ReserveSearchFlowBean();
		String concierge_cd=request.getParameter("conciergeCd");
		int conciergeCd=Integer.parseInt(concierge_cd);
		session.setAttribute("conciergeCd",conciergeCd);
		
		//2.コンシェルジュコードから相談内容名を取得する
		try {
			String conciergeName = new ReserveDAO().concierge(conciergeCd);
			session.setAttribute("conciergeName",conciergeName);
		} catch (DaoException e) {
			e.printStackTrace();
		}
		
		//3.今日の日付を取得し、LocalDateに変換
		LocalDate nowDate = LocalDate.now();
		
		//4.予約可能カレンダーを出力するための処理
		List<LocalDate> reserveDateList = new ArrayList<>();
		try {
			reserveDateList = new ReserveDAO().selectReserve(nowDate, conciergeCd);
			} catch (DaoException e) {
				e.printStackTrace();
				}
		session.setAttribute("ReserveDateList", reserveDateList);
		
		//5.予約可能カレンダーの上の明日以降の一週間を表示させるための処理
		List<LocalDate> weekList = new ArrayList<>();
		for(int k=1; k<=10; k++) {
			LocalDate week = nowDate.plusDays(k);
			weekList.add(week);
		}
		session.setAttribute("WeekList", weekList);
		
		//6.search.jspに遷移
		request.getRequestDispatcher("/WEB-INF/jsp/reserve/search.jsp").forward(request, response);
		
		return;
		}
	}
