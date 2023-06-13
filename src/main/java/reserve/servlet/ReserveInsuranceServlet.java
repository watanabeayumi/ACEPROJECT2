package reserve.servlet;

import java.io.IOException;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import reserve.dao.DaoException;
import reserve.dao.ReserveDAO;
import reserve.dto.Reserve;
import reserve.flowbean.ReserveCalendarFlowBean;


@WebServlet("/reserveInsurance")
public class ReserveInsuranceServlet extends HttpServlet {
	
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		Date strDate = new Date();
		LocalDate nowDate = strDate.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
		
		for(int i=1; i<=7; i++) {
			try {
				Reserve reserve = null;
				reserve = new ReserveDAO().selectReserve(nowDate.plusDays(i), 1, 4);
				
				ReserveCalendarFlowBean flowbean = new ReserveCalendarFlowBean();
				flowbean.setReserveDate(reserve.getReserveDate());
				
				session.setAttribute("Day"+i+"-1", flowbean);
				
			} catch (DaoException e) {
				e.printStackTrace();
			}
		}
		
		request.getRequestDispatcher("search.jsp").forward(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
