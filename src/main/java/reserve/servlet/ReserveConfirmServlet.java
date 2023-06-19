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
	
	
	/**
	 * 【予約確認画面に入力値を表示させる画面です。】
	 * @author 【中山凜香、渡辺友里】
	 * @version 1.0
	 */
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		request.setCharacterEncoding("utf-8");
		
		//1.セッションスコープに保存している内容を取得する。
		HttpSession session=request.getSession(false);
		ReserveSearchFlowBean flowbean = new ReserveSearchFlowBean();
		ReserveSearchFormBean formbean = new ReserveSearchFormBean();
		
		//2.もしエラーメッセージが空でなかった場合、エラーメッセージを表示させる。
		List<String> errMsgList = formbean.validate(request);
		
		if(!errMsgList.isEmpty()){
			request.setAttribute("errMsgList", errMsgList);
			request.getRequestDispatcher("/WEB-INF/jsp/reserve/search.jsp").forward(request, response);
			return;
		}
		
		//3.７日分の予約可能日を表示させる設定。
		Date strDate = new Date();
		LocalDate nowDate = strDate.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
		
		int reserveDate = formbean.getReserveDate();
		
		if(reserveDate%7==1) {
			flowbean.setReserve_date(nowDate.plusDays(1));
		}else if(reserveDate%7==2) {
			flowbean.setReserve_date(nowDate.plusDays(2));
		}else if(reserveDate%7==3) {
			flowbean.setReserve_date(nowDate.plusDays(3));
		}else if(reserveDate%7==4) {
			flowbean.setReserve_date(nowDate.plusDays(4));
		}else if(reserveDate%7==5) {
			flowbean.setReserve_date(nowDate.plusDays(5));
		}else if(reserveDate%7==6) {
			flowbean.setReserve_date(nowDate.plusDays(6));
		}else if(reserveDate%7==0) {
			flowbean.setReserve_date(nowDate.plusDays(7));
		}
		
		//4.予約時間の表示設定。
		if(reserveDate>=1&&reserveDate<=7) {
			flowbean.setTimeCd(1);
			flowbean.setTimeName("10:00∼11:00");
		}else if(reserveDate>=8&&reserveDate<=14) {
			flowbean.setTimeCd(2);
			flowbean.setTimeName("11:00∼12:00");
		}else if(reserveDate>=15&&reserveDate<=21) {
			flowbean.setTimeCd(3);
			flowbean.setTimeName("12:00∼13:00");
		}else if(reserveDate>=22&&reserveDate<=28) {
			flowbean.setTimeCd(4);
			flowbean.setTimeName("13:00∼14:00");
		}else if(reserveDate>=29&&reserveDate<=35) {
			flowbean.setTimeCd(5);
			flowbean.setTimeName("14:00∼15:00");
		}else if(reserveDate>=36&&reserveDate<=42) {
			flowbean.setTimeCd(6);
			flowbean.setTimeName("15:00∼16:00");
		}else if(reserveDate>=43&&reserveDate<=49) {
			flowbean.setTimeCd(7);
			flowbean.setTimeName("16:00∼17:00");
		}else if(reserveDate>=50&&reserveDate<=56) {
			flowbean.setTimeCd(8);
			flowbean.setTimeName("17:00∼18:00");
		}else if(reserveDate>=57&&reserveDate<=63) {
			flowbean.setTimeCd(9);
			flowbean.setTimeName("18:00∼19:00");
		}else if(reserveDate>=64&&reserveDate<=70) {
			flowbean.setTimeCd(10);
			flowbean.setTimeName("19:00∼20:00");
		}
		
		//5.予約した値を、flowbeanのcall,mail,nameにセットする。
		flowbean.setCall(formbean.getCall());
		flowbean.setMail(formbean.getMail());
		flowbean.setName(formbean.getName());
		session.setAttribute("ReserveSearchFlowBean", flowbean);
		
		//6.次画面呼び出しの設定。
			request.getRequestDispatcher("/WEB-INF/jsp/reserve/confirm.jsp").forward(request, response);
		}

	}
