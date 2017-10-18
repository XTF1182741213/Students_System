import java.awt.*;
import java.sql.*;
import javax.swing.*;
import javax.swing.table.*;
import java.util.*;
import java.awt.event.*;
import java.net.*;

/**
 * ��ʾ�γ̲�ѯģ���ѯ�������
 */
public class ResultCourse extends JFrame {
	JLabel jLabel1 = new JLabel();
	JButton jBExit = new JButton();
	JScrollPane jScrollPane1 ;
	JTable jTabStuInfo;
	String[] colName = {"�γ̺�","�γ�����","�ڿ���ʦ","�Ͽεص�","�Ͽ�ʱ��","�γ�����"};
	String[][] colValue;
	String sColValue;
	String sColName;
	
	public ResultCourse(String colname,String colvalue) {
		this.sColValue = colvalue;
		this.sColName = colname;

		this.setTitle("�γ̲�ѯ���");
		//���ó���ͼ��
		this.setIconImage(getImage("icon.gif")); 
		//��������λ�ã�ʹ�Ի������
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		this.setLocation( (int) (screenSize.width - 400) / 2 ,
						(int) (screenSize.height - 300) / 2 + 45);
		CrsBean rCrs = new CrsBean();
		try {
			colValue = rCrs.crsAllSearch(sColName,sColValue);
			if(colValue == null){
				JOptionPane.showMessageDialog(null, "û�з��������ļ�¼"); 
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
	 * ͨ���������ļ������ͼ��
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
