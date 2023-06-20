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


/**
 * 削除完了画面を開くサーブレットです。
 * @author 黒田
 * @version 1.0
 */



@WebServlet("/deleteComplete")
public class DeleteCompleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		
		
		HttpSession session=request.getSession(false);
		//DeleteServletでセットしたkey名DeleteFlowBeanの値をDeleteFlowBeanにflowbeanって値でセット。（下でflowbean使う為。）
		DeleteFlowBean flowbean=(DeleteFlowBean) session.getAttribute("DeleteFlowBean");
		
		int ret=0;
		try {
			
	//formBeanのNameとTelとAddressをReserveDAOのselectDeleteに入れて削除。
			ret = new ReserveDAO().selectDelete(flowbean.getName(), flowbean.getTel(), flowbean.getAddress());
		} catch (DaoException e) {
			e.printStackTrace();
		}
	//retが0以外なら（削除できていたら）deleteComplete.jspに飛ばす。
		if(ret !=0) {
			request.getRequestDispatcher("/WEB-INF/jsp/delete/deleteComplete.jsp").forward(request, response);
		}else {
			List<String> errMsgList = new ArrayList<>();
			errMsgList.add("削除できませんでした。");
			request.setAttribute("errMsgList", errMsgList);
			request.getRequestDispatcher("reserve.jsp").forward(request, response);
			request.removeAttribute("DeleteFlowBean");
			return;
			
		}
	}
}