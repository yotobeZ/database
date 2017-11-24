package commodity;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;



public class UserDAO {
	static int grade=0;
	public static void main(String[] args) {  
		//System.out.println("111");
		System.out.println(new UserDAO().getUser(LoginServlet.name, LoginServlet.password).getId()
				); 
		//System.out.println("111");  
		}
	

	public User getUser(String name, String password) { 
		//System.out.println(name);
		//System.out.println(password);
		User result = null;        
		try {     Class.forName("com.mysql.jdbc.Driver");      
		Connection c = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/commodity?useUnicode=true&characterEncoding=utf8",   
				"root", "admin");          
		String sql = "select * from users where name = ? and password = ?";  
		PreparedStatement ps = c.prepareStatement(sql);        
		ps.setString(1, name);      
		ps.setString(2, password);   
		ResultSet rs = ps.executeQuery(); 
		//System.out.println("111");
		if (rs.next()){    
			//int grade=rs.getGrade(3);
			result = new User();        
			result.setId(rs.getInt(1));    
			result.setPassword(password);           
			result.setName(name); 
			result.setGrade(rs.getInt("grade")); 
			if(result.getGrade()==1)
			{grade=1;}
			else{grade=0;}
			System.out.println(grade);
			} 
		System.out.println(grade);
		ps.close();           
		c.close();         
		} catch (ClassNotFoundException e) { 
			// TODO Auto-generated catch block     
			e.printStackTrace();        }
		catch (SQLException e) {        
			// TODO Auto-generated catch block     
			e.printStackTrace();        }      
		return result;    }
	/*public void update(User user) {
		  
        String sql = "update User set name= ?, password = ? , grade = ?  where id = ?";
       // try (Connection c = getConnection(); PreparedStatement ps = c.prepareStatement(sql);) {
        try {     Class.forName("com.mysql.jdbc.Driver");      
		Connection c = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/commodity?useUnicode=true&characterEncoding=utf8",   
				"root", "admin");  
		PreparedStatement ps = c.prepareStatement(sql);       
            ps.setString(1, user.name);
            ps.setString(2, user.password);
            ps.setInt(3, user.grade);
            ps.setInt(4, user.id);
  
            ps.execute();
  
        } catch (SQLException e) {
  
            e.printStackTrace();
        }
  
    }*/
	
	
		}
	