import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.net.*;

/**
 * ѧ������ϵͳ������
 */
public class StuMain extends JFrame implements ActionListener{
	//��ܵĴ�С
	Dimension faceSize = new Dimension(400, 300);
	//����ͼ��
	Image icon;

	//�����˵���
	JMenuBar mainMenu = new JMenuBar();
	//������ϵͳ�����˵���
	JMenu menuSystem=new JMenu();
	JMenuItem itemExit=new JMenuItem();
	//������ѧ�������˵���
	JMenu menuStu=new JMenu();
	JMenuItem itemAddS=new JMenuItem();
	JMenuItem itemEditS=new JMenuItem();
	JMenuItem itemDeleteS=new JMenuItem();
	JMenuItem itemSelectC=new JMenuItem();
	//�������γ̹����˵���
	JMenu menuCourse=new JMenu();
	JMenuItem itemAddC=new JMenuItem();
	JMenuItem itemEditC=new JMenuItem();
	JMenuItem itemDeleteC=new JMenuItem();
	//�������ɼ������˵���
	JMenu menuGrade=new JMenu();
	JMenuItem itemAddG=new JMenuItem();
	JMenuItem itemEditG=new JMenuItem();
	//��������Ϣ��ѯ���˵���
	JMenu menuSearch=new JMenu();

	JMenu itemSearchStu=new JMenu();//ѧ����ѯ
	JMenuItem itemSearchStuBySnum=new JMenuItem();
	JMenuItem itemSearchStuBySname=new JMenuItem();
	JMenuItem itemSearchStuBySsex=new JMenuItem();
	JMenuItem itemSearchStuByScollege=new JMenuItem();
	JMenuItem itemSearchStuBySmajor=new JMenuItem();

	JMenu itemSearchCor=new JMenu();//�γ̲�ѯ
	JMenuItem itemSearchStuByCname=new JMenuItem();
	JMenuItem itemSearchStuByCteacher=new JMenuItem();

	JMenu itemSearchGrd=new JMenu();//�ɼ���ѯ
	JMenuItem itemSearchMutGrd=new JMenuItem();

	//���ò�ͬ����Ա��Ϣ��ʾ���壬����ͬ����Ĳ�ѯ���ؽ����
	public static StuInfo stuInfo = new StuInfo();
	public static CourseInfo corInfo = new CourseInfo();
	public static GradeInfo grdInfo = new GradeInfo();

	/**
	 * �����ʼ������
	 */
	 public StuMain() {
		enableEvents(AWTEvent.WINDOW_EVENT_MASK);

		//��ӿ�ܵĹر��¼�����
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.pack();
		//���ÿ�ܵĴ�С
		this.setSize(faceSize);
		//���ñ���
		this.setTitle("ѧ������ϵͳ");
		//����ͼ��
		icon = getImage("icon.gif");
		this.setIconImage(icon); //���ó���ͼ��

		try {
			Init();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	/**
	 * �����ʼ������
	 */
	private void Init() throws Exception {
		Container contentPane = this.getContentPane();
		contentPane.setLayout(new BorderLayout());

		//��Ӳ˵���
		menuSystem.setText("ϵͳ����");
		menuSystem.setFont(new Font("Dialog", 0, 12));
		menuStu.setText("ѧ������");
		menuStu.setFont(new Font("Dialog", 0, 12));
		menuCourse.setText("�γ̹���") ;
		menuCourse.setFont(new Font("Dialog", 0, 12));
		menuGrade.setText("�ɼ�����");
		menuGrade.setFont(new Font("Dialog", 0, 12));
		menuSearch.setText("��Ϣ��ѯ");
		menuSearch.setFont(new Font("Dialog", 0, 12));

		//���ɡ�ϵͳ�����˵����ѡ��
		itemExit.setText("�˳�");
		itemExit.setFont(new Font("Dialog",0,12));
		//���ɡ�ѧ�������˵����ѡ��
		itemAddS.setText("����");
		itemAddS.setFont(new Font("Dialog",0,12));
		itemEditS.setText("�޸�");
		itemEditS.setFont(new Font("Dialog",0,12));
		itemDeleteS.setText("ɾ��");
		itemDeleteS.setFont(new Font("Dialog",0,12));
		itemSelectC.setText("ѧ��ѡ��");
		itemSelectC.setFont(new Font("Dialog",0,12));
		//���ɡ��γ̹����˵����ѡ��
		itemAddC.setText("�γ�����");
		itemAddC.setFont(new Font("Dialog",0,12));
		itemEditC.setText("�γ��޸�");
		itemEditC.setFont(new Font("Dialog",0,12));
		itemDeleteC.setText("�γ�ɾ��");
		itemDeleteC.setFont(new Font("Dialog",0,12));
		//���ɡ��ɼ������˵����ѡ��
		itemAddG.setText("�ɼ�����");
		itemAddG.setFont(new Font("Dialog",0,12));
		itemEditG.setText("�ɼ��޸�");
		itemEditG.setFont(new Font("Dialog",0,12));
		//���ɡ���Ϣ��ѯ���˵����ѡ��
		itemSearchStu.setText("ѧ����ѯ");
		itemSearchStu.setFont(new Font("Dialog",0,12));
		itemSearchStuBySnum.setText("��ѧ�Ų�ѯ");
		itemSearchStuBySnum.setFont(new Font("Dialog",0,12));
		itemSearchStuBySname.setText("��ѧ������ѯ");
		itemSearchStuBySname.setFont(new Font("Dialog",0,12));
		itemSearchStuBySsex.setText("���Ա��ѯ");
		itemSearchStuBySsex.setFont(new Font("Dialog",0,12));
		itemSearchStuByScollege.setText("��ѧԺ��ѯ");
		itemSearchStuByScollege.setFont(new Font("Dialog",0,12));
		itemSearchStuBySmajor.setText("��רҵ��ѯ");
		itemSearchStuBySmajor.setFont(new Font("Dialog",0,12));

		itemSearchCor.setText("�γ̲�ѯ");
		itemSearchCor.setFont(new Font("Dialog",0,12));
		itemSearchStuByCname.setText("���γ����Ʋ�ѯ");
		itemSearchStuByCname.setFont(new Font("Dialog",0,12));
		itemSearchStuByCteacher.setText("���ڿν�ʦ��ѯ");
		itemSearchStuByCteacher.setFont(new Font("Dialog",0,12));

		itemSearchGrd.setText("�ɼ���ѯ");
		itemSearchGrd.setFont(new Font("Dialog",0,12));
		itemSearchMutGrd.setText("��ѯ���п�Ŀ�ɼ�");
		itemSearchMutGrd.setFont(new Font("Dialog",0,12));

		//��ӡ�ϵͳ�����˵���
		menuSystem.add(itemExit);
		//��ӡ�ѧ�������˵���
		menuStu.add(itemAddS);
		menuStu.add(itemEditS);
		menuStu.add(itemDeleteS);
		menuStu.addSeparator();
		menuStu.add(itemSelectC);
		//��ӡ��γ̹����˵���
		menuCourse.add(itemAddC);
		menuCourse.add(itemEditC);
		menuCourse.add(itemDeleteC);
		//��ӡ��ɼ������˵���
		menuGrade.add(itemAddG);
		menuGrade.add(itemEditG);
		//��ӡ���Ϣ��ѯ���˵���
		menuSearch.add(itemSearchStu);
		itemSearchStu.add(itemSearchStuBySnum);
		itemSearchStu.add(itemSearchStuBySname);
		itemSearchStu.add(itemSearchStuBySsex);
		itemSearchStu.add(itemSearchStuByScollege);
		itemSearchStu.add(itemSearchStuBySmajor);

		menuSearch.add(itemSearchCor);
		itemSearchCor.add(itemSearchStuByCname);
		itemSearchCor.add(itemSearchStuByCteacher);

		menuSearch.add(itemSearchGrd);
		itemSearchGrd.add(itemSearchMutGrd);
		//������еĲ˵���
		mainMenu.add(menuSystem);
		mainMenu.add(menuStu);
		mainMenu.add(menuCourse);
		mainMenu.add(menuGrade);
		mainMenu.add(menuSearch);
		this.setJMenuBar(mainMenu);

		//����¼�����
		itemExit.addActionListener(this);
		itemAddS.addActionListener(this);
		itemEditS.addActionListener(this);
		itemDeleteS.addActionListener(this);
		itemSelectC.addActionListener(this);
		itemAddC.addActionListener(this);
		itemEditC.addActionListener(this);
		itemDeleteC.addActionListener(this);
		itemAddG.addActionListener(this);
		itemEditG.addActionListener(this);
		itemSearchStuBySnum.addActionListener(this);
		itemSearchStuBySname.addActionListener(this);
		itemSearchStuBySsex.addActionListener(this);
		itemSearchStuByScollege.addActionListener(this);
		itemSearchStuBySmajor.addActionListener(this);
		itemSearchStuByCname.addActionListener(this);
		itemSearchStuByCteacher.addActionListener(this);
		itemSearchMutGrd.addActionListener(this);

		//�رճ���ʱ�Ĳ���
		this.addWindowListener(
			new WindowAdapter(){
				public void windowClosing(WindowEvent e){
					System.exit(0);
				}
			}
		);
	}

	/**
	 * �¼�����
	 */
	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();
		if (obj == itemExit) { //�˳�
			System.exit(0);
		}
		else if (obj == itemAddS) { //ѧ����Ϣ����
			AddStuInfo asi = new AddStuInfo();
			asi.downInit();
			asi.pack();
			asi.setVisible(true);

		}
		else if (obj == itemEditS) { //ѧ����Ϣ�޸�
			EditStuInfo esi = new EditStuInfo();
			esi.downInit();
			esi.pack();
			esi.setVisible(true);
		}
		else if (obj == itemDeleteS) { //ѧ����Ϣɾ��
			DelStuInfo dsi = new DelStuInfo();
			dsi.downInit();
			dsi.pack();
			dsi.setVisible(true);
		}
		else if (obj == itemSelectC) { //ѧ��ѡ��
			SelectCourse sc = new SelectCourse();
			sc.downInit();
			sc.pack();
			sc.setVisible(true);
		}
		else if (obj == itemAddC) { //�γ�����
			AddCourseInfo aci = new AddCourseInfo();
			aci.downInit();
			aci.pack();
			aci.setVisible(true);
		}
		else if (obj == itemEditC) { //�γ��޸�
			EditCourseInfo eci = new EditCourseInfo();
			eci.downInit();
			eci.pack();
			eci.setVisible(true);
		}
		else if (obj == itemDeleteC) { //�γ�ɾ��
			DelCourseInfo dci = new DelCourseInfo();
			dci.downInit();
			dci.pack();
			dci.setVisible(true);
		}
		else if (obj == itemAddG) { //�ɼ�����
			AddGradeInfo agi = new AddGradeInfo();
			agi.downInit();
			agi.pack();
			agi.setVisible(true);
		}
		else if (obj == itemEditG) { //�ɼ��޸�
			EditGradeInfo egi = new EditGradeInfo();
			egi.downInit();
			egi.pack();
			egi.setVisible(true);
		}
		else if (obj == itemSearchStu) { //ѧ����ѯ
			stuInfo.downInit();
			stuInfo.pack();
			stuInfo.setVisible(true);
		}
		else if (obj == itemSearchCor) { //ѡ�β�ѯ
			corInfo.downInit();
			corInfo.pack();
			corInfo.setVisible(true);
		}
		else if (obj == itemSearchGrd) { //�ɼ���ѯ
			grdInfo.downInit();
			grdInfo.pack();
			grdInfo.setVisible(true);
		}
		//��ѯ���ܵ��¼�����
		else if (obj == itemSearchStuBySnum) { //��ѧ�Ų�ѯ
			StuSearchSnum ssSnum = new StuSearchSnum();
			ssSnum.pack();
			ssSnum.setVisible(true);
		}
		else if (obj == itemSearchStuBySname) { //��ѧ������ѯ
			StuSearchSname ssSname = new StuSearchSname();
			ssSname.pack();
			ssSname.setVisible(true);
		}
		else if (obj == itemSearchStuBySsex) { //���Ա��ѯ
			StuSearchSsex ssSsex = new StuSearchSsex();
			ssSsex.pack();
			ssSsex.setVisible(true);
		}
		else if (obj == itemSearchStuByScollege) { //��ѧԺ��ѯ
			StuSearchScollege ssScollege = new StuSearchScollege();
			ssScollege.pack();
			ssScollege.setVisible(true);
		}
		else if (obj == itemSearchStuBySmajor) { //��רҵ��ѯ
			StuSearchSmajor ssSmajor = new StuSearchSmajor();
			ssSmajor.pack();
			ssSmajor.setVisible(true);
		}
		else if (obj == itemSearchStuByCname) { //���γ�����ѯ�γ�
			CourseSearchCname csCname = new CourseSearchCname();
			csCname.pack();
			csCname.setVisible(true);
		}
		else if (obj == itemSearchStuByCteacher) { //���ڿν�ʦ��ѯ�γ�
			CourseSearchCteacher csCteacher = new CourseSearchCteacher();
			csCteacher.pack();
			csCteacher.setVisible(true);
		}
		else if (obj == itemSearchMutGrd) { //��ѯ���п�Ŀ�ɼ�
			GrdSearchAllGrade gsag = new GrdSearchAllGrade();
			gsag.pack();
			gsag.setVisible(true);
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

