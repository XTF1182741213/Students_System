import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.net.*;

/**
 * �γ���Ϣ�ۺϹ�����
 * �ṩ�����棬��������̳�
 */
public class CourseInfo extends JFrame implements ActionListener{
	Container contentPane;
	JPanel centerPanel = new JPanel();
	JPanel upPanel = new JPanel();
	JPanel downPanel = new JPanel();

	//��ܵĴ�С
	Dimension faceSize = new Dimension(800, 500);

	JLabel jLabel1 = new JLabel();
	JLabel jLabel2 = new JLabel();
	JLabel jLabel3 = new JLabel();
	JLabel jLabel4 = new JLabel();
	JLabel jLabel5 = new JLabel();
	JLabel jLabel6 = new JLabel();

	JTextField cNum = new JTextField(15);
	JTextField cName = new JTextField(15);
	JTextField cTeacher = new JTextField(15);
	JTextField cType = new JTextField(15);
	JTextField cTime = new JTextField(15);
	JTextField cPlace = new JTextField(15);

	JButton searchInfo = new JButton();
	JButton addInfo = new JButton();
	JButton modifyInfo = new JButton();
	JButton deleteInfo = new JButton();
	JButton clearInfo = new JButton();
	JButton saveInfo = new JButton();
	JButton eixtInfo = new JButton();

	GridBagLayout girdBag = new GridBagLayout();
	GridBagConstraints girdBagCon;
	public CourseInfo() {this.setSize(faceSize);
		//���ñ���
		this.setTitle("�γ��ۺ���Ϣ����"); 
		this.setResizable(false);
		//���ó���ͼ��
		this.setIconImage(getImage("icon.gif"));
		try	{
			Init();
		}
		catch(Exception	e) {
			e.printStackTrace();
		}
	}

	public void Init() throws Exception {
		contentPane = this.getContentPane();
		contentPane.setLayout(new BorderLayout());

		//�в����Ĳ���
		centerPanel.setLayout(girdBag);

		jLabel1.setText("�γ̱��룺");
		jLabel1.setFont(new Font("Dialog",0,12));
		girdBagCon = new GridBagConstraints();
		girdBagCon.gridx = 0;
		girdBagCon.gridy = 0;
		girdBagCon.insets = new Insets(10,10,10,1);
		girdBag.setConstraints(jLabel1,girdBagCon);
		centerPanel.add(jLabel1);

		girdBagCon = new GridBagConstraints();
		girdBagCon.gridx = 1;
		girdBagCon.gridy = 0;
		girdBagCon.insets = new Insets(10,1,10,15);
		girdBag.setConstraints(cNum,girdBagCon);
		centerPanel.add(cNum);

		jLabel2.setText("�γ����ƣ�");
		jLabel2.setFont(new Font("Dialog",0,12));
		girdBagCon = new GridBagConstraints();
		girdBagCon.gridx = 2;
		girdBagCon.gridy = 0;
		girdBagCon.insets = new Insets(10,15,10,1);
		girdBag.setConstraints(jLabel2,girdBagCon);
		centerPanel.add(jLabel2);

		girdBagCon = new GridBagConstraints();
		girdBagCon.gridx = 3;
		girdBagCon.gridy = 0;
		girdBagCon.insets = new Insets(10,1,10,10);
		girdBag.setConstraints(cName,girdBagCon);
		centerPanel.add(cName);

		jLabel3.setText("�ڿ���ʦ��");
		jLabel3.setFont(new Font("Dialog",0,12));
		girdBagCon = new GridBagConstraints();
		girdBagCon.gridx = 0;
		girdBagCon.gridy = 1;
		girdBagCon.insets = new Insets(10,10,10,1);
		girdBag.setConstraints(jLabel3,girdBagCon);
		centerPanel.add(jLabel3);

		girdBagCon = new GridBagConstraints();
		girdBagCon.gridx = 1;
		girdBagCon.gridy = 1;
		girdBagCon.insets = new Insets(10,1,10,15);
		girdBag.setConstraints(cTeacher,girdBagCon);
		centerPanel.add(cTeacher);

		jLabel4.setText("�γ����");
		jLabel4.setFont(new Font("Dialog",0,12));
		girdBagCon = new GridBagConstraints();
		girdBagCon.gridx = 2;
		girdBagCon.gridy = 1;
		girdBagCon.insets = new Insets(10,15,10,1);
		girdBag.setConstraints(jLabel4,girdBagCon);
		centerPanel.add(jLabel4);

		girdBagCon = new GridBagConstraints();
		girdBagCon.gridx = 3;
		girdBagCon.gridy = 1;
		girdBagCon.insets = new Insets(10,1,10,10);
		girdBag.setConstraints(cType,girdBagCon);
		centerPanel.add(cType);

		jLabel5.setText("�Ͽ�ʱ�䣺");
		jLabel5.setFont(new Font("Dialog",0,12));
		girdBagCon = new GridBagConstraints();
		girdBagCon.gridx = 0;
		girdBagCon.gridy = 2;
		girdBagCon.insets = new Insets(10,10,10,1);
		girdBag.setConstraints(jLabel5,girdBagCon);
		centerPanel.add(jLabel5);

		girdBagCon = new GridBagConstraints();
		girdBagCon.gridx = 1;
		girdBagCon.gridy = 2;
		girdBagCon.insets = new Insets(10,1,10,15);
		girdBag.setConstraints(cTime,girdBagCon);
		centerPanel.add(cTime);

		jLabel6.setText("�Ͽεص㣺");
		jLabel6.setFont(new Font("Dialog",0,12));
		girdBagCon = new GridBagConstraints();
		girdBagCon.gridx = 2;
		girdBagCon.gridy = 2;
		girdBagCon.insets = new Insets(10,15,10,1);
		girdBag.setConstraints(jLabel6,girdBagCon);
		centerPanel.add(jLabel6);

		girdBagCon = new GridBagConstraints();
		girdBagCon.gridx = 3;
		girdBagCon.insets = new Insets(10,1,10,10);
		girdBag.setConstraints(cPlace,girdBagCon);
		centerPanel.add(cPlace);

		contentPane.add(centerPanel,BorderLayout.CENTER);
	}

	/**
	 * �²����Ĳ���
	 */
	public void downInit(){
		searchInfo.setText("��ѯ");
		searchInfo.setFont(new Font("Dialog",0,12));
		downPanel.add(searchInfo);
		addInfo.setText("����");
		addInfo.setFont(new Font("Dialog",0,12));
		downPanel.add(addInfo);
		modifyInfo.setText("�޸�");
		modifyInfo.setFont(new Font("Dialog",0,12));
		downPanel.add(modifyInfo);
		deleteInfo.setText("ɾ��");
		deleteInfo.setFont(new Font("Dialog",0,12));
		downPanel.add(deleteInfo);
		saveInfo.setText("����");
		saveInfo.setFont(new Font("Dialog",0,12));
		downPanel.add(saveInfo);
		clearInfo.setText("���");
		clearInfo.setFont(new Font("Dialog",0,12));
		downPanel.add(clearInfo);
		eixtInfo.setText("�˳�");
		eixtInfo.setFont(new Font("Dialog",0,12));
		downPanel.add(eixtInfo);

		contentPane.add(downPanel,BorderLayout.SOUTH);

		//����¼�����
		searchInfo.addActionListener(this);
		addInfo.addActionListener(this);
		modifyInfo.addActionListener(this);
		deleteInfo.addActionListener(this);
		saveInfo.addActionListener(this);
		clearInfo.addActionListener(this);
		eixtInfo.addActionListener(this);
	}

	/**
	 * �¼�����
	 */
	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();
		if (obj == searchInfo) { //��ѯ
		}
		else if (obj == addInfo) { //����
		}
		else if (obj == modifyInfo) { //�޸�
		}
		else if (obj == deleteInfo) { //ɾ��
		}
		else if (obj == saveInfo) { //����	
		}
		else if (obj == clearInfo) { //���
		}
		else if (obj == eixtInfo) { //�˳�
			this.dispose();
		}
	}

	/**
	 * ���ı������
	 */
	void setNull(){
		cNum.setText(null);
		cName.setText(null);
		cTeacher.setText(null);
		cType.setText(null);
		cTime.setText(null);
		cPlace.setText(null);
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
