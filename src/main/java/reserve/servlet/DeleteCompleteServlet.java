package reserve.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.ResourceBundle;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import reserve.dao.DaoException;
import reserve.dao.ReserveDAO;
import reserve.dto.Reserve;


@WebServlet("/deleteComplete")
public class DeleteCompleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		request.removeAttribute("ReserveSearchFlowBean");
		HttpSession session=request.getSession(false);
		DeleteFlowBean flowbean=(DeleteFlowBean) session.getAttribute("DeleteFlowBean");
		
		
		try {
			Reserve reserve=null;
			//ReserveDAOのselectReserveDateByKeyを使って、入力されたReserveDateとTimeCdと1で絞り込んだ部分をreserveに格納
			reserve=new ReserveDAO().selectReserve(flowbean.getName(), flowbean.getCall(), flowbean.getMail());
		
			if(reserve!=null) {
				ArrayList<String> errMsgList = new ArrayList<String>();
				errMsgList.add(ResourceBundle.getBundle("message").getString("SEARCH_ERR_EXIST_RESERVE"));
				request.setAttribute("errMsgList", errMsgList);
		request.getRequestDispatcher("/WEB-INF/jsp/reserve/reserve-regist-input.jsp").forward(request, response);
		
				
			}
			new ReserveDAO().selectInsertReserve(flowbean.getReserveDate(), flowbean.getTimeCd(),flowbean.getRoomCd(), flowbean.getEmpNo(), flowbean.getTel(), flowbean.getContents());
			request.getRequestDispatcher("/WEB-INF/jsp/reserve/reserve-regist-complete.jsp").forward(request, response);
			
		} catch (DaoException e) {
			
			e.printStackTrace();
			response.sendRedirect(request.getContextPath() + "/error");
			return;
		}
	}

}
