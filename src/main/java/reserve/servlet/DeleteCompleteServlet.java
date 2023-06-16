package reserve.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import reserve.dao.DaoException;
import reserve.dao.ReserveDAO;
import reserve.flowbean.DeleteFlowBean;


@WebServlet("/deleteComplete")
public class DeleteCompleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		request.removeAttribute("DeleteFlowBean");
		HttpSession session=request.getSession(false);
		DeleteFlowBean flowbean=(DeleteFlowBean) session.getAttribute("DeleteFlowBean");
		
		int ret=0;
		try {
			ret = new ReserveDAO().selectDelete(flowbean.getName(), flowbean.getTel(), flowbean.getAddress());
		} catch (DaoException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}
		if(ret !=0) {
			request.getRequestDispatcher("/WEB-INF/jsp/delete/deleteComplete.jsp").forward(request, response);
		}else {
			List<String> errMsgList = new ArrayList<>();
			errMsgList.add("削除できませんでした。");
			request.setAttribute("errMsgList", errMsgList);
			request.getRequestDispatcher("reserve.jsp").forward(request, response);
			return;
			
		}
	}
}