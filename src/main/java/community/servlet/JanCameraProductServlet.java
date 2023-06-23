package community.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.fasterxml.jackson.databind.JsonNode;

import community.flowbean.ProductFlowBean;
import community.formbean.ReviewFormBean;
import community.json.UseJson;

@WebServlet("/janCameraProduct")
public class JanCameraProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session=request.getSession(true);
		ReviewFormBean formbean = new ReviewFormBean();
		ProductFlowBean flowbean = new ProductFlowBean();
		
		String janErr = formbean.checkJan(request);
		if(janErr!=null) {
			request.setAttribute("JanErr", janErr);
			request.getRequestDispatcher("sample.jsp").forward(request, response);
			return;
		}
		
		String jan = formbean.getJan();
		String appid = "dj00aiZpPThRZ2lYQ3JLanZuZSZzPWNvbnN1bWVyc2VjcmV0Jng9ZWY-";
		String baseurl = "https://shopping.yahooapis.jp/ShoppingWebService/V3/itemSearch";
		String urlString = baseurl + "?appid=" + appid + "&jan_code=" + jan;
		
		UseJson json = new UseJson();
		JsonNode root = null;
		root = json.getJson(urlString);
		
		JsonNode hits = root.get("hits");
		if(hits==null) {
			String prodErr = "商品情報が存在しませんでした。";
			request.setAttribute("JanErr", prodErr);
			request.getRequestDispatcher("jan-camera.jsp").forward(request, response);
			return;
		}
		JsonNode index = hits.get(5);
		
		JsonNode productName = index.get("name");
		
		JsonNode category = index.get("parentGenreCategories");
		JsonNode categoryIndex =category.get(0);
		JsonNode categoryName = categoryIndex.get("name");
		
		JsonNode pCategory = index.get("genreCategory");
		JsonNode pCategoryName = pCategory.get("name");
		
		JsonNode brand = index.get("parentBrands");
		JsonNode brandIndex = brand.get(1);
		JsonNode brandName = brandIndex.get("name");
		
		flowbean.setProductName(productName);
		flowbean.setJanCd(jan);
		flowbean.setCategoryName(categoryName);
		flowbean.setProdCategoryName(pCategoryName);
		flowbean.setBrandName(brandName);
		
		session.setAttribute("Product", flowbean);
		request.getRequestDispatcher("/WEB-INF/jsp/product/product.jsp").forward(request, response);
	}

}
