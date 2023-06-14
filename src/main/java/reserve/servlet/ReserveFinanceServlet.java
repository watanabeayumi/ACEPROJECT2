package reserve.servlet;

import java.io.IOException;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import reserve.dao.DaoException;
import reserve.dao.ReserveDAO;

@WebServlet("/reserveFinance")
public class ReserveFinanceServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		List<LocalDate> reserveDateList = new ArrayList<>();
		
		int conciergeCd = 5;
		HttpSession session=request.getSession(true);
		session.setAttribute("conciergeCd", conciergeCd);
		
		Date strDate = new Date();
		LocalDate nowDate = strDate.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
		
		for(int j=1; j<=10; j++) {
			for(int i=1; i<=7; i++) {
				try {
				
					LocalDate reserveDate = new ReserveDAO().selectReserve(nowDate.plusDays(i), j, (int)session.getAttribute("conciergeCd"));
				
					reserveDateList.add(reserveDate);
				} catch (DaoException e) {
					e.printStackTrace();
				}
			}
		}
		
		request.setAttribute("ReserveDateList", reserveDateList);
		
		List<LocalDate> weekList = new ArrayList<>();
		
		for(int k=1; k<=10; k++) {
			LocalDate week = nowDate.plusDays(k);
			
			weekList.add(week);
		}
		
		request.setAttribute("WeekList", weekList);
		
		request.getRequestDispatcher("search.jsp").forward(request, response);
		
		return;
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}