package commodity;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import blogs.ArticleDAO;

public class CommodityDeleteServlet extends HttpServlet{

	 
    protected void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
 
        int ProductID = Integer.parseInt(request.getParameter("ProductID"));
         
        new CommodityDAO().delete(ProductID);
 
        response.sendRedirect("/listCommodity");
         
    }


}
