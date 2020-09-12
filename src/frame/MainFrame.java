package frame;
import java.awt.EventQueue;

import javax.swing.JFrame;

public class MainFrame {
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
				   JFrame frame = new ContentFrame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}
