package commodity;


import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class LoginServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	public static String name;
	public static String password;

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");//解决中文乱码问题
		String type=request.getParameter("type");
		//if("login".equals(type)){
		name = request.getParameter("name");
		password = request.getParameter("password");

		User user = new UserDAO().getUser(name, password);
		//System.out.println(user);
		if( (null != user)&&(UserDAO.grade==1)){
			response.sendRedirect("/editCommodity");
			//登录可查看数据并修改
		} 
		else if((null != user)&&(UserDAO.grade==0)){
			response.sendRedirect("/listCommodity");
			//登录可以查看数据，但是不能修改
		}
		else{
		//response.sendRedirect("/login.jsp");
			response.sendRedirect("fault.html");
			//非正常用户，不能登录
	}
		//}
		/*else if("register".equals(type))
		{
			String userName=request.getParameter("userName");
			String password=request.getParameter("password1");
			int count=us.getUserByName(userName);
			if(count==0)
			{
				Users user=new Users();
				user.setUserName(userName);
				user.setGrade("0");
				user.setPassword(password);
				//����û�
				us.addUser(user);
				//�õ��ո���ӵ����û�
				user=us.checkuser(user);

				request.getSession().setAttribute("updateUser", user);
				response.sendRedirect("/Second/jsp/update.jsp");
			}else
			{
				request.setAttribute("ExpRegError", "���û����ѱ�ע�ᣬ���������룡");
				request.getRequestDispatcher("/register.jsp").forward(request, response);
			}
		}*/
}
}
