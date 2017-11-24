package commodity;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CommodityEditServlet  extends HttpServlet{

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html; charset=UTF-8");
        //相比不能编辑的用户，此表增加删除，编辑，添加商品的信息
		List<Commodity> Commoditys = new CommodityDAO().list();
		StringBuffer sb = new StringBuffer();
		/*sb.append("<!DOCTYPE html>");
		sb.append("<script src='http://how2j.cn/study/js/jquery/2.0.0/jquery.min.js'></script>");
		sb.append("<link href='http://how2j.cn/study/css/bootstrap/3.3.6/bootstrap.min.css' rel='stylesheet'>");
		sb.append("<script src='http://how2j.cn/study/js/bootstrap/3.3.6/bootstrap.min.js'></script>");
		sb.append("<script>$(function(){    $('a').addClass('btn btn-default btn-xs');     }); </script>");*/
		sb.append("<table align='center' border='1' cellspacing='0'>\r\n");
		//sb.append("class='table table-striped table-bordered table-hover  table-condensed'");
		sb.append("<br><br><h2 align='center'>家乐福商品信息表</h2><br>");
		sb.append("<tr><td>ProductID</td><td>ProductName</td><td>InnerCName</td><td>Price/元</td>"
				+ "<td>UnitPrice</td><td>Specification/cm</td><td>Weight</td><td>DetailedInfo</td>"
				+ "<td>UpshelfDate</td><td>StockLevel</td><td>PricePromotion</td><td>edit</td><td>delete</td></tr>\r\n");

		String trFormat = "<tr><td>%d</td><td>%s</td><td>%s</td><td>%f</td><td>%s</td><td>%s</td><td>%f</td>"
				+ "<td><a href='showDetailedInfo?ProductID=%d'>商品详情</a></td><td>%s</td><td>%d</td><td>%f</td>"
				+ "<td><a href='eeditCommodity?ProductID=%d'>edit</a></td><td><a href='deleteCommodity?ProductID=%d'>delete</a></td></tr>\r\n";

		for (Commodity commodity : Commoditys) {
			String tr = String.format(trFormat, commodity.getProductID(), commodity.getProductName(),
					commodity.getInnerCName(), commodity.getPrice(), commodity.getUnitPrice(),
					commodity.getSpecification(), commodity.getWeight(),
					commodity.getProductID(), /* commodity.getDetailedInfo(), */
					commodity.getUpshelfDate(), commodity.getStockLevel(), commodity.getPricePromotion(),commodity.getProductID(),commodity.getProductID());

			sb.append(tr);
		}

		sb.append("</table>");
		sb.append("<br><br><br><br><br><br><br><hr>");
		sb.append("<h4 align='center'><a href='http://127.0.0.1/addCommodity.html'>增加商品</a></h4>");
		//String trFormat1 = "<td><a href='addCommodity?ProductID=%d'>edit</a></td>";
		//String trFormat1 = "<td><a href='http://127.0.0.1/addCommodity'>edit</a></td>";

		//href="http://127.0.0.1/listArticle"
		//sb.append("	<a href="http://127.0.0.1/nw.jsp">增加商品</a>");
//!!!怎么加超链接
		response.getWriter().write(sb.toString());

	}


	

}
