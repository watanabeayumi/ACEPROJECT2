package reserve.servlet;
import java.io.IOException;
import java.time.LocalDate;
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
			request.getRequestDispatcher("/WEB-INF/jsp/reserve/search.jsp").forward(request, response);
			return;
		}
		
		//3.７日分の予約可能日を表示させる設定。
		LocalDate nowDate = now();
		
		int reserveDate = formbean.getReserveDate();
		
		for(int i=0; i<=6; i++) {
			if(i==0) {
				if(reserveDate%7==0) {
					flowbean.setReserveDate(nowDate.plusDays(7));
					break;
				}
			}else {
				if(reserveDate%7==i) {
					flowbean.setReserveDate(nowDate.plusDays(i));
					break;
				}
			}
		}
		
		//4.予約時間の表示設定。
		for(int i=0; i<=9; i++) {
			if(reserveDate>=(1+7*i)&&reserveDate<=(7+7*i)) {
				flowbean.setTimeCd(i+1);
				try {
					flowbean.setTimeName(new ReserveDAO().time(i+1));
				} catch (DaoException e) {
					e.printStackTrace();
				}
				break;
			}
		}
		
		//5.予約した値を、flowbeanのcall,mail,nameにセットする。
		flowbean.setCall(formbean.getCall());
		flowbean.setMail(formbean.getMail());
		flowbean.setName(formbean.getName());
		session.setAttribute("ReserveSearchFlowBean", flowbean);
		
		//6.次画面呼び出しの設定。
			request.getRequestDispatcher("/WEB-INF/jsp/reserve/confirm.jsp").forward(request, response);
		}

	private LocalDate now() {
		// TODO 自動生成されたメソッド・スタブ
		return null;
	}
	}