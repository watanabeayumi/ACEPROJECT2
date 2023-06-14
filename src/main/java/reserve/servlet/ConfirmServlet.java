package reserve.servlet;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import reserve.flowbean.SearchFlowBean;
import reserve.formbean.SearchFormBean;


@WebServlet("/confirm")
public class ConfirmServlet extends HttpServlet {
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		//セッションスコープに保存している内容を取得する
		HttpSession session=request.getSession(false);
		SearchFlowBean flowbean=(SearchFlowBean) session.getAttribute("conciergeCd");
		SearchFormBean formbean = new SearchFormBean();
		//sqlのやつ作る get.で
		flowbean.setName(formbean.getName());
		flowbean.setReserve_date(formbean.getReserve_date());
		flowbean.setCall(formbean.getCall());
		flowbean.setMail(formbean.getMail());
		session.setAttribute("SearchFlowBean", flowbean);
		
		//次画面呼び出し

			request.getRequestDispatcher("/complete.jsp").forward(request, response);

		
			request.getRequestDispatcher("/conplete.jsp").forward(request, response);

		}

	}
