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

import reserve.flowbean.ReserveSearchFlowBean;
import reserve.formbean.ReserveSearchFormBean;


@WebServlet("/reserveConfirm")
public class ReserveConfirmServlet extends HttpServlet {
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		//セッションスコープに保存している内容を取得する
		HttpSession session=request.getSession(false);
		ReserveSearchFlowBean flowbean = new ReserveSearchFlowBean();
		ReserveSearchFormBean formbean = new ReserveSearchFormBean();
		
		Date strDate = new Date();
		LocalDate nowDate = strDate.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
		
		int reserveDate = formbean.getReserveDate();
		
		if(reserveDate>=1 && reserveDate<=10) {
			flowbean.setReserve_date(nowDate.plusDays(1));
		}else if(reserveDate>=11 && reserveDate<=20) {
			flowbean.setReserve_date(nowDate.plusDays(2));
		}else if(reserveDate>=21 && reserveDate<=30) {
			flowbean.setReserve_date(nowDate.plusDays(3));
		}else if(reserveDate>=31 && reserveDate<=40) {
			flowbean.setReserve_date(nowDate.plusDays(4));
		}else if(reserveDate>=41 && reserveDate<=50) {
			flowbean.setReserve_date(nowDate.plusDays(5));
		}else if(reserveDate>=51 && reserveDate<=60) {
			flowbean.setReserve_date(nowDate.plusDays(6));
		}else if(reserveDate>=61 && reserveDate<=70) {
			flowbean.setReserve_date(nowDate.plusDays(7));
		}
		flowbean.setCall(formbean.getCall());
		flowbean.setMail(formbean.getMail());
		session.setAttribute("SearchFlowBean", flowbean);
		
		//次画面呼び出し

			request.getRequestDispatcher("/confirm.jsp").forward(request, response);
		}

	}
