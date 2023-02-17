package board;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.RowFilter;
import javax.swing.table.TableColumn;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

import menu_frame.LoginFrame;

public class BoardList extends JFrame implements MouseListener{

	JTextField searchWindow;
	JButton searchbtn;
	JButton writebtn;
	JTable userTable;
	JScrollPane lists;
	JPanel listPanel;

	public BoardList(String title) {
		//super(title);


		setBounds(100, 100, 1280, 720);
		setLayout(null);
		setBackground(Color.LIGHT_GRAY);


		File file = new File("board" + "/");
		
		String columnName[] = {"No","����","�ۼ���"};
		
		/*
		String data[][] = {
				{"1","2022�� �⸻��� ���� ����","������"},
				{"2","2022�⵵ ������ �ȳ�","������"},
				{"3","2023�� ���Ի� ���� �ȳ�","������"}
		};
		*/

		String[][] data2 = new String[(int)file.list().length][3]; 
		
		System.out.println(file.list().length);
		
		for(int i = 0; i<data2.length; i++) {
			System.out.println(file.list()[i]);			
			data2[i][0] = "" + (i+1);
			data2[i][1] = file.list()[i].substring(0, file.list()[i].length()-4);
			data2[i][2] = "������";
			
		}
		
		
	         
		JTable userTable = new JTable(data2, columnName){
			public boolean isCellEditable(int i, int c){
	          return false;
	         }};
		JScrollPane lists = new JScrollPane(userTable);
		lists.setBounds(30, 50, 1180, 510);
		
		JLabel lbno = new JLabel("No");
		lbno.setBounds(115, 20, 170, 30);
		JLabel lbtitle = new JLabel("����");
		lbtitle.setBounds(600, 20, 800, 30);
		JLabel lbwt = new JLabel("�۾���");
		lbwt.setBounds(1100, 20, 200, 30);
		
		
		
//		String path = "board\\save.txt";


//		try {
//			FileReader fr = new FileReader(path);
//			BufferedReader br = new BufferedReader(fr);
//
//			String ss = "";
//			String[] lines = null;
//
//			try {
//				fr = new FileReader(path);
//				br = new BufferedReader(fr);
//				
//				int cnt = 0;
//				lines = new String[5];
//				while( (ss  = br.readLine()) != null) {
//
//					lines[cnt++] = ss;
//	
//				}
//
//			}catch (Exception e) {
//				e.printStackTrace();
//			}
//
//		} catch (Exception e) {
//			e.printStackTrace();
//		
//		}


		listPanel = new JPanel();
		listPanel.setLayout(new BorderLayout());
		listPanel.add(userTable, BorderLayout.CENTER);

		userTable.setBounds(35, 55, 1170, 500);
		userTable.setRowHeight(30);// �����

		//�� �ʺ� ����
		TableColumn column;
		column = userTable.getColumnModel().getColumn(0);
		column.setPreferredWidth(170);
		column = userTable.getColumnModel().getColumn(1);
		column.setPreferredWidth(800);
		column = userTable.getColumnModel().getColumn(2);
		column.setPreferredWidth(200);
		



		// �˻�â
		searchWindow = new JTextField();
		searchWindow.setBounds(450, 620, 250, 30);

		// �˻���ư
		searchbtn = new JButton("�˻�");
		searchbtn.setBounds(700, 620, 70, 30);

		//�˻��ǽ�
		searchbtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String val = searchWindow.getText();
				TableRowSorter<TableModel> trs = new TableRowSorter<>(userTable.getModel());
				userTable.setRowSorter(trs);
				trs.setRowFilter(RowFilter.regexFilter(val));
			}
		});

		// �۾����ư
		writebtn = new JButton("�۾���");
		writebtn.setBounds(1125, 570, 80, 30);
		

		if(LoginFrame.id_str.equals("������")) {
			writebtn.setEnabled(true);
		}else {
			writebtn.setEnabled(false);
			
		}
		
		writebtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				new Written();
				dispose();
			}

		});


		// ���̺� ����Ŭ�� �̺�Ʈ
		userTable.addMouseListener(new MouseListener() {

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseClicked(MouseEvent e) {
				if (e.getClickCount() == 2) {
					new WrittenSave(file,userTable);
				}


			}
		});

		// frame�� �߰�

		add(lbno);
		add(lbtitle);
		add(lbwt);
		add(userTable);
		add(lists);
		add(searchWindow);
		add(searchbtn);
		add(writebtn);


		// x Ŭ���� ����
		addWindowListener(new WindowAdapter() {

			public void windowClosing(WindowEvent e) {
				dispose();

			};

		});

		setVisible(true);

		// �����ӻ����� ���� �Ұ�
		setResizable(false);

	}// ������

	// BoardList �������̵�
	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub

	}

}
