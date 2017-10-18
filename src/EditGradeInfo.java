import java.awt.*;
import java.sql.*;
import java.awt.event.*;
import javax.swing.*;

/**
 * �ɼ���Ϣ����ģ��
 * �޸ĳɼ���Ϣ����
 */
public class EditGradeInfo extends GradeInfo implements ActionListener{
	public EditGradeInfo() {
		this.setTitle("�޸ĳɼ���Ϣ");
		this.setResizable(false);

		//��������λ�ã�ʹ�Ի������
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		this.setLocation( (int) (screenSize.width - 400) / 2 ,
						(int) (screenSize.height - 300) / 2 +45);
	}

	public void downInit(){
		modifyInfo.setText("�޸�");
		modifyInfo.setFont(new Font("Dialog",0,12));
		downPanel.add(modifyInfo);
		eixtInfo.setText("�˳�");
		eixtInfo.setFont(new Font("Dialog",0,12));
		downPanel.add(eixtInfo);

		this.contentPane.add(downPanel,BorderLayout.SOUTH);

		sNum.addActionListener(this);
		modifyInfo.addActionListener(this);
		clearInfo.addActionListener(this);
		eixtInfo.addActionListener(this);
	}

	/**
	 * �¼�����
	 */
	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();
		
		if (obj == modifyInfo) { //�޸�
			cNum.setEnabled(false);
			cName.setEditable(false);
			cTeacher.setEditable(false);
			Grade.setEditable(false);
			sNum.setEditable(false);
			sName.setEditable(false);

			modifyInfo.setEnabled(false);
			clearInfo.setEnabled(false);
			eixtInfo.setEnabled(false);

			csBean addGrade = new csBean();
			addGrade.csModify(cNum.getText(),(String)sNum.getSelectedItem(),Grade.getText());

			this.dispose();
			EditGradeInfo egi = new EditGradeInfo();
			egi.downInit();
			egi.pack();
			egi.setVisible(true);
		}
		else if (obj == eixtInfo) { //�˳�
			this.dispose();
		}
		else if (obj == sNum) { //ѡ��ѧ��
			StuBean sN = new StuBean();
			sName.setText(sN.stuSearch((String)sNum.getSelectedItem())[0]);

			if(cName.getItemCount()>0){
				cName.removeAllItems();
			}
			
			csBean cN = new csBean();
			cReturn = cN.cNameSearch((String)sNum.getSelectedItem());
			
			if(cReturn == null){
				cName.removeActionListener(this);
				JOptionPane.showMessageDialog(null,"��ѧ��û��ѡ��γ̣�");
				modifyInfo.setEnabled(false);
				cName.setEnabled(false);
			}
			else{
				int i = 0;
				for(i = 0; i < (cReturn.length); i++){
					cName.addItem(cReturn[i]);
				}

				cName.setEnabled(true);
				sNum.setEnabled(false);
				cName.setSelectedItem(null);
				cName.addActionListener(this);
			}
		}
		else if (obj == cName) { //ѡ��γ̺�
			CrsBean cSname = new CrsBean();
			cNum.setText(cSname.crsNameSearch((String)cName.getSelectedItem(),(String)sNum.getSelectedItem())[0]);
			cTeacher.setText(cSname.crsNameSearch((String)cName.getSelectedItem(),(String)sNum.getSelectedItem())[1]);
			Grade.setText("");
			Grade.setText(cSname.crsNameSearch((String)cName.getSelectedItem(),(String)sNum.getSelectedItem())[5]);
			modifyInfo.setEnabled(true);
			
			cName.setEnabled(false);
		}
	}
}