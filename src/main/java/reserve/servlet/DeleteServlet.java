package reserve.servlet;

import java.io.IOException;
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


@WebServlet("/delete")
public class DeleteServlet extends HttpServlet {
	
	//渡部あゆみと黒田りさ作成
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.getRequestDispatcher("/WEB-INF/jsp/delete/delete.jsp").forward(request,response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("utf-8");
		HttpSession session=request.getSession(false);
		DeleteFormBean formBean = new DeleteFormBean();
		List<String> errMsgList = formBean.validate(request);
		
		if (!errMsgList.isEmpty()) {
			request.setAttribute("errMsgList", errMsgList);
			request.getRequestDispatcher("reserve.jsp").forward(request, response);
			return;
		}
		DeleteFlowBean flowBean = new DeleteFlowBean();
		try {
			Reserve reserve = new ReserveDAO().reserve(formBean.getName(), formBean.getTel(), formBean.getAddress());
			String timeName = new ReserveDAO().time(reserve.getTimeCd());
			String conciergeName = new ReserveDAO().concierge(reserve.getConciergeCd());
			
			flowBean = new DeleteFlowBean();
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
