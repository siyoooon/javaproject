package mainframe;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

import board.BoardList;
import classapp.FrameClass;
import mainframe.Grade2.TableEvent;
import menu_frame.LoginFrame;

public class MenuFrame extends JFrame{
	public MenuFrame () {
	
		setLayout(null);
		setBounds(750, 150, 700, 475);
		
		JButton btn1 = new JButton("��  ��  ��  ��");
		JButton btn2 = new JButton("��  ��  ��  ��");
		JButton btn3 = new JButton("��  ��  ��  ��");
		JButton btn4 = new JButton("��  ��  ��  û");
		JButton btn5 = new JButton("�� �� ��  �� ��");
		
		btn1.setBounds(520, 0, 175, 90);
		btn2.setBounds(520, 90, 175, 90);
		btn3.setBounds(520, 180, 175, 90);
		btn4.setBounds(520, 270, 175, 90);
		btn5.setBounds(520, 360, 175, 90);
		
		ImageIcon mit = new ImageIcon("KakaoTalk_20230214_120135682.jpg.png");
		
		JLabel mitt = new JLabel(mit);
		mitt.setBounds(0, 15, 500, 420);
		
		System.out.println(LoginFrame.id_str);
		if(LoginFrame.id_str.equals("������")) {
			btn3.setEnabled(true);
		}
		else {
			btn3.setEnabled(false);
		}
		
		btn2.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				FrameMain fm = new FrameMain();
				
			}
		});
		btn4.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				new FrameClass();
				
			}
		});
		
		btn5.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				menu_frame.MenuFrame mf = new menu_frame.MenuFrame();
				
			}
		});
		
		
		btn3.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				Grade2 gr = new Grade2("����");
				
				
				
			}
		});
		
		btn1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				new BoardList("��������");
				
			}
		});
		
		
		add(btn1);
		add(btn2);
		add(btn3);
		add(btn4);
		add(btn5);
		
	
		add(mitt);
		setResizable(false);
		setVisible(true);
		addWindowListener(new WindowAdapter() {

			public void windowClosing(WindowEvent e) {
				dispose();
			};

		});
	}


	
}
