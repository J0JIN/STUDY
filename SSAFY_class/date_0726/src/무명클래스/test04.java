package 무명클래스;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

public class test04 {

	public static void main(String[] args) {
		JFrame frame = new JFrame();
		frame.setSize(300,400);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JButton button = new JButton("눌러");
		
//		button.addActionListener(new ActionListener() {
//			@Override
//			public void actionPerformed(ActionEvent e) {
//				System.out.println("ㅎㅎㅎㅎㅎ");
//			}
//		});
		
		button.addActionListener(e->System.out.println("ㅎㅎㅎㅎㅎㅎ"));
		
		frame.add(button);
	}
}
