package reserve.servlet;
import java.io.IOException;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;

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
		
		request.setCharacterEncoding("utf-8");
		
		//セッションスコープに保存している内容を取得する
		HttpSession session=request.getSession(false);
		ReserveSearchFlowBean flowbean = new ReserveSearchFlowBean();
		ReserveSearchFormBean formbean = new ReserveSearchFormBean();
		
		List<String> errMsgList = formbean.validate(request);
		
		if(!errMsgList.isEmpty()){
			request.setAttribute("errMsgList", errMsgList);
			request.getRequestDispatcher("reserve.jsp").forward(request, response);
			return;
		}
		
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
		
		if(reserveDate%10==1) {
			flowbean.setTimeCd(1);
			flowbean.setTimeName("10:00∼11:00");
		}else if(reserveDate%10==2) {
			flowbean.setTimeCd(2);
			flowbean.setTimeName("11:00∼12:00");
		}else if(reserveDate%10==3) {
			flowbean.setTimeCd(3);
			flowbean.setTimeName("12:00∼13:00");
		}else if(reserveDate%10==4) {
			flowbean.setTimeCd(4);
			flowbean.setTimeName("13:00∼14:00");
		}else if(reserveDate%10==5) {
			flowbean.setTimeCd(5);
			flowbean.setTimeName("14:00∼15:00");
		}else if(reserveDate%10==6) {
			flowbean.setTimeCd(6);
			flowbean.setTimeName("15:00∼16:00");
		}else if(reserveDate%10==7) {
			flowbean.setTimeCd(7);
			flowbean.setTimeName("16:00∼17:00");
		}else if(reserveDate%10==8) {
			flowbean.setTimeCd(8);
			flowbean.setTimeName("17:00∼18:00");
		}else if(reserveDate%10==9) {
			flowbean.setTimeCd(9);
			flowbean.setTimeName("18:00∼19:00");
		}else if(reserveDate%10==0) {
			flowbean.setTimeCd(10);
			flowbean.setTimeName("19:00∼20:00");
		}
		flowbean.setCall(formbean.getCall());
		flowbean.setMail(formbean.getMail());
		flowbean.setName(formbean.getName());
		session.setAttribute("ReserveSearchFlowBean", flowbean);
		
		//次画面呼び出し

			request.getRequestDispatcher("/confirm.jsp").forward(request, response);
		}

	}
