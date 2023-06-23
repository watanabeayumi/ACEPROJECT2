package community.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import community.flowbean.ProductFlowBean;


@WebServlet("/productReview")
public class ReviewUproad extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session=request.getSession(false);
		ProductFlowBean flowbean = (ProductFlowBean)session.getAttribute("Product");
		if(flowbean.getJanCd()!=null) {
			request.getRequestDispatcher("/WEB-INF/jsp/product/productreview.jsp").forward(request, response);
		}
		request.getRequestDispatcher("/WEB-INF/jsp/product/productreview.jsp").forward(request, response);
	}

}


