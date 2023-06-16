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


@WebServlet("/reserveInsurance")
public class ReserveInsuranceServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		List<LocalDate> reserveDateList = new ArrayList<>();
		
		int conciergeCd = 4;
		HttpSession session=request.getSession(true);
		session.setAttribute("conciergeCd", conciergeCd);
		
		Date strDate = new Date();
		LocalDate nowDate = strDate.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
		
		try {
			reserveDateList = new ReserveDAO().selectReserve(nowDate, (int)session.getAttribute("conciergeCd"));
			} catch (DaoException e) {
				e.printStackTrace();
				}
		
		session.setAttribute("ReserveDateList", reserveDateList);
		
		List<LocalDate> weekList = new ArrayList<>();
		
		for(int k=1; k<=10; k++) {
			LocalDate week = nowDate.plusDays(k);
			
			weekList.add(week);
		}
		session.setAttribute("WeekList", weekList);
		
		request.getRequestDispatcher("/WEB-INF/jsp/reserve/search.jsp").forward(request, response);
		
		return;
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
