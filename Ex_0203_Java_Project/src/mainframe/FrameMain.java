package mainframe;

import java.awt.BorderLayout;
import java.awt.Choice;
import java.awt.Dimension;
import java.awt.Frame;
import java.awt.Menu;
import java.awt.MenuBar;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;
import java.util.ArrayList;

import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTree;
import javax.swing.table.DefaultTableModel;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;

import classapp.Application;
import menu_frame.LoginFrame;
import menu_information.UserInfomation;

public class FrameMain extends Frame {
	
	UserInfomation use = new UserInfomation();
	UserLoad ul = new UserLoad();
	//LoginFrame lf =new LoginFrame();
	Application app = new Application();
	String str = "";
	

	String[] depart = { "�ι��к� - �����а�", "�ι��к� - ö�а�", "�ι��к� - ���а�", "�ڿ����к� - �����а� ", "�ڿ����к� - ȭ�а� ", "�ڿ����к� - ���а� ",
			"��ȸ���к� - �濵�а�", "��ȸ���к� - �����а�", "��ȸ���к� - ���а�", "���к� - �������ڰ��а�", "���к� - ��ǻ�Ͱ��а�", "���к� - ������Ű��а�" };

	
	ArrayList<String>[] student_info ;
	
	UserInfomation ui = new UserInfomation();

	MenuBar mb = new MenuBar();

	Menu homeMenu = new Menu("HOME");
	Menu controlMenu = new Menu("��������");

	// JLabel titleLabel = new JLabel("Select Student Type");
	// boolean a = false;

	Choice choice = new Choice();
	// JComboBox<String> cb = new JComboBox<String>();

	JTree tree;
	DefaultMutableTreeNode root;

	DefaultTreeModel treeModel;

	JTable table;
	JScrollPane sp;
	
	JLabel login = new JLabel();

	
	//String user[] = {ui.getMajorName(), ui.getName(), ui.getId()};

	String columName[] = { "�а�", "�г�", "����", "����", "�й�" };
	String[][] select;
	int cnt = 0;

	public FrameMain() {
		
	
		String path = "userCharacter\\";
		File f = new File(path);
		String [][] student = new String [f.list().length][columName.length];
		
		if(LoginFrame.id_str.equals("������")) {
			choice.setVisible(true);
			student_info = new ArrayList[f.list().length];
			login.setText("<html>�����ڷ� <br/>�α����ϼ̽��ϴ�.<html>");
			for (int i = 0; i < f.list().length; i++) {
				student_info[i] = new ArrayList<String>();
			}
			
			String temp_str = "";
			for(int i = 0; i<f.list().length; i++) {
				String str = f.list()[i].toString().substring(0, 10);
				temp_str = str;
				ul.sysLoader(str);
				student_info[i].add(ul.user.getMajorName().toString());
				student_info[i].add(ul.user.getGrade().toString());
				student_info[i].add(ul.user.getName().toString());
				student_info[i].add("�кλ�");
				student_info[i].add(ul.user.getId().toString());
				
				//System.out.println(student_info[i]);
			}
			
			for(int i = 0; i<f.list().length; i++) {
				for(int j = 0; j<columName.length; j++) {
					student[i][j] = student_info[i].get(j);
				}
			}
			
			table = new JTable(student, columName) {
				@Override
				public boolean isCellEditable(int row, int column) {
					// TODO Auto-generated method stub
					return false;
				}
			};
			sp = new JScrollPane(table);
			sp.setBounds(200, 68, 750, 400);
			add(sp);
			
		}else {
			
			choice.setVisible(false);
			ul.sysLoader(LoginFrame.id_str);
			student_info = new ArrayList[1];
			student_info[0] = new ArrayList<String>();
			String[][] myinfo = new String[1][columName.length];
			student_info[0].add(ul.user.getMajorName().toString());
			student_info[0].add(ul.user.getGrade().toString());
			student_info[0].add(ul.user.getName().toString());
			student_info[0].add("�кλ�");
			student_info[0].add(ul.user.getId().toString());
			login.setText("<html>" + ul.user.getName() + "(" + ul.user.getId() + ") ��" +"<br/> �ź� : �кλ� <br/> �Ҽ� : " + ul.user.getMajorName());
			
			for(int j = 0; j<columName.length; j++) {
				myinfo[0][j] = student_info[0].get(j);
			}
			
			table = new JTable(myinfo, columName){
				@Override
				public boolean isCellEditable(int row, int column) {
					// TODO Auto-generated method stub
					return false;
				}
			};
			sp = new JScrollPane(table);
			sp.setBounds(200, 68, 750, 400);
			add(sp);
		}
		
		
		//System.out.println(LoginFrame.id_str);
	login.setBounds(35, 390, 160, 160);
		
	
		
		
		setTitle("�л��������α׷�");
		mb.add(homeMenu);
		mb.add(controlMenu);
		


		choice.add("�����а�");
		choice.add("ö�а�");
		choice.add("���а�");
		choice.add("�����а�");
		choice.add("ȭ�а�");
		choice.add("���а�");
		choice.add("�濵�а�");
		choice.add("�����а�");
		choice.add("���а�");
		choice.add("�������ڰ��а�");
		choice.add("��ǻ�Ͱ��а�");
		choice.add("������Ű��а�");
		
		
		choice.setBounds(20, 330, 160, 20);
		//choice.setVisible(true);

		root = new DefaultMutableTreeNode("�а�");

		tree = new JTree(root);

		tree.setBounds(10, 110, 160, 140);

		for (int i = 0; i < depart.length; i++) {

			DefaultMutableTreeNode node = new DefaultMutableTreeNode(depart[i]);
			root.add(node);
			treeModel = (DefaultTreeModel) tree.getModel();
			treeModel.setRoot(root);
		} // for
		
		controlMenu.addActionListener(new MenuClickListener(homeMenu, controlMenu));
		
//	     controlMenu.addActionListener(new ActionListener() {
//			
//			@Override
//			public void actionPerformed(ActionEvent e) {
//				
//				System.out.println("click");
//				Grade2 g2 = new Grade2("����");
//				g2.setDesign();
//				g2.actionPerformed(e);
//				
//			}
//		});

		

		choice.addItemListener(new ItemListener() {

			@Override
			public void itemStateChanged(ItemEvent arg0) {
				remove(sp);

				cnt = 0;
				int plus = 0;

				String obj = (String) arg0.getItem();
				for (int i = 0; i < student.length; i++) {
					// System.out.println(students[i][0]);

					if (obj.equals(student[i][0])) {
						cnt++;
					}
				}

				select = new String[cnt][columName.length];

				for (int i = 0; i < student.length; i++) {
					if (obj.equals(student[i][0])) {

						for (int j = 0; j < columName.length; j++) {
							select[plus][j] = student[i][j];

						}
						plus++;
					}
				}

				table = new JTable(select, columName) {
					@Override
					public boolean isCellEditable(int row, int column) {
						// TODO Auto-generated method stub
						return false;
					}
				};
				sp = new JScrollPane(table);
				sp.setBounds(200, 68, 750, 400);
				add(sp);

			}
		});
		add(choice);
		add(tree);
		setMenuBar(mb);
		add(login);
		// add(titleLabel);
		// add(gsCheck);
		// add(usCheck);

		setSize(1000, 500);
		setVisible(true);
		
		
		//System.out.println(students.length);

		addWindowListener(new WindowAdapter() {

			public void windowClosing(WindowEvent e) {
				dispose();
			};

		});
	}

	
}