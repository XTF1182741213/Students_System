import java.awt.*;
import java.sql.*;
import java.awt.event.*;
import javax.swing.*;

/**
 * ѧ����Ϣ����ģ��
 * �޸�ѧ����Ϣ����
 */
public class EditStuInfo extends StuInfo {
	String sNum_str = "";
	public EditStuInfo() {
		this.setTitle("�޸�ѧ����Ϣ");
		this.setResizable(false);

		sNum.setEditable(false);
		sNum.setText("���ѯѧ��");
		sName.setEditable(false);
		sSex.setEditable(false);
		sSethnic.setEditable(false);
		sBirth.setEditable(false);
		sYear.setEditable(false);
		sMajor.setEditable(false);
		sCollege.setEditable(false);
		sHome.setEditable(false);

		//��������ʱ���ڵ�λ��
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		this.setLocation((screenSize.width - 400) / 2, 
			(screenSize.height - 300) / 2 + 45);
	}

	public void downInit(){
		searchInfo.setText("ѧ�Ų�ѯ");
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

		searchInfo.setEnabled(true);
		modifyInfo.setEnabled(false);
		clearInfo.setEnabled(true);
		eixtInfo.setEnabled(true);

		//����¼�����
		searchInfo.addActionListener(this);
		modifyInfo.addActionListener(this);
		clearInfo.addActionListener(this);
		eixtInfo.addActionListener(this);

		this.contentPane.add(downPanel,BorderLayout.SOUTH);
	}

	/**
	 * �¼�����
	 */
	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();
		String[] s = new String[8];

		if (obj == eixtInfo) { //�˳�
			this.dispose();
		}
		else if (obj == modifyInfo) { //�޸�
			StuBean modifyStu = new StuBean();
			modifyStu.stuModify(sNum.getText(), sName.getText(), sSex.getText(), sBirth.getText(), sHome.getText(), sSethnic.getText(), sYear.getText(), sMajor.getText(), sCollege.getText());
			modifyStu.stuSearch(sNum.getText());
			s = modifyStu.stuSearch(sNum_str);

			sName.setText(s[0]);
			sSex.setText(s[1]);
			sSethnic.setText(s[2]);
			sHome.setText(s[3]);
			sYear.setText(s[4]);
			sMajor.setText(s[5]);
			sCollege.setText(s[6]);
			sBirth.setText(s[7]);
		}
		else if (obj == clearInfo) { //���
			setNull();
			sNum.setText("���ѯѧ��");
		}
		else if (obj == searchInfo) { //ѧ�Ų�ѯ
			
			StuInfoSearchSnum siss = new StuInfoSearchSnum(this);
			siss.pack();
			siss.setVisible(true);
			try{
				sNum_str = siss.getSnum();
			}catch(Exception ex){
				JOptionPane.showMessageDialog(null, "û�в��ҵ���ѧ�ţ�"); 
			}
	
			StuBean searchStu = new StuBean();
			s = searchStu.stuSearch(sNum_str);
			if(s == null){
				JOptionPane.showMessageDialog(null, "��¼�����ڣ�");
				sNum.setText("���ѯѧ��");
				sName.setText("");
				sSex.setText("");
				sSethnic.setText("");
				sHome.setText("");
				sYear.setText("");
				sMajor.setText("");
				sCollege.setText("");
				sBirth.setText("");
				
				sName.setEditable(false);
				sSex.setEditable(false);
				sSethnic.setEditable(false);
				sBirth.setEditable(false);
				sYear.setEditable(false);
				sMajor.setEditable(false);
				sCollege.setEditable(false);
				sHome.setEditable(false);
				modifyInfo.setEnabled(false);
				return;
			}
			else{
				sNum.setText(sNum_str);
				sName.setText(s[0]);
				sSex.setText(s[1]);
				sSethnic.setText(s[2]);
				sHome.setText(s[3]);
				sYear.setText(s[4]);
				sMajor.setText(s[5]);
				sCollege.setText(s[6]);
				sBirth.setText(s[7]);

				sName.setEditable(true);
				sSex.setEditable(true);
				sSethnic.setEditable(true);
				sBirth.setEditable(true);
				sYear.setEditable(true);
				sMajor.setEditable(true);
				sCollege.setEditable(true);
				sHome.setEditable(true);
				modifyInfo.setEnabled(true);
			}
		}
	}
}