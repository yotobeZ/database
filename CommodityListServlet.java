package commodity;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import blogs.Article;
import blogs.ArticleDAO;

public class CommodityListServlet extends HttpServlet {

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html; charset=UTF-8");
		// 为了分页
		int start = 0;
		int count = 3;
		try {
			start = Integer.parseInt(request.getParameter("start"));
		} catch (NumberFormatException e) {
			// 当浏览器没有传参数start时
		}

		int next = start + count;
		int pre = start - count;
		// 为了分页
		int total = new CommodityDAO().getTotal();
		
		int last;
		// 假设总数是50，是能够被5整除的，那么最后一页的开始就是45
		if (0 == total % count)
		last = total - count;
		// 假设总数是51，不能够被5整除的，那么最后一页的开始就是50
		else
		last = total - total % count;
		//为分页
		pre = pre < 0 ? 0 : pre;
		next = next > last ? last : next;
		request.setAttribute("next", next);
		request.setAttribute("pre", pre);
		request.setAttribute("last", last);
		
		List<Commodity> Commoditys = new CommodityDAO().list(start,count);
		request.setAttribute("Commoditys", Commoditys);
		request.getRequestDispatcher("listCommodity.jsp").forward(request, response);
		//为分页
		/*
		 * int start = 0; int count = 3; List<Commodity> Commoditys = new
		 * CommodityDAO().list(start, count); request.setAttribute("Commoditys",
		 * Commoditys);
		 * request.getRequestDispatcher("listCommodity.jsp").forward(request,
		 * response);
		 */
	/*！！！可用部分	StringBuffer sb = new StringBuffer();
		sb.append("<table align='center' border='1' cellspacing='0'>\r\n");
		sb.append("<br><br><h2 align='center'>家乐福商品信息表</h2><br>");
		sb.append("<tr><td>ProductID</td><td>ProductName</td><td>InnerCName</td><td>Price/元</td>"
				+ "<td>UnitPrice</td><td>Specification/cm</td><td>Weight</td><td>DetailedInfo</td>"
				+ "<td>UpshelfDate</td><td>StockLevel</td><td>PricePromotion</td></tr>\r\n");

		String trFormat = "<tr><td>%d</td><td>%s</td><td>%s</td><td>%f</td><td>%s</td><td>%s</td><td>%f</td>"
				+ "<td><a href='showDetailedInfo?ProductID=%d'>商品详情</a></td><td>%s</td><td>%d</td><td>%f</td>\r\n";

		for (Commodity commodity : Commoditys) {
			String tr = String.format(trFormat, commodity.getProductID(), commodity.getProductName(),
					commodity.getInnerCName(), commodity.getPrice(), commodity.getUnitPrice(),
					commodity.getSpecification(), commodity.getWeight(), commodity.getProductID(),
					commodity.getUpshelfDate(), commodity.getStockLevel(), commodity.getPricePromotion());

			sb.append(tr);
		}

		sb.append("</table>");

		response.getWriter().write(sb.toString());
可用部分！！！*/
	}

}
