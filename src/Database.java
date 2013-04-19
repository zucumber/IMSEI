
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Database {

	static String idlast;
	//constructor
	public Database(){
		
	}
	
	//initialize the DB :create new table
	public void initialDB(){
		
		try
		{
		Class.forName("org.sqlite.JDBC");
		}
		catch(ClassNotFoundException e)
		{
			System.out.println("sqlite JDBC Class not found!");
		}
		Connection connection = null;
		try
		{
			connection = DriverManager.getConnection("jdbc:sqlite:D:\\GitHub\\JDatabase\\DB.db");
			Statement statement = connection.createStatement();
			statement.setQueryTimeout(30);
			try
			{
			statement.execute("drop table if exists studname");
			statement.execute("drop table if exists items");
			statement.execute("create table studname(id integer, name string)");
			statement.execute("create table items(item string, number integer)");
			}
			catch(Exception e)
			{
				System.out.println("Cannot create Database!");
			}
		}
		catch(SQLException e)
		{
			System.err.println(e.getMessage()); // return error if the DB is unavailable/disable to connect 
		}
		finally
		{
			try
			{
				if(connection != null){
					connection.close(); //close connection
				}
			}
			catch(SQLException e)
			{
				System.err.println(e);
			}
		}
	}
	
	//initialize the DB :create new table
		public void initialDBitems(String tblnm){
			
			try
			{
			Class.forName("org.sqlite.JDBC");
			}
			catch(ClassNotFoundException e)
			{
				System.out.println("sqlite JDBC Class not found!");
			}
			Connection connection = null;
			try
			{
				connection = DriverManager.getConnection("jdbc:sqlite:D:\\GitHub\\JDatabase\\DB.db");
				Statement statement = connection.createStatement();
				statement.setQueryTimeout(30);
				try
				{
				statement.execute("drop table if exists studname");
				statement.execute("drop table if exists book");
				statement.execute("drop table if exists items");
				statement.execute("create table studname(id integer, name string)");
				statement.execute("create table items(item string, number integer)");
				}
				catch(Exception e)
				{
					System.out.println("Cannot create Database!");
				}
			}
			catch(SQLException e)
			{
				System.err.println(e.getMessage()); // return error if the DB is unavailable/disable to connect 
			}
			finally
			{
				try
				{
					if(connection != null){
						connection.close(); //close connection
					}
				}
				catch(SQLException e)
				{
					System.err.println(e);
				}
			}
		}
	
	public void inputDB(String Tblname ,int id, String str){
		try
		{
		Class.forName("org.sqlite.JDBC");
		}
		catch(ClassNotFoundException e)
		{
			System.out.println("sqlite JDBC Class not found!");
		}
		Connection connection = null;
		try
		{
			connection = DriverManager.getConnection("jdbc:sqlite:D:\\GitHub\\JDatabase\\DB.db");
			Statement statement = connection.createStatement();
			statement.setQueryTimeout(30);
			try
			{
			statement.execute("select * from " + Tblname);
			statement.execute("insert into " + Tblname +" values("+ id +",'" + str + "')");
			ResultSet rs=statement.executeQuery("select * from " + Tblname);
			while(rs.next())
				{
					System.out.println("name=" + rs.getString("name"));
					System.out.println("id=" + rs.getString("id"));
				}
			}
			catch(Exception e)
			{
				System.out.println("Database not found!");
			}
		}
		catch(SQLException e)
		{
			System.err.println(e.getMessage()); // return error if the DB is unavailable/disable to connect 
		}
		finally
		{
			try
			{
				if(connection != null){
					connection.close(); //close connection
				}
			}
			catch(SQLException e)
			{
				System.err.println(e);
			}
		}
	}
	
	public void addDB(String Tblname ,String item, int number){
		try
		{
		Class.forName("org.sqlite.JDBC");
		}
		catch(ClassNotFoundException e)
		{
			System.out.println("sqlite JDBC Class not found!");
		}
		Connection connection = null;
		try
		{
			connection = DriverManager.getConnection("jdbc:sqlite:D:\\GitHub\\JDatabase\\DB.db");
			Statement statement = connection.createStatement();
			statement.setQueryTimeout(30);
			
			try
			{
			statement.executeQuery("select * from " + Tblname);

				try
				{
					
				ResultSet rs=statement.executeQuery("select * from " + Tblname + " where item='" + item + "'");
				String stnum=rs.getString("number");
				number=Integer.parseInt(stnum) + number;
				statement.execute("update " + Tblname +" set number="+ number +" where item='" + item + "'");
				
				//Check database
				ResultSet rs2=statement.executeQuery("select * from " + Tblname);
					while(rs2.next())
					{
						System.out.println("item=" + rs2.getString("item"));
						System.out.println("number=" + rs2.getString("number"));
					}
					System.out.println("####");
				}
				catch(Exception e)
				{
					
					//initialDB();
					statement.execute("insert into " + Tblname +" values('"+ item +"'," + number + ")");
				}
			}
			catch(Exception e)
			{
				System.out.println("Database not found! New Database");
				initialDB();
			}
		}
		catch(SQLException e)
		{
			System.err.println(e.getMessage()); // return error if the DB is unavailable/disable to connect 
		}
		finally
		{
			try
			{
				if(connection != null){
					connection.close(); //close connection
				}
			}
			catch(SQLException e)
			{
				System.err.println(e);
			}
		}
	}
	
	public void outputDB(String Tblname , String str){
		try
		{
		Class.forName("org.sqlite.JDBC");
		}
		catch(ClassNotFoundException e)
		{
			System.out.println("sqlite JDBC Class not found!");
		}
		Connection connection = null;
		try
		{
			connection = DriverManager.getConnection("jdbc:sqlite:D:\\GitHub\\JDatabase\\DB.db");
			Statement statement = connection.createStatement();
			statement.setQueryTimeout(30);
			try
			{
			ResultSet rs=statement.executeQuery("select * from " + Tblname + " where id="+ str);
			while(rs.next())
				{
					System.out.println("name=" + rs.getString("name"));
					System.out.println("id=" + rs.getString("id"));
				}
			}
			catch(Exception e)
			{
				System.out.println("Database not found!");
			}
		}
		catch(SQLException e)
		{
			System.err.println(e.getMessage()); // return error if the DB is unavailable/disable to connect 
		}
		finally
		{
			try
			{
				if(connection != null){
					connection.close(); //close connection
				}
			}
			catch(SQLException e)
			{
				System.err.println(e);
			}
		}
	}
	
	public String getLastId(String Tblname){
		try
		{
		Class.forName("org.sqlite.JDBC");
		}
		catch(ClassNotFoundException e)
		{
			System.out.println("sqlite JDBC Class not found!");
		}
		Connection connection = null;
		try
		{
			connection = DriverManager.getConnection("jdbc:sqlite:D:\\GitHub\\JDatabase\\DB.db");
			Statement statement = connection.createStatement();
			statement.setQueryTimeout(30);
			try
			{
				ResultSet rs=statement.executeQuery("select * from " + Tblname + " order by id");
				while(rs.next())
				{
					idlast = rs.getString("id");
				}
			}
			catch(Exception e)
			{
				System.out.println("Database not found!");
			}
		}
		catch(SQLException e)
		{
			System.err.println(e.getMessage()); // return error if the DB is unavailable/disable to connect 
		}
		finally
		{
			try
			{
				if(connection != null){
					connection.close(); //close connection
				}
			}
			catch(SQLException e)
			{
				System.err.println(e);
			}
		}
		return idlast;
	}
	
	/**
	 * @param args
	 */
	/*
	public static void main(String[] args) throws ClassNotFoundException {
		// TODO Auto-generated method stub
		Class.forName("org.sqlite.JDBC");
		//inputDB(""main");
		
	}*/
}
