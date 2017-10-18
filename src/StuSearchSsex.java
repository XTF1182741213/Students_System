import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.net.*;

/**
 * ѧ����Ϣ��ѯģ��
 * ����ѧ�����Ա��ѯѧ����Ϣ
 */
public class StuSearchSsex extends JFrame implements ActionListener{
	Container contentPane;
	String[] s = {"��","Ů"};
	//��ܵĴ�С
	Dimension faceSize = new Dimension(300, 100);
	JLabel jLabel1 = new JLabel();
	JComboBox selectSsex = new JComboBox(s);
	JButton searchInfo = new JButton();

	public StuSearchSsex() {
		//���ñ���
		this.setTitle("���Ա��ѯ");
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

		jLabel1.setText("��ѡ��ѧ���Ա�:");
		jLabel1.setFont(new Font("Dialog",0,12));
		contentPane.add(jLabel1);
		
		selectSsex.setEditable(false);
		selectSsex.setSelectedItem(null);
		selectSsex.setFont(new Font("Dialog",0,12));
		contentPane.add(selectSsex);

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
		if (obj == searchInfo) { //�˳�
			ResultStudent rS = new ResultStudent("ssex",(String)selectSsex.getSelectedItem());
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
