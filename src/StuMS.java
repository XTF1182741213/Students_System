import javax.swing.UIManager;
import java.awt.*;

/**
 * ѧ������ϵͳ��������
 */
public class StuMS {
	boolean packFrame = false;

	/**
	 * ���캯��
	 */
	public StuMS() {
		StuMain frame = new StuMain();

		if (packFrame) {
			frame.pack();
		}
		else {
			frame.validate();
		}

		//��������ʱ���ڵ�λ��
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		Dimension frameSize = frame.getSize();
		if (frameSize.height > screenSize.height) {
			frameSize.height = screenSize.height;
		}
		if (frameSize.width > screenSize.width) {
			frameSize.width = screenSize.width;
		}
		frame.setLocation((screenSize.width - frameSize.width) / 2, (screenSize.height - frameSize.height) / 2);
		frame.setVisible(true);
	}

	public static void main(String[] args) {
		//�������з��
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		}
		catch(Exception e) {
			e.printStackTrace();
		}

		new StuMS();
	}
}