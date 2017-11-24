package commodity;

import java.io.IOException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class UserRegisterServlet  extends HttpServlet {
	public void service(HttpServletRequest request, HttpServletResponse response){
		response.setContentType("text/html; charset=UTF-8");
try {
		response.getWriter().println("<br><br><h1 align='center'>注册成功！</h1>");
		
} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
}
}


}
