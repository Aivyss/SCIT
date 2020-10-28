import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class Main {

	public static void main(String[] args) {
		JFrame frame = new JFrame();
		frame.setVisible(true);
		frame.setResizable(true);
		frame.setPreferredSize(new Dimension(840, 840/12*9));
		frame.setSize(840, 840/12*9);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel panel1 = new JPanel();
		JPanel btnPanel = new JPanel();
		
		JTextArea txtArea = new JTextArea();
		JLabel label = new JLabel("라벨란입니다.");

		JButton btn1 = new JButton("앵무새");
		btn1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				txtArea.append("마시쪙" + "\n");
				
			}
		});
		JButton btn2 = new JButton("카운터버튼");
		btn2.addActionListener(new ActionListener() {
			int count = 0;
			
			@Override
			public void actionPerformed(ActionEvent e) {
				++count;
				txtArea.append(Integer.toString(count)+"\n");
			}
		});
		JButton btn3 = new JButton("종료 버튼");
		btn3.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		
		
		panel1.setLayout(new BorderLayout());
		// btnPanel.setLayout(new BorderLayout());

		btnPanel.add(btn1);
		btnPanel.add(btn2);
		btnPanel.add(btn3);
		
		panel1.add(label, BorderLayout.NORTH);
		panel1.add(btnPanel, BorderLayout.WEST);
		panel1.add(txtArea, BorderLayout.CENTER);
		
		//frame.add(panel1, BorderLayout.NORTH);
		frame.add(panel1);
	}
}
