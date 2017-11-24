package commodity;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CommodityEeditServlet extends HttpServlet {

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		int ProductID = Integer.parseInt(request.getParameter("ProductID"));

		Commodity commodity = new CommodityDAO().get(ProductID);

		StringBuffer format = new StringBuffer();
		response.setContentType("text/html; charset=UTF-8");

		format.append("<!DOCTYPE html>");
		format.append("<form action='updateCommodity' method='post'>");
		format.append("<h3 align='center'>商品名称<input type='text' name='ProductName' style='height: 30px; width: 200px'  value='%s'> </h3>");
		format.append("<h3 align='center'>商品类别 <input type='text' name='InnerCName'style='height: 30px; width: 200px'  value='%s' ></h3> ");
		format.append("<h3 align='center'>单位价格 <input type='text' name='Price'  style='height: 30px; width: 200px' value='%f' > </h3>");
		format.append("<h3 align='center'>计价单位 <input type='text' name='UnitPrice' style='height: 30px; width: 200px'  value='%s' > </h3>");
		format.append("<h3 align='center'>产品规格<input type='text' name='Specification'style='height: 30px; width: 200px'  value='%s' > </h3>");
		format.append("<h3 align='center'>产品重量 <input type='text' name='Weight'style='height: 30px; width: 200px'  value='%f' > </h3>");
		format.append("<h3 align='center'>详细信息 <input type='textarea' name='DetailedInfo'  style='height: 30px; width: 200px' value='%s' ></h3> ");
		format.append("<h3 align='center'>上架时间 <input type='text' name='UpshelfDate' style='height: 30px; width: 200px'  value='%s' ></h3> ");
		format.append("<h3 align='center'>库存余量 <input type='text' name='StockLevel'  style='height: 30px; width: 200px' value='%d' > </h3>");
		format.append("<h3 align='center'>促销价格 <input type='text' name='PricePromotion'  style='height: 30px; width: 200px' value='%f' ></h3>");
		format.append("<input type='hidden' name='ProductID' value='%d'>");
		format.append("<h4 align='center'><input type='submit' style='height: 41px; width: 64px' value='更新'></h4>");
		format.append("</form>");

		
		//response.getWriter().write(String.valueOf(format));

		//System.out.println("456");
		/*
		 * String html =
		 * String.format(format.toString(),commodity.getProductName(),
		 * commodity.getInnerCName(), commodity.getPrice(),
		 * commodity.getUnitPrice(), commodity.getSpecification(),
		 * commodity.getWeight(), commodity.getDetailedInfo(),
		 * commodity.getUpshelfDate(), commodity.getStockLevel(),
		 * commodity.getPricePromotion(),commodity.getProductID());
		 */
		String html = String.format(String.valueOf(format), commodity.getProductName(),
				commodity.getInnerCName(), commodity.getPrice(), commodity.getUnitPrice(), commodity.getSpecification(),
				commodity.getWeight(), commodity.getDetailedInfo(), commodity.getUpshelfDate(),
				commodity.getStockLevel(), commodity.getPricePromotion(), commodity.getProductID());

		response.getWriter().write(html);
	}

}
