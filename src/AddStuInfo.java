import java.awt.event.*;
import java.awt.*;
import javax.swing.*;

/**
 * ѧ����Ϣ����ģ��
 * ����µ�ѧ����Ϣ
 */
public class AddStuInfo extends StuInfo {
	StuBean getSnum = new StuBean();
	public AddStuInfo() {
		this.setTitle("���ѧ����Ϣ");
		this.setResizable(false);
		sNum.setEditable(false);
		sNum.setText(""+getSnum.getStuId());
		
		sName.setEditable(true);
		sSex.setEditable(true);
		sSethnic.setEditable(true);
		sBirth.setEditable(true);
		sYear.setEditable(true);
		sMajor.setEditable(true);
		sCollege.setEditable(true);
		sHome.setEditable(true);

		//��������ʱ���ڵ�λ��
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		this.setLocation((screenSize.width - 400) / 2, 
			(screenSize.height - 300) / 2 + 45);
	}

	public void downInit(){
		addInfo.setText("����");
		addInfo.setFont(new Font("Dialog",0,12));
		downPanel.add(addInfo);
		clearInfo.setText("���");
		clearInfo.setFont(new Font("Dialog",0,12));
		downPanel.add(clearInfo);
		eixtInfo.setText("�˳�");
		eixtInfo.setFont(new Font("Dialog",0,12));
		downPanel.add(eixtInfo);

		//����¼�����
		addInfo.addActionListener(this);
		clearInfo.addActionListener(this);
		eixtInfo.addActionListener(this);

		this.contentPane.add(downPanel,BorderLayout.SOUTH);
	}

	/**
	 * �¼�����
	 */
	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();
		if (obj == eixtInfo) { //�˳�
			this.dispose();
		}
		else if (obj == addInfo) { //����

			sNum.setEnabled(false);
			sName.setEnabled(false);
			sSex.setEnabled(false);
			sSethnic.setEnabled(false);
			sBirth.setEnabled(false);
			sYear.setEnabled(false);
			sMajor.setEnabled(false);
			sCollege.setEnabled(false);
			sHome.setEnabled(false);

			addInfo.setEnabled(false);
			clearInfo.setEnabled(false);
			eixtInfo.setEnabled(false);

			StuBean addStu = new StuBean();
			addStu.stuAdd(sName.getText(), sSex.getText(), sBirth.getText(), sHome.getText(), sSethnic.getText(), sYear.getText(), sMajor.getText(), sCollege.getText());
			
			this.dispose();

			AddStuInfo asi = new AddStuInfo();
			asi.downInit();
			asi.pack();
			asi.setVisible(true);
		}
		else if (obj == clearInfo) { //���
			setNull();
			sNum.setText(""+getSnum.getStuId());
		}
	}
}