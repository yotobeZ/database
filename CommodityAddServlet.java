package commodity;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class CommodityAddServlet extends HttpServlet{

	 
    protected void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
 
        request.setCharacterEncoding("UTF-8");
 
        Commodity commodity = new Commodity();
        //commodity.setProductID(Integer.parseInt(request.getParameter("ProductID")));
        commodity.setProductName(request.getParameter("productName"));System.out.println(commodity.ProductName);
        commodity.setInnerCName(request.getParameter("innerCName"));System.out.println(commodity.InnerCName);
        System.out.println(request.getParameter("price"));
        commodity.setPrice(Float.parseFloat(request.getParameter("price")));System.out.println(commodity.UnitPrice);
        commodity.setUnitPrice(request.getParameter("unitPrice"));System.out.println(commodity.UnitPrice);
        commodity.setSpecification(request.getParameter("specification"));
        commodity.setWeight(Float.parseFloat(request.getParameter("weight")));
        commodity.setDetailedInfo(request.getParameter("detailedInfo"));//超链怎么改
        commodity.setUpshelfDate(request.getParameter("upshelfDate"));
        commodity.setStockLevel(Integer.parseInt(request.getParameter("stockLevel")));
        commodity.setPricePromotion(Float.parseFloat(request.getParameter("pricePromotion")));
        
        new CommodityDAO().add(commodity);
        System.out.println(777);
        response.sendRedirect("/listCommodity");
         
    }


	
}
