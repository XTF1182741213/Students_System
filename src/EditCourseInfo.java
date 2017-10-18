import java.awt.*;
import java.sql.*;
import java.awt.event.*;
import javax.swing.*;

public class EditCourseInfo extends CourseInfo {
	String cNum_str = "";
	public EditCourseInfo() {
		this.setTitle("�޸Ŀγ���Ϣ");
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
		modifyInfo.setText("�޸�");
		modifyInfo.setFont(new Font("Dialog",0,12));
		downPanel.add(modifyInfo);
		clearInfo.setText("���");
		clearInfo.setFont(new Font("Dialog",0,12));
		downPanel.add(clearInfo);
		eixtInfo.setText("�˳�");
		eixtInfo.setFont(new Font("Dialog",0,12));
		downPanel.add(eixtInfo);

		this.contentPane.add(downPanel,BorderLayout.SOUTH);

		searchInfo.setEnabled(true);
		modifyInfo.setEnabled(false);
		clearInfo.setEnabled(true);
		eixtInfo.setEnabled(true);

		//����¼�����
		searchInfo.addActionListener(this);
		modifyInfo.addActionListener(this);
		clearInfo.addActionListener(this);
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
		else if (obj == modifyInfo) { //�޸�
			CrsBean modifyCrs = new CrsBean();
			modifyCrs.crsModify(cNum.getText(), cName.getText(), cTeacher.getText(), cPlace.getText(), cType.getText(), cTime.getText());
			modifyCrs.crsSearch(cNum.getText());
			s = modifyCrs.crsSearch(cNum_str);

			cName.setText(s[0]);
			cTeacher.setText(s[1]);
			cPlace.setText(s[2]);
			cType.setText(s[3]);
			cTime.setText(s[4]);
			
		}
		else if (obj == clearInfo) { //���
			setNull();
			cNum.setText("���ѯ�γ̺�");
		}
		else if (obj == searchInfo) { //�γ̺Ų�ѯ
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
				modifyInfo.setEnabled(false);
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
				modifyInfo.setEnabled(true);
			}
		}
	}
}