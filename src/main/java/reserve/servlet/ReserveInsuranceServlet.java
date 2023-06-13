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

import reserve.dao.DaoException;
import reserve.dao.ReserveDAO;


@WebServlet("/reserveInsurance")
public class ReserveInsuranceServlet extends HttpServlet {
	
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		List<LocalDate> reserveDateList = new ArrayList<>();
		
		Date strDate = new Date();
		LocalDate nowDate = strDate.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
		
		for(int j=1; j<=10; j++) {
			for(int i=1; i<=7; i++) {
				try {
				
					LocalDate reserveDate = new ReserveDAO().selectReserve(nowDate.plusDays(i), j, 4);
				
					reserveDateList.add(reserveDate);
				} catch (DaoException e) {
					e.printStackTrace();
				}
			}
		}
		
		request.setAttribute("ReserveDateList", reserveDateList);
		request.getRequestDispatcher("search.jsp").forward(request, response);
		
		return;
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
