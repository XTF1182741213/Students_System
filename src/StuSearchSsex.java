import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.net.*;

/**
 * 学生信息查询模块
 * 根据学生的性别查询学生信息
 */
public class StuSearchSsex extends JFrame implements ActionListener{
	Container contentPane;
	String[] s = {"男","女"};
	//框架的大小
	Dimension faceSize = new Dimension(300, 100);
	JLabel jLabel1 = new JLabel();
	JComboBox selectSsex = new JComboBox(s);
	JButton searchInfo = new JButton();

	public StuSearchSsex() {
		//设置标题
		this.setTitle("按性别查询");
		this.setResizable(false);
		//设置程序图标
		this.setIconImage(getImage("icon.gif")); 

		try {
			Init();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		//设置运行位置，使对话框居中
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		this.setLocation( (int) (screenSize.width - 400) / 2 ,
						(int) (screenSize.height - 300) / 2 + 45);
	}
	
	private void Init() throws Exception {
		this.setSize(faceSize);
		contentPane = this.getContentPane();
		contentPane.setLayout(new FlowLayout());

		jLabel1.setText("请选择学生性别:");
		jLabel1.setFont(new Font("Dialog",0,12));
		contentPane.add(jLabel1);
		
		selectSsex.setEditable(false);
		selectSsex.setSelectedItem(null);
		selectSsex.setFont(new Font("Dialog",0,12));
		contentPane.add(selectSsex);

		searchInfo.setText("查询");
		searchInfo.setFont(new Font("Dialog",0,12));
		contentPane.add(searchInfo);

		searchInfo.addActionListener(this);
	}

	/**
	 * 事件处理
	 */
	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();
		if (obj == searchInfo) { //退出
			ResultStudent rS = new ResultStudent("ssex",(String)selectSsex.getSelectedItem());
			this.dispose();
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
