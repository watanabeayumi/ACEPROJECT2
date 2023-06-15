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
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		DeleteFormBean formBean = new DeleteFormBean();
		List<String> errMsgList = formBean.validate(request);

		if (!errMsgList.isEmpty()) {

			response.sendRedirect(request.getContextPath() + "/error");
			return;
		}

		HttpSession session = request.getSession(false);
		String Name = (String) session.getAttribute("Name");
		String Address = (String) session.getAttribute("Address");

		DeleteFlowBean flowBean = null;
		try {
			Reserve reserve = new ReserveDAO().reserve(formBean.getName(), formBean.getTel(), formBean.getAddress());
			int timeCd = reserve.getTimeCd();
			int conciergeCd = reserve.getConciergeCd();

			flowBean = new DeleteFlowBean();
			flowBean.setName(formBean.getName());
			flowBean.setTel(formBean.getTel());
			flowBean.setAddress(formBean.getAddress());
			flowBean.setReserveDate(reserve.getReserveDate());
			flowBean.setTimeCd(timeCd);
			flowBean.setConciergeCd(conciergeCd);

			String timeName = new ReserveDAO().time(timeCd);
			flowBean.setTimeName(timeName);

			String conciergeName = new ReserveDAO().concierge(conciergeCd);
			flowBean.setConciergeName(conciergeName);

		} catch (DaoException e) {

			e.printStackTrace();
			response.sendRedirect(request.getContextPath() + "/error");
			return;
		}
		session.setAttribute("DeleteFlowBean", flowBean);
		request.getRequestDispatcher("deleteConfirm.jsp").forward(request, response);
	}
}
