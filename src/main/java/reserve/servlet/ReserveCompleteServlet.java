package reserve.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import reserve.dao.DaoException;
import reserve.dao.ReserveDAO;
import reserve.flowbean.ReserveCalendarFlowBean;


@WebServlet("/reserveComplete")
public class ReserveCompleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.getWriter().append("Served at: ").append(request.getContextPath());
		
		request.removeAttribute("SearchFlowBean");
		HttpSession session=request.getSession(false);
		ReserveCalendarFlowBean flowbean=(ReserveCalendarFlowBean) session.getAttribute("SearchFlowBean");
		
		int ret=0;
		try {
			ret = new ReserveDAO().selectinsert(flowbean.getReserveDate(), flowbean.getTimeCd(), flowbean.getConciergeCd(), flowbean.getName(), flowbean.getTel(), flowbean.getAddress());
		} catch (DaoException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}
		if(ret !=0) {
			request.getRequestDispatcher("/WEB-INF/complete.jsp").forward(request, response);
		}else {
			String err = "登録できませんでした。";
			request.setAttribute("err", err);
			request.getRequestDispatcher("/WEB-INF/search.jsp").forward(request, response);
			return;
		}	
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
