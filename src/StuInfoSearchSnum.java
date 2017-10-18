import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 * ѧ����Ϣ����ģ��
 * ����ѧ�Ų�ѯѧ������Ϣ���Թ��������޸Ļ�ɾ��
 */
public class StuInfoSearchSnum extends JDialog implements ActionListener{
	Container contentPane;
	String[] s;
	//��ܵĴ�С
	Dimension faceSize = new Dimension(300, 100);
	JLabel jLabel1 = new JLabel();
	JComboBox selectSnum;
	JButton searchInfo = new JButton();

	
	public StuInfoSearchSnum(JFrame frame) {
		super(frame, true);
		this.setTitle("ѧ�Ų�ѯ");
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
						(int) (screenSize.height - 300) / 2 +45);

	}
	
	private void Init() throws Exception {
		this.setSize(faceSize);
		contentPane = this.getContentPane();
		contentPane.setLayout(new FlowLayout());

		jLabel1.setText("���������ѡ��ѧ��:");
		jLabel1.setFont(new Font("Dialog",0,12));
		contentPane.add(jLabel1);

		StuBean getId = new StuBean();
		s = getId.getAllId();

		selectSnum = new JComboBox(s);

		selectSnum.setEditable(true);
		selectSnum.setFont(new Font("Dialog",0,12));
		contentPane.add(selectSnum);

		searchInfo.setText("��ѯ");
		searchInfo.setFont(new Font("Dialog",0,12));
		contentPane.add(searchInfo);

		searchInfo.addActionListener(this);

	}

	/**
	 * �¼�����
	 */
	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();
		if (obj == selectSnum) { //�˳�
			this.dispose();
		}
		else if (obj == searchInfo) { //�޸�
			this.dispose();
		}
	}

	/**
	 * ����ѡ���ѧ��
	 */
	public String getSnum(){
		return (String)this.selectSnum.getSelectedItem();
	}
}
