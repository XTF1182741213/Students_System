import java.awt.event.*;
import java.awt.*;
import javax.swing.*;

/**
 * �γ���Ϣ����ģ��
 * ����µĿγ���Ϣ
 */
public class AddCourseInfo extends CourseInfo{

	CrsBean getCnum = new CrsBean();

	public AddCourseInfo() {
		this.setTitle("��ӿγ���Ϣ");
		this.setResizable(false);

		cNum.setEditable(false);
		cNum.setText(""+getCnum.getCrsId());
		cName.setEditable(true);
		cTeacher.setEditable(true);
		cType.setEditable(true);
		cTime.setEditable(true);
		cPlace.setEditable(true);

		//��������λ�ã�ʹ�Ի������
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		this.setLocation( (int) (screenSize.width - 400) / 2 ,
						(int) (screenSize.height - 300) / 2 +45);
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

		this.contentPane.add(downPanel,BorderLayout.SOUTH);

		//����¼�����
		addInfo.addActionListener(this);
		clearInfo.addActionListener(this);
		eixtInfo.addActionListener(this);
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
			cNum.setEnabled(false);
			cName.setEditable(false);
			cTeacher.setEditable(false);
			cType.setEditable(false);
			cTime.setEditable(false);
			cPlace.setEditable(false);

			addInfo.setEnabled(false);
			clearInfo.setEnabled(false);
			eixtInfo.setEnabled(false);

			CrsBean addCrs = new CrsBean();
			addCrs.crsAdd(cName.getText(), cTeacher.getText(), cPlace.getText(), cType.getText(), cTime.getText());
			
			this.dispose();

			AddCourseInfo aci = new AddCourseInfo();
			aci.downInit();
			aci.pack();
			aci.setVisible(true);

			this.dispose();
		}
		else if (obj == clearInfo) { //���
			setNull();
			cNum.setText(""+getCnum.getCrsId());
		}
	}
}