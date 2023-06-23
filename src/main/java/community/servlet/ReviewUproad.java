package community.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import community.dao.ProductDAO;
import community.dto.Product;
import community.flowbean.ProductFlowBean;
import reserve.dao.DaoException;


@WebServlet("/productReview")
public class ReviewUproad extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("utf-8");
		
		HttpSession session=request.getSession(false);
		ProductFlowBean flowbean = (ProductFlowBean)session.getAttribute("Product");
		String janCd = flowbean.getJanCd();
		if(janCd!=null) {
			int jan_code = Integer.parseInt(janCd);
			try {
				List<Product> reviewList = new ProductDAO().selectJan(jan_code);
				
				request.setAttribute("ReviewList", reviewList);
				request.getRequestDispatcher("/WEB-INF/jsp/product/productreview.jsp").forward(request, response);
			} catch (DaoException e) {
				// TODO 自動生成された catch ブロック
				e.printStackTrace();
			}
		}
		request.getRequestDispatcher("/WEB-INF/jsp/product/productreview.jsp").forward(request, response);
	}

}


