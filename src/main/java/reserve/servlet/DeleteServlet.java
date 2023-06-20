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
import reserve.flowbean.DeleteFlowBean;
import reserve.formbean.DeleteFormBean;

/**
 * 削除確認画面を開くサーブレットです。
 * @author  渡邊あ、渡部ゆ、黒田
 * @version 1.0
 */

@WebServlet("/delete")
public class DeleteServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.getRequestDispatcher("/WEB-INF/jsp/delete/delete.jsp").forward(request,response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		request.setCharacterEncoding("utf-8");
		
	//新たなセッション発行しない。
		HttpSession session=request.getSession(false);
		DeleteFormBean formBean = new DeleteFormBean();
		
	//formBeanのvalidateの情報もらってerrMsgListに入れる。？なんでリターンの名前使わない？
		List<String> errMsgList = formBean.validate(request);
		
	//もしエラーメッセージリストの中身が入っていたらerrMsgListというキー名で値をセット。reserve.jspに飛ばす。
		if (!errMsgList.isEmpty()) {
			request.setAttribute("errMsgList", errMsgList);
			request.getRequestDispatcher("reserve.jsp").forward(request, response);
			return;
		}
		DeleteFlowBean flowBean = new DeleteFlowBean();
		
	//formBeanのNameとTelとAddressをReserveDAOのreserveに入れ、その抽出結果を名前reserveに格納。
		LocalDate nowDate = LocalDate.now();
		try {
			ReserveDAO dao = new ReserveDAO();
			Reserve reserve = dao.reserve(formBean.getName(), formBean.getTel(), formBean.getAddress(), nowDate);
		
	//上記で抽出されたTimeCdをReserveDAOのtimeに入れてtimeNameを抽出。
			String timeName = dao.time(reserve.getTimeCd());
			String conciergeName = dao.concierge(reserve.getConciergeCd());
			
			
			flowBean = new DeleteFlowBean();
			
	//formBeanの値や上で抽出した値をflowBeanにセット。（確認画面のjspで出力する時に使う。）
			flowBean.setName(formBean.getName());
			flowBean.setTel(formBean.getTel());
			flowBean.setAddress(formBean.getAddress());
			flowBean.setReserveDate(reserve.getReserveDate());
			flowBean.setTimeCd(reserve.getTimeCd());
			flowBean.setConciergeCd(reserve.getConciergeCd());
			flowBean.setTimeName(timeName);
			flowBean.setConciergeName(conciergeName);
		} catch (DaoException e) {
			e.printStackTrace();
			errMsgList.add("入力された内容の予約情報は存在しませんでした。");
			request.setAttribute("errMsgList", errMsgList);
			request.getRequestDispatcher("reserve.jsp").forward(request, response);
			return;
		}
		session.setAttribute("DeleteFlowBean",flowBean);
		request.getRequestDispatcher("/WEB-INF/jsp/delete/deleteConfirm.jsp").forward(request,response);
}
	}

