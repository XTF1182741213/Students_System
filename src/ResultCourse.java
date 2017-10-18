import java.awt.*;
import java.sql.*;
import javax.swing.*;
import javax.swing.table.*;
import java.util.*;
import java.awt.event.*;
import java.net.*;

/**
 * 显示课程查询模块查询结果的类
 */
public class ResultCourse extends JFrame {
	JLabel jLabel1 = new JLabel();
	JButton jBExit = new JButton();
	JScrollPane jScrollPane1 ;
	JTable jTabStuInfo;
	String[] colName = {"课程号","课程名称","授课老师","上课地点","上课时间","课程类型"};
	String[][] colValue;
	String sColValue;
	String sColName;
	
	public ResultCourse(String colname,String colvalue) {
		this.sColValue = colvalue;
		this.sColName = colname;

		this.setTitle("课程查询结果");
		//设置程序图标
		this.setIconImage(getImage("icon.gif")); 
		//设置运行位置，使对话框居中
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		this.setLocation( (int) (screenSize.width - 400) / 2 ,
						(int) (screenSize.height - 300) / 2 + 45);
		CrsBean rCrs = new CrsBean();
		try {
			colValue = rCrs.crsAllSearch(sColName,sColValue);
			if(colValue == null){
				JOptionPane.showMessageDialog(null, "没有符合条件的记录"); 
				this.dispose();
			}
			else{
				jTabStuInfo = new JTable(colValue,colName);
				jScrollPane1 = new JScrollPane(jTabStuInfo);
				this.getContentPane().add(jScrollPane1,BorderLayout.CENTER);
				this.pack();
				this.setVisible(true);
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * 通过给定的文件名获得图像
	 */
	Image getImage(String filename) {
		URLClassLoader urlLoader = (URLClassLoader)this.getClass().
			getClassLoader();
		URL url = null;
		Image image = null;
		url = urlLoader.findResource(filename);
		image = Toolkit.getDefaultToolkit().getImage(url);
		MediaTracker mediatracker = new MediaTracker(this);
		try {
			mediatracker.addImage(image, 0);
			mediatracker.waitForID(0);
		}
		catch (InterruptedException _ex) {
			image = null;
		}
		if (mediatracker.isErrorID(0)) {
			image = null;
		}
		return image;
	}
}
