package commodity;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class CommodityDAO {

	/*
	 * public CommodityDAO() { try { Class.forName("com.mysql.jdbc.Driver"); }
	 * catch (ClassNotFoundException e) { e.printStackTrace(); } }
	 * 
	 * public Connection getConnection() throws SQLException { return
	 * DriverManager.getConnection(
	 * "jdbc:mysql://127.0.0.1:3306/commodity?characterEncoding=UTF-8", "root",
	 * "admin"); }
	 */

	public int getTotal() {
		int total = 0;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection c = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/commodity?characterEncoding=UTF-8",
					"root", "admin");
			Statement s = c.createStatement();

			String sql = "select count(*) from commodity ";

			ResultSet rs = s.executeQuery(sql);
			while (rs.next()) {
				total = rs.getInt(1);
				
			}

			System.out.println("total:" + total);
			s.close();

			c.close();

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return total;
	}
	/*
	 * } catch (SQLException e) {
	 * 
	 * e.printStackTrace(); } return total; }
	 */

	public void add(Commodity commodity) {
		  System.out.println(1235);
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection c = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/commodity?characterEncoding=UTF-8",
					"root", "admin");
			String sql = "insert into commodity values(null,?,?,?,?,?,?,?,?,?,?)";
			PreparedStatement ps = c.prepareStatement(sql);
			
			  System.out.println(1234);
			ps.setString(1, commodity.ProductName);
			ps.setString(2, commodity.InnerCName);
			ps.setFloat(3, commodity.Price);
			ps.setString(4, commodity.UnitPrice);
			ps.setString(5, commodity.Specification);
			ps.setFloat(6, commodity.Weight);
			ps.setString(7, commodity.DetailedInfo);
			ps.setString(8, commodity.UpshelfDate);
			ps.setInt(9, commodity.StockLevel);
			ps.setFloat(10, commodity.PricePromotion);
			
			ps.execute();

			ResultSet rs = ps.getGeneratedKeys();
			if (rs.next()) {
				int ProductID = rs.getInt(1);
				commodity.ProductID = ProductID;
			}

			ps.close();

			c.close();

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void update(Commodity commodity) {

		String sql = "update commodity set ProductName=?,InnerCName=?,Price=?,UnitPrice=?,Specification=?,"
				+ "Weight=?,DetailedInfo=?,UpshelfDate=?,StockLevel=?,PricePromotion=?where ProductID = ?";
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection c = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/commodity?characterEncoding=UTF-8",
					"root", "admin");
			PreparedStatement ps = c.prepareStatement(sql);

			ps.setString(1, commodity.ProductName);
			ps.setString(2, commodity.InnerCName);
			ps.setFloat(3, commodity.Price);
			ps.setString(4, commodity.UnitPrice);
			ps.setString(5, commodity.Specification);
			ps.setFloat(6, commodity.Weight);
			ps.setString(7, commodity.DetailedInfo);
			ps.setString(8, commodity.UpshelfDate);
			ps.setInt(9, commodity.StockLevel);
			ps.setFloat(10, commodity.PricePromotion);
			ps.setInt(11, commodity.ProductID);

			ps.execute();

			ps.close();

			c.close();

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void delete(int ProductID) {

		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection c = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/commodity?characterEncoding=UTF-8",
					"root", "admin");
			Statement s = c.createStatement();

			String sql = "delete from commodity where ProductID = " + ProductID;

			s.execute(sql);
			s.close();

			c.close();

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public Commodity get(int ProductID) {
		Commodity commodity = null;

		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection c = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/commodity?characterEncoding=UTF-8",
					"root", "admin");
			Statement s = c.createStatement();

			String sql = "select * from commodity where ProductID = " + ProductID;

			ResultSet rs = s.executeQuery(sql);

			if (rs.next()) {
				commodity = new Commodity();

				String ProductName = rs.getString(2);
				String InnerCName = rs.getString(3);
				float Price = rs.getFloat(4);
				String UnitPrice = rs.getString(5);
				String Specification = rs.getString(6);
				float Weight = rs.getFloat(7);
				String DetailedInfo = rs.getString(8);
				String UpshelfDate = rs.getString(9);
				int StockLevel = rs.getInt(10);
				float PricePromotion = rs.getFloat(11);

				commodity.ProductName = ProductName;
				commodity.InnerCName = InnerCName;
				commodity.Price = Price;
				commodity.UnitPrice = UnitPrice;
				commodity.Specification = Specification;
				commodity.Weight = Weight;
				commodity.DetailedInfo = DetailedInfo;
				commodity.UpshelfDate = UpshelfDate;
				commodity.StockLevel = StockLevel;
				commodity.PricePromotion = PricePromotion;
				commodity.ProductID = ProductID;
			}

			s.close();

			c.close();

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return commodity;
	}

	public List<Commodity> list() {// 实现分页
		return list(0, Short.MAX_VALUE);
	}

	public List<Commodity> list(int start, int count) {
		 List<Commodity> commoditys = new ArrayList<Commodity>();
		//List<Commodity> commoditys = new CommodityDAO().list();
		try {
			Class.forName("com.mysql.jdbc.Driver");

			Connection c = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/commodity?characterEncoding=UTF-8",
					"root", "admin");

			String sql = "select * from commodity order by ProductID asc limit ?,? ";//desc为降序

			PreparedStatement ps = c.prepareStatement(sql);
			//start=0;count=3;
			ps.setInt(1, start);
			ps.setInt(2, count);

			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				Commodity commodity = new Commodity();
				int ProductID = rs.getInt(1);
				String ProductName = rs.getString(2);
				String InnerCName = rs.getString(3);
				float Price = rs.getFloat(4);
				String UnitPrice = rs.getString(5);
				String Specification = rs.getString(6);
				float Weight = rs.getFloat(7);
				String DetailedInfo = rs.getString(8);
				String UpshelfDate = rs.getString(9);
				int StockLevel = rs.getInt(10);
				float PricePromotion = rs.getFloat(11);

				commodity.ProductID = ProductID;
				commodity.ProductName = ProductName;
				commodity.InnerCName = InnerCName;
				commodity.Price = Price;
				commodity.UnitPrice = UnitPrice;
				commodity.Specification = Specification;
				commodity.Weight = Weight;
				commodity.DetailedInfo = DetailedInfo;
				commodity.UpshelfDate = UpshelfDate;
				commodity.StockLevel = StockLevel;
				commodity.PricePromotion = PricePromotion;
				commoditys.add(commodity);
			}

			ps.close();

			c.close();

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return commoditys;
	}

}
/*
 * String sql = "select * from commodity order by ProductID desc limit ?,? ";
 * 
 * try (Connection c = getConnection(); PreparedStatement ps =
 * c.prepareStatement(sql);) { start = 0; count = 5; // List<Commodity>
 * commoditys = new CommodityDAO().list(start, // count); ps.setInt(1, start);
 * ps.setInt(2, count);
 * 
 * ResultSet rs = ps.executeQuery();
 * 
 * while (rs.next()) { Commodity commodity = new Commodity(); int ProductID =
 * rs.getInt(1); String ProductName = rs.getString(2); String InnerCName =
 * rs.getString(3); float Price = rs.getFloat(4); String UnitPrice =
 * rs.getString(5); String Specification = rs.getString(6); float Weight =
 * rs.getFloat(7); String DetailedInfo = rs.getString(8); String UpshelfDate =
 * rs.getString(9); int StockLevel = rs.getInt(10); float PricePromotion =
 * rs.getFloat(11);
 * 
 * commodity.ProductID = ProductID; commodity.ProductName = ProductName;
 * commodity.InnerCName = InnerCName; commodity.Price = Price;
 * commodity.UnitPrice = UnitPrice; commodity.Specification = Specification;
 * commodity.Weight = Weight; commodity.DetailedInfo = DetailedInfo;
 * commodity.UpshelfDate = UpshelfDate; commodity.StockLevel = StockLevel;
 * commodity.PricePromotion = PricePromotion; commoditys.add(commodity); }
 * 
 * } catch (SQLException e) {
 * 
 * e.printStackTrace(); } return commoditys; }
 * 
 * }
 */
