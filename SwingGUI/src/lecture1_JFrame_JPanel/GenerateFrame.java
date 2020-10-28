package lecture1_JFrame_JPanel;


import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class GenerateFrame {

	public static void main(String[] args) {
		JFrame frame = new JFrame();
		JPanel panel = new JPanel();
		
		// setVisible( boolean type )
		// true: GUI를 보이게함
		// false: GUI를 숨김
		frame.setVisible(true);
		
		// setPreferedSize( integer type or Dimension instance)
		// 선호하는 프레임의 크기를 지정한다
		frame.setPreferredSize(new Dimension(840, 840/12*9));
		
		// setSize( integer, integer type)
		// 프레임의 크기를 지정한다.
		frame.setSize(840, 840/12*9);
		
		// setResizable (boolean type)
		// true --> 프레임 크기 재조정가능
		frame.setResizable(false);
		
		// setLocationRelativeTo( Component instance )
		// 프레임 생성시 위치를 상대값에 의해서 정함.
		// null을 매개변수로 할 시 중간에 생성됨.
		frame.setLocationRelativeTo(null);
		
		// setDefaultCloseOperation 
		// JFrame.EXIT_ON_CLOSE --> 프레임을 닫을 시 프로그램 종료
		// 일반적으로는 프레임을 닫아도 프로그램이 종료되지 아니함.
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		// frame --> 전체적인 틀
		// panel --> 프레임 안에 들어가는 컨텐츠
		
		// JLabel --> 패널의 제목을 만듦
		panel.add(new JLabel("GUI basic"));
		
		// frame.add( Panel type)
		// 패널을 프레임 안에 집어넣는 메소드
		frame.add(panel);
	}
}
