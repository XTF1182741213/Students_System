import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.net.*;

/**
 * 学生管理系统主界面
 */
public class StuMain extends JFrame implements ActionListener{
	//框架的大小
	Dimension faceSize = new Dimension(400, 300);
	//程序图标
	Image icon;

	//建立菜单栏
	JMenuBar mainMenu = new JMenuBar();
	//建立“系统管理”菜单组
	JMenu menuSystem=new JMenu();
	JMenuItem itemExit=new JMenuItem();
	//建立“学生管理”菜单组
	JMenu menuStu=new JMenu();
	JMenuItem itemAddS=new JMenuItem();
	JMenuItem itemEditS=new JMenuItem();
	JMenuItem itemDeleteS=new JMenuItem();
	JMenuItem itemSelectC=new JMenuItem();
	//建立“课程管理”菜单组
	JMenu menuCourse=new JMenu();
	JMenuItem itemAddC=new JMenuItem();
	JMenuItem itemEditC=new JMenuItem();
	JMenuItem itemDeleteC=new JMenuItem();
	//建立“成绩管理”菜单组
	JMenu menuGrade=new JMenu();
	JMenuItem itemAddG=new JMenuItem();
	JMenuItem itemEditG=new JMenuItem();
	//建立“信息查询”菜单组
	JMenu menuSearch=new JMenu();

	JMenu itemSearchStu=new JMenu();//学生查询
	JMenuItem itemSearchStuBySnum=new JMenuItem();
	JMenuItem itemSearchStuBySname=new JMenuItem();
	JMenuItem itemSearchStuBySsex=new JMenuItem();
	JMenuItem itemSearchStuByScollege=new JMenuItem();
	JMenuItem itemSearchStuBySmajor=new JMenuItem();

	JMenu itemSearchCor=new JMenu();//课程查询
	JMenuItem itemSearchStuByCname=new JMenuItem();
	JMenuItem itemSearchStuByCteacher=new JMenuItem();

	JMenu itemSearchGrd=new JMenu();//成绩查询
	JMenuItem itemSearchMutGrd=new JMenuItem();

	//设置不同的人员信息显示窗体，供不同窗体的查询返回结果用
	public static StuInfo stuInfo = new StuInfo();
	public static CourseInfo corInfo = new CourseInfo();
	public static GradeInfo grdInfo = new GradeInfo();

	/**
	 * 程序初始化函数
	 */
	 public StuMain() {
		enableEvents(AWTEvent.WINDOW_EVENT_MASK);

		//添加框架的关闭事件处理
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.pack();
		//设置框架的大小
		this.setSize(faceSize);
		//设置标题
		this.setTitle("学生管理系统");
		//程序图标
		icon = getImage("icon.gif");
		this.setIconImage(icon); //设置程序图标

		try {
			Init();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	/**
	 * 程序初始化函数
	 */
	private void Init() throws Exception {
		Container contentPane = this.getContentPane();
		contentPane.setLayout(new BorderLayout());

		//添加菜单组
		menuSystem.setText("系统管理");
		menuSystem.setFont(new Font("Dialog", 0, 12));
		menuStu.setText("学生管理");
		menuStu.setFont(new Font("Dialog", 0, 12));
		menuCourse.setText("课程管理") ;
		menuCourse.setFont(new Font("Dialog", 0, 12));
		menuGrade.setText("成绩管理");
		menuGrade.setFont(new Font("Dialog", 0, 12));
		menuSearch.setText("信息查询");
		menuSearch.setFont(new Font("Dialog", 0, 12));

		//生成“系统管理”菜单组的选项
		itemExit.setText("退出");
		itemExit.setFont(new Font("Dialog",0,12));
		//生成“学生管理”菜单组的选项
		itemAddS.setText("增加");
		itemAddS.setFont(new Font("Dialog",0,12));
		itemEditS.setText("修改");
		itemEditS.setFont(new Font("Dialog",0,12));
		itemDeleteS.setText("删除");
		itemDeleteS.setFont(new Font("Dialog",0,12));
		itemSelectC.setText("学生选课");
		itemSelectC.setFont(new Font("Dialog",0,12));
		//生成“课程管理”菜单组的选项
		itemAddC.setText("课程增加");
		itemAddC.setFont(new Font("Dialog",0,12));
		itemEditC.setText("课程修改");
		itemEditC.setFont(new Font("Dialog",0,12));
		itemDeleteC.setText("课程删除");
		itemDeleteC.setFont(new Font("Dialog",0,12));
		//生成“成绩管理”菜单组的选项
		itemAddG.setText("成绩增加");
		itemAddG.setFont(new Font("Dialog",0,12));
		itemEditG.setText("成绩修改");
		itemEditG.setFont(new Font("Dialog",0,12));
		//生成“信息查询”菜单组的选项
		itemSearchStu.setText("学生查询");
		itemSearchStu.setFont(new Font("Dialog",0,12));
		itemSearchStuBySnum.setText("按学号查询");
		itemSearchStuBySnum.setFont(new Font("Dialog",0,12));
		itemSearchStuBySname.setText("按学姓名查询");
		itemSearchStuBySname.setFont(new Font("Dialog",0,12));
		itemSearchStuBySsex.setText("按性别查询");
		itemSearchStuBySsex.setFont(new Font("Dialog",0,12));
		itemSearchStuByScollege.setText("按学院查询");
		itemSearchStuByScollege.setFont(new Font("Dialog",0,12));
		itemSearchStuBySmajor.setText("按专业查询");
		itemSearchStuBySmajor.setFont(new Font("Dialog",0,12));

		itemSearchCor.setText("课程查询");
		itemSearchCor.setFont(new Font("Dialog",0,12));
		itemSearchStuByCname.setText("按课程名称查询");
		itemSearchStuByCname.setFont(new Font("Dialog",0,12));
		itemSearchStuByCteacher.setText("按授课教师查询");
		itemSearchStuByCteacher.setFont(new Font("Dialog",0,12));

		itemSearchGrd.setText("成绩查询");
		itemSearchGrd.setFont(new Font("Dialog",0,12));
		itemSearchMutGrd.setText("查询所有科目成绩");
		itemSearchMutGrd.setFont(new Font("Dialog",0,12));

		//添加“系统管理”菜单组
		menuSystem.add(itemExit);
		//添加“学生管理”菜单组
		menuStu.add(itemAddS);
		menuStu.add(itemEditS);
		menuStu.add(itemDeleteS);
		menuStu.addSeparator();
		menuStu.add(itemSelectC);
		//添加“课程管理”菜单组
		menuCourse.add(itemAddC);
		menuCourse.add(itemEditC);
		menuCourse.add(itemDeleteC);
		//添加“成绩管理”菜单组
		menuGrade.add(itemAddG);
		menuGrade.add(itemEditG);
		//添加“信息查询”菜单组
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
		//添加所有的菜单组
		mainMenu.add(menuSystem);
		mainMenu.add(menuStu);
		mainMenu.add(menuCourse);
		mainMenu.add(menuGrade);
		mainMenu.add(menuSearch);
		this.setJMenuBar(mainMenu);

		//添加事件侦听
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

		//关闭程序时的操作
		this.addWindowListener(
			new WindowAdapter(){
				public void windowClosing(WindowEvent e){
					System.exit(0);
				}
			}
		);
	}

	/**
	 * 事件处理
	 */
	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();
		if (obj == itemExit) { //退出
			System.exit(0);
		}
		else if (obj == itemAddS) { //学生信息增加
			AddStuInfo asi = new AddStuInfo();
			asi.downInit();
			asi.pack();
			asi.setVisible(true);

		}
		else if (obj == itemEditS) { //学生信息修改
			EditStuInfo esi = new EditStuInfo();
			esi.downInit();
			esi.pack();
			esi.setVisible(true);
		}
		else if (obj == itemDeleteS) { //学生信息删出
			DelStuInfo dsi = new DelStuInfo();
			dsi.downInit();
			dsi.pack();
			dsi.setVisible(true);
		}
		else if (obj == itemSelectC) { //学生选课
			SelectCourse sc = new SelectCourse();
			sc.downInit();
			sc.pack();
			sc.setVisible(true);
		}
		else if (obj == itemAddC) { //课程增加
			AddCourseInfo aci = new AddCourseInfo();
			aci.downInit();
			aci.pack();
			aci.setVisible(true);
		}
		else if (obj == itemEditC) { //课程修改
			EditCourseInfo eci = new EditCourseInfo();
			eci.downInit();
			eci.pack();
			eci.setVisible(true);
		}
		else if (obj == itemDeleteC) { //课程删除
			DelCourseInfo dci = new DelCourseInfo();
			dci.downInit();
			dci.pack();
			dci.setVisible(true);
		}
		else if (obj == itemAddG) { //成绩增加
			AddGradeInfo agi = new AddGradeInfo();
			agi.downInit();
			agi.pack();
			agi.setVisible(true);
		}
		else if (obj == itemEditG) { //成绩修改
			EditGradeInfo egi = new EditGradeInfo();
			egi.downInit();
			egi.pack();
			egi.setVisible(true);
		}
		else if (obj == itemSearchStu) { //学生查询
			stuInfo.downInit();
			stuInfo.pack();
			stuInfo.setVisible(true);
		}
		else if (obj == itemSearchCor) { //选课查询
			corInfo.downInit();
			corInfo.pack();
			corInfo.setVisible(true);
		}
		else if (obj == itemSearchGrd) { //成绩查询
			grdInfo.downInit();
			grdInfo.pack();
			grdInfo.setVisible(true);
		}
		//查询功能的事件处理
		else if (obj == itemSearchStuBySnum) { //按学号查询
			StuSearchSnum ssSnum = new StuSearchSnum();
			ssSnum.pack();
			ssSnum.setVisible(true);
		}
		else if (obj == itemSearchStuBySname) { //按学姓名查询
			StuSearchSname ssSname = new StuSearchSname();
			ssSname.pack();
			ssSname.setVisible(true);
		}
		else if (obj == itemSearchStuBySsex) { //按性别查询
			StuSearchSsex ssSsex = new StuSearchSsex();
			ssSsex.pack();
			ssSsex.setVisible(true);
		}
		else if (obj == itemSearchStuByScollege) { //按学院查询
			StuSearchScollege ssScollege = new StuSearchScollege();
			ssScollege.pack();
			ssScollege.setVisible(true);
		}
		else if (obj == itemSearchStuBySmajor) { //按专业查询
			StuSearchSmajor ssSmajor = new StuSearchSmajor();
			ssSmajor.pack();
			ssSmajor.setVisible(true);
		}
		else if (obj == itemSearchStuByCname) { //按课程名查询课程
			CourseSearchCname csCname = new CourseSearchCname();
			csCname.pack();
			csCname.setVisible(true);
		}
		else if (obj == itemSearchStuByCteacher) { //按授课教师查询课程
			CourseSearchCteacher csCteacher = new CourseSearchCteacher();
			csCteacher.pack();
			csCteacher.setVisible(true);
		}
		else if (obj == itemSearchMutGrd) { //查询所有科目成绩
			GrdSearchAllGrade gsag = new GrdSearchAllGrade();
			gsag.pack();
			gsag.setVisible(true);
		}
	}

	/**
	 * 通过给定的文件名获得图像
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

