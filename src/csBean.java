import java.util.*;
import java.sql.*;
import javax.swing.*;

/**
 * ��������ɼ���ѯ�������
 */
public class csBean {
	String sql;
	ResultSet rs;
	Vector tempvector=new Vector(1,1);

	String cNum;
	String sNum;
	float grade;

	int colNum;

	/**
	 * ���ѧ����ѡ����Ϣ
	 */
	public void csAdd(String cnum, String snum){
		
		Database DB = new Database();

		this.cNum = cnum;
		this.sNum = snum;
		
		sql = "insert into sc(cnum,snum) values ("+Integer.parseInt(cNum)+","+Integer.parseInt(sNum)+")";
		try{
			DB.OpenConn();
			DB.executeUpdate(sql);
			JOptionPane.showMessageDialog(null,"�ɹ����һ���µļ�¼��");

		}
		catch(Exception e){
			JOptionPane.showMessageDialog(null, "����ʧ��", "����", JOptionPane.ERROR_MESSAGE); 
		}
		finally {
			DB.closeStmt();
			DB.closeConn();
		}
	}

	/**
	 * �޸�ѧ����ѡ�γɼ�
	 */
	public void csModify(String cnum, String snum, String grade){
		Database DB = new Database();
		this.cNum = cnum;
		this.sNum = snum;

		try{
			this.grade = Float.parseFloat(grade);
		}
		catch(Exception e){
			JOptionPane.showMessageDialog(null, "�ɼ��������", "����", JOptionPane.ERROR_MESSAGE);
			return;
		}

		sql = "update sc set grade = "+grade+" where snum = "+Integer.parseInt(sNum)+" and cnum = "+Integer.parseInt(cNum)+" ";
		try{
			DB.OpenConn();
			DB.executeUpdate(sql);
			JOptionPane.showMessageDialog(null,"�ɹ��Ǽǳɼ���");
		}
		catch(Exception e){
			System.out.println(e);
			JOptionPane.showMessageDialog(null, "�Ǽ�ʧ��", "����", JOptionPane.ERROR_MESSAGE); 
		}
		finally {
			DB.closeStmt();
			DB.closeConn();
		}
	}

	/**
	 * ����ѧ����������ѡ�Ŀγ�����
	 */
	public String[] cNameSearch(String snum){
		Database DB = new Database();
		this.sNum = snum;

		sql = "select * from sc,course where sc.snum = "+Integer.parseInt(sNum)+" and sc.cnum = course.cnum";
		String[] cn = null;
		int row = 0;
		int i = 0;
		
		try{
			DB.OpenConn();
			rs = DB.executeQuery(sql);
			if(rs.last()){
				row = rs.getRow();
			}
			if(row == 0){
				cn = null;
			}
			else{
				cn = new String[row];
				rs.first();
				rs.previous();
				while(rs.next()){
					cn[i] = rs.getString(5);
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
		return cn;
	}

	/**
	 * �ɼ���Ϣ�ۺϲ�ѯ
	 */
	public String[][] csAllSearch(String snum, int colnum){
		this.sNum = snum;
		this.colNum = colnum;
		
		Database DB = new Database();
		String[][] cn = null;
		int row = 0;
		int i = 0;
		sql = "select * from sc,course,student where sc.snum = "+Integer.parseInt(sNum)+" and sc.cnum = course.cnum and sc.snum = student.snum";
		try{
			DB.OpenConn();
			rs = DB.executeQuery(sql);

			if(rs.last()){
				row = rs.getRow();
			}
			if(row == 0){
				cn = null;
			}
			else{
				cn = new String[row][colNum];
				rs.first();
				rs.previous();
				while(rs.next()){
					cn[i][0] = rs.getString(1);
					cn[i][1] = rs.getString(2);
					cn[i][2] = rs.getString(10);
					cn[i][3] = rs.getString(11);
					cn[i][4] = rs.getString(18);
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
		return cn;
	}
}
