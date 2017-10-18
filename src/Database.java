import java.sql.*;

/**
 * 连接数据库的类
 */
public class Database {
	
	private Statement stmt=null;
	ResultSet rs=null;
	private Connection conn=null;
	String sql;
	//String strurl="jdbc:odbc:scmanage";
	
	public Database(){
	}
	
	/**
	 * 打开数据库连接
	 */
	public void OpenConn()throws Exception{
		try{
			/*Class.forName("sun.jdbc.odbc.JdbcOdbcDriver"); 
			conn=DriverManager.getConnection(strurl);
			System.out.println("连接成功！");
			*/
			Class.forName("com.hxtt.sql.access.AccessDriver");            //最关键2步---加载驱动、建立连接   （其他操作步骤都大同小异）
			conn = DriverManager.getConnection("jdbc:Access:///scmanage.mdb");
			System.out.println("数据库连接成功！");
		}
		catch(Exception e){ 
			System.err.println("OpenConn:"+e.getMessage());
		}
	}

	/**
	 * 执行sql语句，返回结果集rs
	 */
	public ResultSet executeQuery(String sql){
		stmt = null;
		rs=null;
		try{
			stmt=conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
			rs=stmt.executeQuery(sql);
		}
		catch(SQLException e){
			System.err.println("executeQuery:"+e.getMessage());
		}
		return rs;
	}

	/**
	 * 执行sql语句
	 */
	public void executeUpdate(String sql){
		stmt=null;
		rs=null;
		try{
			stmt=conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
			stmt.executeUpdate(sql);
			conn.commit();
		}
		catch(SQLException e){
			System.err.println("executeUpdate:"+e.getMessage()); 
		}
	}
	
	public void closeStmt(){
		
	}

	/**
	 * 关闭数据库连接
	 */
	public void closeConn(){
		try{
			conn.close();
		}
		catch(SQLException ex){
			System.err.println("aq.closeConn:"+ex.getMessage()); 
		}
	}
	
	/*
	 *转换编码
	 */
	public static String toGBK(String str){
		try {
			if(str==null)
				str = "";
			else
				str=new String(str.getBytes("ISO-8859-1"),"GBK"); 
		}
		catch (Exception e) {System.out.println(e);}
		
		return str;
	}
}

