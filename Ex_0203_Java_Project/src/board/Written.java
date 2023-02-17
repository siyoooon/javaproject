package board;

import java.awt.Color;
import java.awt.FileDialog;
import java.awt.Frame;
import java.awt.Label;
import java.awt.TextArea;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;

public class Written extends Frame {
	public Written() {
		
		Frame f = new Frame();
		f.setBounds(95, 95, 1000, 560);
		f.setLayout(null);
		f.setBackground(Color.LIGHT_GRAY);
		
		JLabel lt = new JLabel("����:");
		lt.setBounds(60, 80, 30, 30);
		
		TextField title = new TextField();
		title.setBounds(95, 80, 850, 30);
		
		TextArea wtOut = new TextArea("", 0, 0, TextArea.SCROLLBARS_VERTICAL_ONLY);
		wtOut.setBounds(60, 120, 890, 360);
		
		JButton wtbtn = new JButton("���");
		wtbtn.setBounds(880, 500, 70, 30);
		
		//��Ϲ�ư Ŭ���� ����
		wtbtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String message = wtOut.getText();
				
				File file1  = new File("board\\");
				
				FileWriter fw = null;
				BufferedWriter bw = null;
				
				try {
					
					BufferedWriter bos1 = new BufferedWriter(new FileWriter(file1 + "/" + title.getText() +  ".txt"));
					bos1.write(wtOut.getText());
					bos1.close();
					dispose();
					new BoardList("��������");
				} catch (Exception e2) {
					e2.printStackTrace();
				}finally {
					try {
						
					} catch (Exception e3) {
						e3.printStackTrace();
					}
				}
				
			}
		});
		
		// ���� ��ư ��
		wtbtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				Frame wtf = new Frame();
				wtf.setBounds(400, 400, 300, 200);
				wtf.setLayout(null);
				wtf.setBackground(Color.LIGHT_GRAY);
				
				Label lb = new Label("�ۼ��� �Ϸ�Ǿ����ϴ�");
				lb.setBounds(90, 90, 150, 30);
								
				JButton wtfb = new JButton("Ȯ��");
				wtfb.setBounds(120, 135, 70, 30);
				
				wtf.add(lb);
				wtf.add(wtfb);
				
				// 
				wtfb.addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {
						wtf.dispose();
						f.dispose();
					}
				});//Ȯ�ι�ư �̼�
				
				wtf.setVisible(true);
				wtf.setResizable(false);
				
			}
		});//��Ϲ�ư �׼�
		
		
		//�����ӿ� �߰�
		f.add(lt);
		f.add(title);
		f.add(wtOut);
		f.add(wtbtn);
		
		//����������
		f.addWindowListener(new WindowAdapter() {

			public void windowClosing(WindowEvent e) {
				f.dispose();
			};
		});
		
		f.setVisible(true);
		f.setResizable(false);
		
	}
}
