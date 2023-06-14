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
import reserve.flowbean.DeleteFlowBean;
import reserve.formbean.DeleteFormBean;


@WebServlet("/delete")
public class DeleteServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		DeleteFormBean formBean = new DeleteFormBean();
		List<String> errMsgList = formBean.validate(request);
		
		if (!errMsgList.isEmpty()) {
			
			response.sendRedirect(request.getContextPath()+"/error");
			return;
		}
		
		HttpSession session = request.getSession(false);
		String Name = (String) session.getAttribute("Name");
		String Address = (String) session.getAttribute("Address");
		
		DeleteFlowBean flowBean = null;
		try { 
			ReserveDAO reserveDAO = new ReserveDAO();
			flowBean = new DeleteFlowBean();
			flowBean.setName(formBean.getName());
			flowBean.setTel(formBean.getTel());
			flowBean.setAddress(formBean.getAddress());
			
			
		} catch (DaoException e) {

			e.printStackTrace();
			response.sendRedirect(request.getContextPath() + "/error");
			return;
		}
		
	
		request.setAttribute("DeleteFlowBean",flowBean);
		request.getRequestDispatcher("deleteConfirm.jsp").forward(request,response);
		
	

}
	}
