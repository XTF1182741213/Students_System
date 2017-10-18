import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 * �γ���Ϣ����ģ��
 * ���ݿγ̱�Ų�ѯ�γ���Ϣ���Թ��������޸Ļ�ɾ��
 */
public class CourseInfoSearchCnum extends JDialog implements ActionListener{
	Container contentPane;
	String[] s;
	//��ܵĴ�С
	Dimension faceSize = new Dimension(300, 100);
	JLabel jLabel1 = new JLabel();
	JComboBox selectCnum;
	JButton searchInfo = new JButton();
	
	public CourseInfoSearchCnum(JFrame frame) {
		super(frame, true);
		this.setResizable(false);
		try {
			Init();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		//��������λ�ã�ʹ�Ի������
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		this.setLocation( (int) (screenSize.width - 400) / 2 ,
						(int) (screenSize.height - 300) / 2 + 45);
	}
	
	private void Init() throws Exception {
		this.setSize(faceSize);
		contentPane = this.getContentPane();
		contentPane.setLayout(new FlowLayout());

		jLabel1.setText("���������ѡ��γ̺�:");
		jLabel1.setFont(new Font("Dialog",0,12));
		contentPane.add(jLabel1);
		
		CrsBean getId = new CrsBean();
		s = getId.getAllId();

		selectCnum = new JComboBox(s);
		selectCnum.setSelectedItem(null);
		selectCnum.setEditable(true);
		selectCnum.setFont(new Font("Dialog",0,12));
		contentPane.add(selectCnum);

		searchInfo.setText("��ѯ");
		searchInfo.setFont(new Font("Dialog",0,12));
		contentPane.add(searchInfo);

		selectCnum.addActionListener(this);
		searchInfo.addActionListener(this);
	}

	/**
	 * �¼�����
	 */
	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();
		if (obj == selectCnum) { //�˳�
			this.dispose();
		}
		else if (obj == searchInfo) { //�޸�
			this.dispose();
		}
	}

	/**
	 * ����ѡ���ѧ��
	 */
	public String getCnum(){
		return (String)this.selectCnum.getSelectedItem();
	}
}
