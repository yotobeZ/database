package commodity;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class DetailedInfoServlet extends HttpServlet {
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int ProductID = Integer.parseInt(request.getParameter("ProductID"));
		Commodity commodity = new CommodityDAO().get(ProductID);
		response.setContentType("text/html; charset=UTF-8");

		//List<Commodity> Commoditys = new CommodityDAO().list();

		StringBuffer sb = new StringBuffer();
		//sb.append("<!DOCTYPE html>");
		// sb.append("<table align='center' border='1' cellspacing='0'>\r\n")
		// sb.append("<div style='margin:0 100px'>");
		sb.append("<br><br><h2 align='center'><p>商品详情</></h2><br>\r\n");
		sb.append("<hr/>");
		sb.append("<br>");

		String trFormat = "<div style='margin:0 100px'><h4><tr><p style='text-indent:50px'>%s</p></tr></h4>\r\n</div>";
		/*String html = String.format(sb.toString(), commodity.getDetailedInfo());
		 
        response.getWriter().write(html);*/
		//for (Commodity commodity : Commoditys) {
		/*for (Commodity commodity) {
			String tr = String.format(trFormat, commodity.getDetailedInfo());

			sb.append(tr);
		}可用部分*/
	
			String tr = String.format(trFormat, commodity.getDetailedInfo());

			sb.append(tr);
		

		// sb.append("</table>");

		response.getWriter().write(sb.toString());
		// 设置详情显示方式
	}

	private Object commodity(Object object) {
		// TODO Auto-generated method stub
		return null;
	}

}
