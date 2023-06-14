package reserve.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import reserve.dao.ReserveDAO;
import reserve.flowbean.SearchFlowBean;


@WebServlet("/confirm")
public class ConfirmServlet extends HttpServlet {
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		//セッションスコープに保存している内容を取得する
		HttpSession session=request.getSession(false);
		SearchFlowBean flowbean=(SearchFlowBean) session.getAttribute("SearchFlowBean");
	
		//登録処理
		int ret = new ReserveDAO().update(name,reserveDate,tel,address);
		if(ret !=0) {
		
		//sqlのやつ作る get.で
		flowbean.setName(flowbean.getName());
		flowbean.setReserveDate(flowbean.getReserveDate());
		flowbean.setTel(flowbean.getTel());
		flowbean.setAddress(flowbean.getAddress());
		session.setAttribute("SearchFlowBean", flowbean);
		
		//次画面呼び出し
			request.getRequestDispatcher("/conplete.jsp").forward(request, response);
		}

	}

}
