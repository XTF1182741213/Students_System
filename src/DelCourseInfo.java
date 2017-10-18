import java.awt.*;
import java.sql.*;
import java.awt.event.*;
import javax.swing.*;

/**
 * �γ���Ϣ����ģ��
 * �޸Ŀγ���Ϣ����
 */
public class DelCourseInfo extends CourseInfo{
	String cNum_str = "";
	public DelCourseInfo() {
		this.setTitle("ɾ���γ���Ϣ");
		this.setResizable(false);

		cNum.setEditable(false);
		cNum.setText("���ѯ�γ̺�");
		cName.setEditable(false);
		cTeacher.setEditable(false);
		cType.setEditable(false);
		cTime.setEditable(false);
		cPlace.setEditable(false);

		//��������λ�ã�ʹ�Ի������
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		this.setLocation( (int) (screenSize.width - 400) / 2 ,
						(int) (screenSize.height - 300) / 2 +45);
	}

	public void downInit(){
		searchInfo.setText("��ѯ");
		searchInfo.setFont(new Font("Dialog",0,12));
		downPanel.add(searchInfo);
		deleteInfo.setText("ɾ��");
		deleteInfo.setFont(new Font("Dialog",0,12));
		downPanel.add(deleteInfo);
		clearInfo.setText("���");
		clearInfo.setFont(new Font("Dialog",0,12));
		downPanel.add(clearInfo);
		eixtInfo.setText("�˳�");
		eixtInfo.setFont(new Font("Dialog",0,12));
		downPanel.add(eixtInfo);

		contentPane.add(downPanel,BorderLayout.SOUTH);

		searchInfo.setEnabled(true);
		deleteInfo.setEnabled(false);
		eixtInfo.setEnabled(true);

		//����¼�����
		searchInfo.addActionListener(this);
		deleteInfo.addActionListener(this);
		eixtInfo.addActionListener(this);
	}
	/**
	 * �¼�����
	 */
	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();
		String[] s = new String[5];

		if (obj == eixtInfo) { //�˳�
			this.dispose();
		}
		else if (obj == deleteInfo) { //ɾ��
			int ifdel = JOptionPane.showConfirmDialog(null,"���Ҫɾ������Ϣ��","��ʾ��Ϣ",JOptionPane.YES_NO_OPTION,JOptionPane.INFORMATION_MESSAGE );
			if(ifdel == JOptionPane.YES_OPTION){
				CrsBean delCrs = new CrsBean();
				delCrs.crsDel(cNum.getText());
				
				this.dispose();

				DelCourseInfo dci = new DelCourseInfo();
				dci.downInit();
				dci.pack();
				dci.setVisible(true);
			}
			else{
				return;
			}
		}
		else if (obj == searchInfo) { //ѧ�Ų�ѯ
			CourseInfoSearchCnum cisc = new CourseInfoSearchCnum(this);
			cisc.pack();
			cisc.setVisible(true);
			cNum_str = cisc.getCnum();

			CrsBean searchCrs = new CrsBean();
			s = searchCrs.crsSearch(cNum_str);
			if(s == null){
				JOptionPane.showMessageDialog(null, "��¼�����ڣ�");
				cNum.setText("���ѯѧ��");
				cName.setText("");
				cTeacher.setText("");
				cPlace.setText("");
				cType.setText("");
				cTime.setText("");
								
				cName.setEditable(false);
				cTeacher.setEditable(false);
				cPlace.setEditable(false);
				cType.setEditable(false);
				cTime.setEditable(false);
				deleteInfo.setEnabled(false);
				return;
			}
			else{
				cNum.setText(cNum_str);
				cName.setText(s[0]);
				cTeacher.setText(s[1]);
				cPlace.setText(s[2]);
				cType.setText(s[3]);
				cTime.setText(s[4]);

				cName.setEditable(true);
				cTeacher.setEditable(true);
				cPlace.setEditable(true);
				cType.setEditable(true);
				cTime.setEditable(true);
				deleteInfo.setEnabled(true);
			}
		}
	}
}