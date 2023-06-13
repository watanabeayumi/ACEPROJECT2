package reserve.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import reserve.formbean.SearchFormBean;


@WebServlet("/search")
public class SearchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		

		SearchFormBean formBean=new SearchFormBean();
		
		List<String> errMsg = formBean.validate(request);
		
		if(!errMsg.isEmpty()) {
			request.getRequestDispatcher("/confirm.jsp").forward(request, response);
			
		}
		
		
	}

}
