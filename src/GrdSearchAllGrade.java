import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.net.*;

/**
 * �ɼ���Ϣ��ѯģ��
 * ��ѯĳѧ�����п�Ŀ�ĳɼ�
 */
public class GrdSearchAllGrade extends JFrame implements ActionListener{
	Container contentPane;
	//��ܵĴ�С
	Dimension faceSize = new Dimension(300, 100);
	String[] stu ;
	JLabel jLabel1 = new JLabel();
	JComboBox sNum;
	JButton searchInfo = new JButton();
	
	public GrdSearchAllGrade() {
		//���ñ���
		this.setTitle("���гɼ���ѯ");
		this.setResizable(false);
		//���ó���ͼ��
		this.setIconImage(getImage("icon.gif")); 
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

		jLabel1.setText("��ѡ��ѧ�� ��");
		jLabel1.setFont(new Font("Dialog",0,12));
		contentPane.add(jLabel1);

		StuBean sN = new StuBean();
		stu = sN.getAllId();
		sNum = new JComboBox(stu);
		sNum.setSelectedItem(null);
		sNum.setFont(new Font("Dialog",0,12));
		contentPane.add(sNum);

		searchInfo.setText("ȷ��");
		searchInfo.setFont(new Font("Dialog",0,12));
		contentPane.add(searchInfo);

		searchInfo.addActionListener(this);
	}

	/**
	 * �¼�����
	 */
	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();
		if (obj == searchInfo) { //��ѯ
			ResultGrade rG = new ResultGrade((String)sNum.getSelectedItem());
			this.dispose();
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
