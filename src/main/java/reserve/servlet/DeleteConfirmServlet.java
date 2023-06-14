package reserve.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import reserve.flowbean.DeleteFlowBean;
import reserve.formbean.DeleteFormBean;


@WebServlet("/deleteConfirm")
public class DeleteConfirmServlet extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("utf-8");
		HttpSession session = request.getSession(false);
		DeleteFlowBean deleteflowBean = (DeleteFlowBean) session.getAttribute("DeleteFlowBean");
		
		DeleteFormBean formBean = new DeleteFormBean();
		List<String> errMsgList = formBean.validate(request);
		
		if (!errMsgList.isEmpty()) {
			
			request.setAttribute("errMsgList", errMsgList);
			
			request.getRequestDispatcher("reserve.jsp").forward(request,response);
			return;
		}
		
		deleteflowBean.setName(formBean.getName());
		deleteflowBean.setTel(formBean.getTel());
		deleteflowBean.setAddress(formBean.getAddress());
		session.setAttribute("DeleteFlowBean", deleteflowBean);
		
		request.getRequestDispatcher("deleteComplete.jsp").forward(request, response);
		
	}
}
