import java.awt.*;
import java.sql.*;
import javax.swing.*;
import javax.swing.table.*;
import java.util.*;
import java.awt.event.*;
import java.net.*;

/**
 * ��ʾ�ɼ���ѯģ���ѯ�������
 */
public class ResultGrade extends JFrame {
	JLabel jLabel1 = new JLabel();
	JButton jBExit = new JButton();
	JScrollPane jScrollPane1 ;
	JTable jTabStuInfo;

	String sNum;
	String[] colName = {"ѧ��","����","�γ̺�","�γ�����","�ɼ�"};
	String[][] colValue;
	
	public ResultGrade(String sNum) {
		this.setTitle("�ɼ���ѯ���");
		//���ó���ͼ��
		this.setIconImage(getImage("icon.gif")); 
		//��������λ�ã�ʹ�Ի������
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		this.setLocation( (int) (screenSize.width - 400) / 2 ,
						(int) (screenSize.height - 300) / 2 + 45);

		this.sNum = sNum;
		csBean rGrade = new csBean();
		try {
			colValue = rGrade.csAllSearch(sNum,5);	
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
