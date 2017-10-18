import java.awt.*;
import java.sql.*;
import java.awt.event.*;
import javax.swing.*;

/**
 * ѧ����Ϣ����ģ��
 * ɾ��ѧ����Ϣ����
 */
public class DelStuInfo extends StuInfo{
	String sNum_str = "";

	public DelStuInfo() {
		this.setTitle("ɾ��ѧ����Ϣ");
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
		deleteInfo.setText("ɾ��");
		deleteInfo.setFont(new Font("Dialog",0,12));
		downPanel.add(deleteInfo);
		eixtInfo.setText("�˳�");
		eixtInfo.setFont(new Font("Dialog",0,12));
		downPanel.add(eixtInfo);

		searchInfo.setEnabled(true);
		deleteInfo.setEnabled(false);
		eixtInfo.setEnabled(true);

		//����¼�����
		searchInfo.addActionListener(this);
		deleteInfo.addActionListener(this);
		eixtInfo.addActionListener(this);

		contentPane.add(downPanel,BorderLayout.SOUTH);
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
		else if (obj == deleteInfo) { //ɾ��
			int ifdel = JOptionPane.showConfirmDialog(null,"���Ҫɾ������Ϣ��","��ʾ��Ϣ",JOptionPane.YES_NO_OPTION,JOptionPane.INFORMATION_MESSAGE );
			if(ifdel == JOptionPane.YES_OPTION){
				StuBean delStu = new StuBean();
				delStu.stuDel(sNum.getText());
				
				this.dispose();

				DelStuInfo dsi = new DelStuInfo();
				dsi.downInit();
				dsi.pack();
				dsi.setVisible(true);
			}
			else{
				return;
			}
		}
		else if (obj == searchInfo) { //ѧ�Ų�ѯ
			StuInfoSearchSnum siss = new StuInfoSearchSnum(this);
			siss.pack();
			siss.setVisible(true);
			sNum_str = siss.getSnum();
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
				deleteInfo.setEnabled(false);
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
				deleteInfo.setEnabled(true);
			}
			
		}
	}
}