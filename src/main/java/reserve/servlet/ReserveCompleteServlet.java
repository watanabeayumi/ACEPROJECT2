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
import reserve.flowbean.ReserveSearchFlowBean;


@WebServlet("/reserveComplete")
public class ReserveCompleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session=request.getSession(false);
		ReserveSearchFlowBean flowbean=(ReserveSearchFlowBean) session.getAttribute("ReserveSearchFlowBean");
		
		int ret=0;
		try {
			ret = new ReserveDAO().selectinsert(flowbean.getReserve_date(), flowbean.getTimeCd(), (int)session.getAttribute("conciergeCd"), flowbean.getName(), flowbean.getCall(), flowbean.getMail());
		} catch (DaoException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}
		
		request.removeAttribute("ReserveSearchFlowBean");
		request.removeAttribute("conciergeCd");
		if(ret !=0) {
			request.getRequestDispatcher("complete.jsp").forward(request, response);
			
			return;
		}else {
			List<String> errMsgList = new ArrayList<>();
			errMsgList.add("登録できませんでした。");
			request.setAttribute("errMsgList", errMsgList);
			request.getRequestDispatcher("reserve.jsp").forward(request, response);
			return;
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
