package classapp;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class FrameTime extends JFrame{

	
	JLabel timetable;
	JButton btn;
	
	public FrameTime() {
		setBounds(700, 400, 400, 200);
		setLayout(null);

		timetable = new JLabel("! ���ð��� ��û�Ͻ� ���ǰ� �ֽ��ϴ� !");
		timetable.setBounds(70, 50, 300, 30);
		
		btn = new JButton("Ȯ��");
		btn.setBounds(170, 100, 60, 30);
		

		btn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {

				dispose();

			}
		});
		
		add(btn);
		add(timetable);
		
		
		// ������ ǥ��
		setVisible(true);
		setResizable(false);
		setAlwaysOnTop(true);
		
		addWindowListener(new WindowAdapter() {

			public void windowClosing(WindowEvent e) {

				dispose(); // �����ִ� ��� �������� ����
			};

		});
	}
}