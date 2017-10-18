import java.sql.*;

/**
 * �������ݿ����
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
	 * �����ݿ�����
	 */
	public void OpenConn()throws Exception{
		try{
			/*Class.forName("sun.jdbc.odbc.JdbcOdbcDriver"); 
			conn=DriverManager.getConnection(strurl);
			System.out.println("���ӳɹ���");
			*/
			Class.forName("com.hxtt.sql.access.AccessDriver");            //��ؼ�2��---������������������   �������������趼��ͬС�죩
			conn = DriverManager.getConnection("jdbc:Access:///scmanage.mdb");
			System.out.println("���ݿ����ӳɹ���");
		}
		catch(Exception e){ 
			System.err.println("OpenConn:"+e.getMessage());
		}
	}

	/**
	 * ִ��sql��䣬���ؽ����rs
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
	 * ִ��sql���
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
	 * �ر����ݿ�����
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
	 *ת������
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

