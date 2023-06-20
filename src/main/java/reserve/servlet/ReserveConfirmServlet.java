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
import reserve.dto.Reserve;
import reserve.flowbean.ReserveSearchFlowBean;
import reserve.formbean.ReserveSearchFormBean;


/**
 * 予約確認画面に入力値を表示させる画面です。
 * @author 中山凜香、渡辺友里
 * @version 1.0
 */
@WebServlet("/reserveConfirm")
public class ReserveConfirmServlet extends HttpServlet {
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		
		request.setCharacterEncoding("utf-8");
		
		//1.セッションスコープに保存している内容を取得する。
		HttpSession session=request.getSession(true);
		ReserveSearchFlowBean flowbean = new ReserveSearchFlowBean();
		ReserveSearchFormBean formbean = new ReserveSearchFormBean();
		
		//2.もしエラーメッセージが空でなかった場合、エラーメッセージを表示させる。
		List<String> reserveErr = formbean.checkDate(request);
		String nameErr = formbean.checkName(request);
		List<String> callErr = formbean.checkCall(request);
		String mailErr = formbean.checkMail(request);
		
		if(!reserveErr.isEmpty() || nameErr!=null || !callErr.isEmpty() || mailErr!=null){
			if(!reserveErr.isEmpty()) {
				request.setAttribute("ReserveErr", reserveErr);
			}
			if(nameErr!=null) {
				request.setAttribute("NameErr", nameErr);
			}
			if(!callErr.isEmpty()) {
				request.setAttribute("CallErr", callErr);
			}
			if(mailErr!=null) {
				request.setAttribute("MailErr", mailErr);
			}
			request.getRequestDispatcher("/WEB-INF/jsp/reserve/search.jsp").forward(request, response);
			return;
		}
		
		//3.今日以降の予約情報で名前、電話番号、メールアドレスが一致する予約情報が入っていた場合予約できないメッセージを出すページに遷移する。
		LocalDate nowDate = LocalDate.now();
		ReserveDAO dao = new ReserveDAO();
		try {
			Reserve reserve = dao.reserve(formbean.getName(), formbean.getCall(), formbean.getMail(), nowDate);
			if(reserve != null) {
				String conciergeName = dao.concierge(reserve.getConciergeCd());
				String timeName = dao.time(reserve.getTimeCd());
				
				flowbean.setName(formbean.getName());
				flowbean.setCall(formbean.getCall());
				flowbean.setMail(formbean.getMail());
				flowbean.setReserveDate(reserve.getReserveDate());
				flowbean.setConciergeName(conciergeName);
				flowbean.setTimeName(timeName);
				
				session.setAttribute("AlreadyReserve", flowbean);
				request.getRequestDispatcher("/WEB-INF/jsp/reserve/alreadyReserve.jsp").forward(request, response);
			}
		} catch (DaoException e) {
			e.printStackTrace();
		}
		
		int reserveDate = formbean.getReserveDate();
		
		//4.選択した予約カレンダーから選択した日付を特定する
		for(int i=1; i<=7; i++) {
			if(reserveDate%7==i%7) {
				flowbean.setReserveDate(nowDate.plusDays(i));
				break;
			}
		}
		
		//5.選択した予約カレンダーから選択した時間帯を特定する
		for(int i=0; i<=9; i++) {
			if(reserveDate>=(1+7*i)&&reserveDate<=(7+7*i)) {
				flowbean.setTimeCd(i+1);
				try {
					flowbean.setTimeName(dao.time(i+1));
				} catch (DaoException e) {
					e.printStackTrace();
				}
				break;
			}
		}
		
		//6.予約した値を、flowbeanのcall,mail,nameにセットする。
		flowbean.setCall(formbean.getCall());
		flowbean.setMail(formbean.getMail());
		flowbean.setName(formbean.getName());
		flowbean.setConciergeCd((int)session.getAttribute("conciergeCd"));
		session.setAttribute("ReserveSearchFlowBean", flowbean);
		
		//7.次画面呼び出しの設定。
		request.getRequestDispatcher("/WEB-INF/jsp/reserve/confirm.jsp").forward(request, response);
		}
	}