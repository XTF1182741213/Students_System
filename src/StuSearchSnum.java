import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.net.*;

/**
 * ѧ����Ϣ��ѯģ��
 * ����ѧ����ѧ�Ų�ѯѧ����Ϣ
 */
public class StuSearchSnum extends JFrame implements ActionListener{
	Container contentPane;
	//��ܵĴ�С
	Dimension faceSize = new Dimension(300, 100);
	JLabel jLabel1 = new JLabel();
	JLabel jLabel2 = new JLabel();
	JTextField sFrom = new JTextField(4);
	JTextField sTo = new JTextField(4);
	JButton searchInfo = new JButton();
	
	public StuSearchSnum() {
		//���ñ���
		this.setTitle("��ѧ�Ų�ѯ");
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

		jLabel1.setText("������ѧ�ŷ�Χ: ��");
		jLabel1.setFont(new Font("Dialog",0,12));
		contentPane.add(jLabel1);

		sFrom.setText(null);
		sFrom.setFont(new Font("Dialog",0,12));
		contentPane.add(sFrom);

		jLabel2.setText(" �� ");
		jLabel2.setFont(new Font("Dialog",0,12));
		contentPane.add(jLabel2);

		sTo.setText(null);
		sTo.setFont(new Font("Dialog",0,12));
		contentPane.add(sTo);

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
			ResultStudent rS = new ResultStudent("snum",sFrom.getText(),sTo.getText());
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
