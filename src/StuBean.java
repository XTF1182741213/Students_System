import java.util.*;
import java.sql.*;
import javax.swing.*;

/**
 * 有关学生信息数据库操作的类
 */
public class StuBean {
	String sql;
	ResultSet rs = null;
	
	String sNum;
	String sName;
	String sSex;
	String sBirth;
	String sHome;
	String sEthnic;
	String sYear;
	String sMajor;
	String sCollege;

	String colName;//列名
	String colValue;//列值
	String colValue2;//列值

	int stuId;//学生的新学号
	
	/**
	 * 添加学生信息
	 */	
	public void stuAdd(String name, String sex, String birth, String home, String ethnic, String year, String major, String college){
		
		Database DB = new Database();
		
		this.sName = name;
		this.sSex = sex;
		this.sBirth = birth;
		this.sHome = home;
		this.sEthnic = ethnic;
		this.sYear = year;
		this.sMajor = major;
		this.sCollege = college;

		if(sName == null||sName.equals("")){
			JOptionPane.showMessageDialog(null, "请输入学生姓名", "错误", JOptionPane.ERROR_MESSAGE);
			return;
		}
		else{
			sql = "insert into student(sname,ssex,sbirth,shome,sethnic,syear,smajor,scollege) values ('"+sName+"','"+sSex+"','"+sBirth+"','"+sHome+"','"+sEthnic+"','"+sYear+"','"+sMajor+"','"+sCollege+"')";

			try{
				DB.OpenConn();
				DB.executeUpdate(sql);
				JOptionPane.showMessageDialog(null,"成功添加一条新的纪录！");

			}
			catch(Exception e){
				System.out.println(e);
				JOptionPane.showMessageDialog(null, "保存失败", "错误", JOptionPane.ERROR_MESSAGE); 
			}
			finally {
				DB.closeStmt();
				DB.closeConn();
			}
		}
	}

	/**
	 * 修改学生信息
	 */
	public void stuModify(String num, String name, String sex, String birth, String home, String ethnic, String year, String major, String college){
		
		Database DB = new Database();
		
		this.sNum = num;
		this.sName = name;
		this.sSex = sex;
		this.sBirth = birth;
		this.sHome = home;
		this.sEthnic = ethnic;
		this.sYear = year;
		this.sMajor = major;
		this.sCollege = college;

		if(sName == null||sName.equals("")){
			JOptionPane.showMessageDialog(null, "请输入学生姓名", "错误", JOptionPane.ERROR_MESSAGE);
			return;
		}
		else{
			sql = "update student set sname = '"+sName+"', ssex = '"+sSex+"', sbirth = '"+sBirth+"', shome = '"+sHome+"', sethnic = '"+sEthnic+"', syear = '"+sYear+"', smajor = '"+sMajor+"', scollege = '"+sCollege+"' where snum = "+Integer.parseInt(sNum)+"";
			try{
				DB.OpenConn();
				DB.executeUpdate(sql);
				JOptionPane.showMessageDialog(null,"成功修改一条新的纪录！");
			}
			catch(Exception e){
				System.out.println(e);
				JOptionPane.showMessageDialog(null, "更新失败", "错误", JOptionPane.ERROR_MESSAGE); 
			}
			finally {
				DB.closeStmt();
				DB.closeConn();
			}
		}
	}

	/**
	 * 删除学生信息
	 */
	public void stuDel(String num){
		
		Database DB = new Database();
		this.sNum = num;
		
		sql = "delete from student where snum = "+Integer.parseInt(sNum)+"";
		try{
			DB.OpenConn();
			DB.executeUpdate(sql);
			JOptionPane.showMessageDialog(null,"成功删除一条新的纪录！");
		}
		catch(Exception e){
			System.out.println(e);
			JOptionPane.showMessageDialog(null, "删除失败", "错误", JOptionPane.ERROR_MESSAGE); 
		}
		finally {
			DB.closeStmt();
			DB.closeConn();
		}
	}

	/**
	 * 根据学号查询学生信息
	 */
	public String[] stuSearch(String num){
		
		Database DB = new Database();
		this.sNum = num;
		String[] s = new String[8];
		sql = "select * from student where snum = "+Integer.parseInt(sNum)+"";

		try{
			DB.OpenConn();
			rs = DB.executeQuery(sql);
			if(rs.next()){
				s[0] = rs.getString("sname");
				s[1] = rs.getString("ssex");
				s[2] = rs.getString("sethnic");
				s[3] = rs.getString("shome");
				s[4] = rs.getString("syear");
				s[5] = rs.getString("smajor");
				s[6] = rs.getString("scollege");
				s[7] = rs.getString("sbirth");
			}
			else
				s = null;
		}
		catch(Exception e){
		}
		finally {
			DB.closeStmt();
			DB.closeConn();
		}
		return s;
	}

	/**
	 * 学生信息综合查询(按照一个条件进行查询)
	 */
	public String[][] stuAllSearch(String colname,String colvalue){
		this.colName = colname;
		this.colValue = colvalue;

		Database DB = new Database();
		String[][] sn = null;
		int row = 0;
		int i = 0;

		DB.toGBK(colvalue);
		
		if(colValue == null||colValue.equals("")){
			sql = "select * from student";
		}
		else{
			sql = "select * from student where "+colName+" = '"+colValue+"'";
		}
		try{
			DB.OpenConn();
			rs = DB.executeQuery(sql);

			if(rs.last()){
				row = rs.getRow();
			}
			
			if(row == 0){
				sn = null;
			}
			else{
				sn = new String[row][9];
				rs.first();
				rs.previous();
				while(rs.next()){
					sn[i][0] = rs.getString("snum");
					sn[i][1] = rs.getString("sname");
					sn[i][2] = rs.getString("ssex");
					sn[i][3] = rs.getString("sethnic");
					sn[i][4] = rs.getString("shome");
					sn[i][5] = rs.getString("syear");
					sn[i][6] = rs.getString("smajor");
					sn[i][7] = rs.getString("scollege");
					sn[i][8] = rs.getString("sbirth");
					i++;
				}
			}
		}
		catch(Exception e){
		}
		finally {
			DB.closeStmt();
			DB.closeConn();
		}
		return sn;
	}

	/**
	 * 学生信息综合查询(查询某范围内的记录)
	 */
	public String[][] stuAllSearch(String colname,String colvalue,String colvalue2){
		this.colName = colname;
		this.colValue = colvalue;
		this.colValue2 = colvalue2;
		
		Database DB = new Database();
		String[][] sn = null;
		int row = 0;
		int i = 0;
		sql = "select * from student where "+colName+" between "+colValue+" and "+colValue2+"";
		try{
			DB.OpenConn();
			rs = DB.executeQuery(sql);

			if(rs.last()){
				row = rs.getRow();
			}
			
			if(row == 0){
				sn = null;
			}
			else{
				sn = new String[row][9];
				rs.first();
				rs.previous();
				while(rs.next()){
					sn[i][0] = rs.getString("snum");
					sn[i][1] = rs.getString("sname");
					sn[i][2] = rs.getString("ssex");
					sn[i][3] = rs.getString("sethnic");
					sn[i][4] = rs.getString("shome");
					sn[i][5] = rs.getString("syear");
					sn[i][6] = rs.getString("smajor");
					sn[i][7] = rs.getString("scollege");
					sn[i][8] = rs.getString("sbirth");
					i++;
				}
			}
		}
		catch(Exception e){
		}
		finally {
			DB.closeStmt();
			DB.closeConn();
		}
		return sn;
	}
	
	/**
	 * 获得新的学号
	 */
	public int getStuId(){
		Database DB = new Database();
		sql = "select max(snum) from student";
		try{
			DB.OpenConn();
			rs = DB.executeQuery(sql);
			if(rs.next()){
				stuId = rs.getInt(1) + 1;
			}
			else
				stuId = 1;
		}
		catch(Exception e){
		}
		finally {
			DB.closeStmt();
			DB.closeConn();
		}
		return stuId;
	}

	/**
	 * 获得student表中的所有学号snum
	 */
	public String[] getAllId(){
		String[] s = null;
		int row = 0;
		int i = 0;
		Database DB = new Database();
		sql = "select snum from student";
		
		try{
			DB.OpenConn();
			rs = DB.executeQuery(sql);
			if(rs.last()){
				row = rs.getRow();
			}

			if(row == 0){
				s = null;
			}
			else{
				s = new String[row];
				rs.first();
				rs.previous();
				while(rs.next()){
					s[i] = rs.getString(1);
					i++;
				}
			}
		}
		catch(Exception e){
			System.out.println(e);
		}
		finally {
			DB.closeStmt();
			DB.closeConn();
		}
		return s;
	}
}
