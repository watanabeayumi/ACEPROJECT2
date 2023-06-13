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
		
		try {
			Reserve reserve = null;
			reserve = new ReserveDAO().selectReserve(nowDate.plusDays(1), 1, 4);
			
			ReserveCalendarFlowBean flowbean = new ReserveCalendarFlowBean();
			flowbean.setReserveDate(reserve.getReserveDate());
			
			session.setAttribute("Day1-1", flowbean);
			
		} catch (DaoException e) {
			e.printStackTrace();
		}
		
		try {
			Reserve reserve = null;
			reserve = new ReserveDAO().selectReserve(nowDate.plusDays(2), 1, 4);
			
			ReserveCalendarFlowBean flowbean = new ReserveCalendarFlowBean();
			flowbean.setReserveDate(reserve.getReserveDate());
			
			session.setAttribute("Day2-1", flowbean);
			
		} catch (DaoException e) {
			e.printStackTrace();
		}
		
		try {
			Reserve reserve = null;
			reserve = new ReserveDAO().selectReserve(nowDate.plusDays(3), 1, 4);
			
			ReserveCalendarFlowBean flowbean = new ReserveCalendarFlowBean();
			flowbean.setReserveDate(reserve.getReserveDate());
			
			session.setAttribute("Day3-1", flowbean);
			
		} catch (DaoException e) {
			e.printStackTrace();
		}
		
		try {
			Reserve reserve = null;
			reserve = new ReserveDAO().selectReserve(nowDate.plusDays(4), 1, 4);
			
			ReserveCalendarFlowBean flowbean = new ReserveCalendarFlowBean();
			flowbean.setReserveDate(reserve.getReserveDate());
			
			session.setAttribute("Day4-1", flowbean);
			
		} catch (DaoException e) {
			e.printStackTrace();
		}
		
		try {
			Reserve reserve = null;
			reserve = new ReserveDAO().selectReserve(nowDate.plusDays(5), 1, 4);
			
			ReserveCalendarFlowBean flowbean = new ReserveCalendarFlowBean();
			flowbean.setReserveDate(reserve.getReserveDate());
			
			session.setAttribute("Day5-1", flowbean);
			
		} catch (DaoException e) {
			e.printStackTrace();
		}
		
		try {
			Reserve reserve = null;
			reserve = new ReserveDAO().selectReserve(nowDate.plusDays(6), 1, 4);
			
			ReserveCalendarFlowBean flowbean = new ReserveCalendarFlowBean();
			flowbean.setReserveDate(reserve.getReserveDate());
			
			session.setAttribute("Day6-1", flowbean);
			
		} catch (DaoException e) {
			e.printStackTrace();
		}
		
		try {
			Reserve reserve = null;
			reserve = new ReserveDAO().selectReserve(nowDate.plusDays(7), 1, 4);
			
			ReserveCalendarFlowBean flowbean = new ReserveCalendarFlowBean();
			flowbean.setReserveDate(reserve.getReserveDate());
			
			session.setAttribute("Day7-1", flowbean);
			
		} catch (DaoException e) {
			e.printStackTrace();
		}
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
