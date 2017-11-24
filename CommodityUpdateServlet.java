package commodity;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class CommodityUpdateServlet extends HttpServlet{
 
    protected void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
 
        request.setCharacterEncoding("UTF-8");
        /*int ProductID;
    	String ProductName;
    	String InnerCName;
    	float Price;
    	String UnitPrice;
    	String Specification;
    	float Weight;
    	String DetailedInfo;
    	String UpshelfDate;
    	int StockLevel;
    	float PricePromotion;*/
        Commodity commodity = new Commodity();
        commodity.setProductID(Integer.parseInt(request.getParameter("ProductID")));
        commodity.setProductName(request.getParameter("ProductName"));
        commodity.setInnerCName(request.getParameter("InnerCName"));
        commodity.setPrice(Float.parseFloat(request.getParameter("Price")));
        commodity.setUnitPrice(request.getParameter("UnitPrice"));
        commodity.setSpecification(request.getParameter("Specification"));
        commodity.setWeight(Float.parseFloat(request.getParameter("Weight")));
        commodity.setDetailedInfo(request.getParameter("DetailedInfo"));//超链怎么改
        commodity.setUpshelfDate(request.getParameter("UpshelfDate"));
        commodity.setStockLevel(Integer.parseInt(request.getParameter("StockLevel")));
        commodity.setPricePromotion(Float.parseFloat(request.getParameter("PricePromotion")));
        System.out.println("ProductName");

        new CommodityDAO().update(commodity);
 
        response.sendRedirect("/listCommodity");
 
    }


}
