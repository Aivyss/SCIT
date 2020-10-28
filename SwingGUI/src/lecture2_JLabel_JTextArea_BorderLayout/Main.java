package lecture2_JLabel_JTextArea_BorderLayout;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class Main {

	public static void main(String[] args) {
		JFrame frame = new JFrame();
		JPanel panel = new JPanel();
		JLabel label1 = new JLabel("label-1");
		JButton btn1 = new JButton("button-1");
		JTextArea textArea = new JTextArea(); // 여러 줄의 문자열
		
		// Frame settings
		frame.setVisible(true);
		frame.setPreferredSize(new Dimension(840, 840/12*9));
		frame.setSize(840, 840/12*9);
		frame.setResizable(true);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		// panel layout settings
		panel.setLayout(new BorderLayout());
		
		// 패널 레이아웃의 위쪽에 위치하도록 함
		panel.add(label1, BorderLayout.NORTH);
		// 패널 레이아웃의 왼쪽에 위치하도록 함
		panel.add(btn1, BorderLayout.WEST);
		// 패널 레이아웃의 중앙에 위치하도록 함
		panel.add(textArea, BorderLayout.CENTER);
		
		frame.add(panel);
	}
}