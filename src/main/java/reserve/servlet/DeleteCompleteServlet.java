package reserve.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import reserve.dao.ReserveDAO;
import reserve.flowbean.DeleteFlowBean;


@WebServlet("/deleteComplete")
public class DeleteCompleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		request.removeAttribute("DeleteFlowBean");
		HttpSession session=request.getSession(false);
		DeleteFlowBean flowbean=(DeleteFlowBean) session.getAttribute("DeleteFlowBean");
		
		int ret =new ReserveDAO().selectDelete(flowbean.getName, flowbean.getCall, flowbean.getMail);
		if(ret !=0) {
			request.getRequestDispatcher("/WEB-INF/deleteComplete.jsp").forward(request, response);
		}else {
			String err = "削除できませんでした。";
			request.setAttribute("err", err);
			request.getRequestDispatcher("/WEB-INF/delete.jsp").forward(request, response);
			return;
			
		}
	}
}