package classapp;

import java.awt.Button;
import java.awt.Choice;
import java.awt.Component;
import java.awt.Frame;
import java.awt.Image;
import java.awt.Label;
import java.awt.List;
import java.awt.MouseInfo;
import java.awt.PointerInfo;
import java.awt.Robot;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.InputEvent;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.TextEvent;
import java.awt.event.TextListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.ImageIcon;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.text.NumberFormatter;

import mainframe.UserLoad;
import menu_frame.LoginFrame;
import menu_information.UserInfomation;



public class FrameClass {

	static int cnt = 0;
	static int count = 0;
	static String res[][];
	static JTable jtable;
	static JScrollPane sp = new JScrollPane(jtable);
	static String[][] complete = new String[0][];
	static int credit = 0;
	static Application app = new Application();
	static ArrayList<String>[] list;
	
	
	public FrameClass() {
		

		// ������û ����ȭ��
		Frame fc = new Frame("������û�ý���");
		fc.setBounds(500, 200, 800, 540);
		fc.setLayout(null);

		// Frame ���� �� ��ü�� �ڸ����
		
		Button login = new Button("��ȸ");
		login.setBounds(25, 50, 70, 40);
		login.setEnabled(true);

		
		
		Label info = new Label();
		info.setBounds(100, 50, 590, 40);
		
		Label search = new Label("���ǽð�ǥ �˻�");
		search.setBounds(50, 110, 100, 30);

		Button ask = new Button("��û");
		ask.setBounds(715, 160, 50, 150);
		ask.setEnabled(false);

		Button cancel = new Button("��û���");
		cancel.setBounds(715, 330, 50, 150);
		cancel.setEnabled(true);
		cancel.setVisible(false);
		
		Button save = new Button("����");
		save.setBounds(700, 50, 70, 40);
		save.setEnabled(false);
//		
//		ImageIcon logo = new ImageIcon("logo.png");
//		JLabel back = new JLabel(logo);
//		back.setBounds(0, 0, 800, 700);
//		
		
		

		// ���ǽð�ǥ �к�, �� choice
		Choice studies = new Choice();
		studies.setBounds(170, 110, 0, 0);
		studies.add("��ü");
		studies.add("�ι��к�");
		studies.add("�ڿ����к�");
		studies.add("��ȸ���к�");
		studies.add("���к�");

		// ���Ǹ�� ����
		String header[] = { "�к�", "��������", "�������", "����", "�����ο�", "��米��", "���� �� ����" };
		String contents[][] = { { "�ι��к�", "ö�а�", "���ö�л�", "3", "40", "��â��", "ȭ 1~3" },
				{ "�ι��к�", "ö�а�", "�߼�ö�л�", "3", "60", "�ڽ���", "�� 4~6" },
				{ "�ι��к�", "ö�а�", "�����νķ�", "3", "50", "����Ŭ����", "�� 1~3" },
				{ "�ι��к�", "�����а�", "����а���", "3", "40", "��μ�", "�� 1~3" },
				{ "�ι��к�", "�����а�", "���а���", "3", "60", "�ȿ���", "�� 2~4" },
				{ "�ι��к�", "�����а�", "���а� ����", "2", "50", "�ȿ���", "�� 4~5" },
				{ "�ι��к�", "���а�", "�ѱ������Թ�", "3", "40", "������", "�� 2~4" },
				{ "�ι��к�", "���а�", "�ѱ�����ʻ���б�", "3", "60", "ä����", "�� 1~3" },
				{ "�ι��к�", "���а�", "�ѱ�����", "2", "50", "��淮", "�� 4~5" },
				{ "�ڿ����к�", "�����а�", "���ڿ���", "3", "40", "������", "ȭ 4~6" },
				{ "�ڿ����к�", "�����а�", "�����н���", "3", "40", "������", "�� 4~6" },
				{ "�ڿ����к�", "�����а�", "���ڱ���", "3", "40", "�����", "�� 1~3" },
				{ "�ڿ����к�", "ȭ�а�", "��ȭ�н���", "3", "40", "�̼���", "�� 2~4" },
				{ "�ڿ����к�", "ȭ�а�", "����ȭ��", "3", "60", "�̼���", "ȭ 2~4" },
				{ "�ڿ����к�", "ȭ�а�", "����ȭ��", "3", "50", "�ѵ���", "�� 1~3" },
				{ "�ڿ����к�", "���а�", "�Ϲݼ���", "3", "40", "�ڹ���", "�� 5~7" },
				{ "�ڿ����к�", "���а�", "���������", "3", "60", "ä�μ�", "ȭ 3~5" },
				{ "�ڿ����к�", "���а�", "�ؼ��а���", "2", "50", "������", "�� 1~2" },
				{ "��ȸ���к�", "�濵�а�", "�濵�п���", "3", "80", "�����", "�� 6~8" },
				{ "��ȸ���к�", "�濵�а�", "�繫����", "3", "80", "�̻���", "ȭ 2~4" },
				{ "��ȸ���к�", "�濵�а�", "������", "2", "80", "�ڼ���", "�� 6~7" },
				{ "��ȸ���к�", "�����а�", "�����а���", "3", "80", "�ִ����̽�", "�� 1~3" },
				{ "��ȸ���к�", "�����а�", "�̽ð�����", "3", "80", "���ÿ�", "ȭ 2~4" },
				{ "��ȸ���к�", "�����а�", "�Žð�����", "3", "80", "���ؼ�", "�� 4~6" },
				{ "��ȸ���к�", "���а�", "���а���", "3", "60", "������", "�� 6~8" },
				{ "��ȸ���к�", "���а�", "����ѷ�", "3", "60", "ä����", "�� 6~8" },
				{ "��ȸ���к�", "���а�", "�����ѷ�", "3", "60", "��淮", "�� 4~6" },
				{ "���к�", "�������ڰ��а�", "��������", "3", "30", "�յ���", "ȭ 4~6" },
				{ "���к�", "�������ڰ��а�", "�ö��", "2", "40", "����", "�� 4~6" },
				{ "���к�", "�������ڰ��а�", "ȸ���̷�", "3", "40", "�����", "�� 1~3" },
				{ "���к�", "��ǻ�Ͱ��а�", "�ü��", "3", "40", "����", "ȭ 6~8" },
				{ "���к�", "��ǻ�Ͱ��а�", "��ǻ�ͱ���", "3", "40", "��������", "�� 6~8" },
				{ "���к�", "��ǻ�Ͱ��а�", "�˰���м�", "3", "40", "���̾�", "�� 2~4" },
				{ "���к�", "������Ű��а�", "������Ű��а���", "3", "40", "�����", "�� 5~7" },
				{ "���к�", "������Ű��а�", "���������", "2", "60", "������", "ȭ 3~4" },
				{ "���к�", "������Ű��а�", "�̵���Ű���", "3", "50", "������", "�� 1~3" } };

		// ��û��Ȳ label
		Label credit_now = new Label("�� 0 ���� ��û�Ǿ����ϴ�");
		credit_now.setBounds(620, 110, 170, 30);
		

		// �к� �������� ��, �кο� �ش��ϴ� �� choice��� ����
		Choice major = new Choice();
		major.setBounds(310, 110, 120, 50);
		studies.addItemListener(new ItemListener() {

			@Override
			public void itemStateChanged(ItemEvent e) {
				String str = (String) e.getItem();
				if (str.equals("�ι��к�")) {
					major.removeAll();
					major.add("ö�а�");
					major.add("�����а�");
					major.add("���а�");
				} else if (str.equals("�ڿ����к�")) {
					major.removeAll();
					major.add("�����а�");
					major.add("ȭ�а�");
					major.add("���а�");
				} else if (str.equals("��ȸ���к�")) {
					major.removeAll();
					major.add("�濵�а�");
					major.add("�����а�");
					major.add("���а�");
				} else if (str.equals("���к�")) {
					major.removeAll();
					major.add("�������ڰ��а�");
					major.add("��ǻ�Ͱ��а�");
					major.add("������Ű��а�");
				} else if (str.equals("��ü")) {
					major.removeAll();
				}

			}

		});

		// ���� choice���� ��, �ش� ������ ���ǰ� �ߵ���
		cnt = 36;
		res = new String[cnt][header.length];
		jtable = new JTable(res, header) {
			@Override
			public boolean isCellEditable(int row, int column) {
				// TODO Auto-generated method stub
				return false;
			}
		};
		sp = new JScrollPane(jtable);
		sp.setBounds(25, 160, 690, 150);
		for (int i = 0; i < contents.length; i++) {

			for (int j = 0; j < contents[i].length; j++) {
				res[i][j] = contents[i][j];

			}

		}
		fc.add(sp);

		studies.addItemListener(new ItemListener() {

			@Override
			public void itemStateChanged(ItemEvent e) {
				// fc.add(sp);

				fc.remove(sp);

				cnt = 0;
				String str = (String) e.getItem();
				for (int i = 0; i < contents.length; i++) {
					if (contents[i][0].equals(str)) {
						cnt++;
					}
				}
				if (str.equals("��ü")) {
					cnt = 36;
				}

				res = new String[cnt][header.length];
				jtable = new JTable(res, header) {
					@Override
					public boolean isCellEditable(int row, int column) {
						// TODO Auto-generated method stub
						return false;
					}
				};
				sp = new JScrollPane(jtable);
				sp.setBounds(25, 160, 690, 150);

				// sp.setEnabled(true);

				if (str.equals("��ü")) {

					for (int i = 0; i < contents.length; i++) {

						for (int j = 0; j < contents[i].length; j++) {
							res[i][j] = contents[i][j];

						}

					}
					fc.add(sp);
				}

				int num = 0;
				for (int i = 0; i < contents.length; i++) {
					if (contents[i][0].equals(str)) {
						// fc.remove(sp);

						for (int j = 0; j < contents[i].length; j++) {
							res[num][j] = contents[i][j];

						}
						num++;

					}
				}
				fc.add(sp);

			}
		});
		major.addItemListener(new ItemListener() {

			@Override
			public void itemStateChanged(ItemEvent e) {
				fc.remove(sp);

				cnt = 0;
				String str = (String) e.getItem();
				for (int i = 0; i < contents.length; i++) {
					if (contents[i][1].equals(str)) {
						cnt++;
					}
				}
				res = new String[cnt][header.length];
				jtable = new JTable(res, header) {
					@Override
					public boolean isCellEditable(int row, int column) {
						// TODO Auto-generated method stub
						return false;
					}
				};
				sp = new JScrollPane(jtable);
				sp.setBounds(25, 160, 690, 150);
				// sp.setEnabled(true);
				int num = 0;
				for (int i = 0; i < contents.length; i++) {

					if (contents[i][1].equals(str)) {
						for (int j = 0; j < contents[i].length; j++) {
							res[num][j] = contents[i][j];

						}
						num++;
					}
				}
				fc.add(sp);
				fc.add(credit_now);

			}
		});

		// ������û ��û ��ư Ŭ������ ��

		complete = new String[8][header.length];
		JTable table = new JTable(complete, header);
		JScrollPane jsp = new JScrollPane(table);
		jsp.setBounds(25, 330, 690, 153);
		list = new ArrayList[complete.length];
		for (int i = 0; i < complete.length; i++) {
			list[i] = new ArrayList<String>();
		}

		// �α��ι�ư�� ������ ���
		login.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				fc.add(cancel);
				
				info.setText(LoginFrame.id_str + " �� �α��εǾ����ϴ�.");
				
				SystemLoad sl = new SystemLoad();
				app = sl.sysLoader(LoginFrame.id_str);
				//list = app.getList();
				//System.out.println(app.getCredit());
				//System.out.println(list[0].get(2));
				if(app == null) {
					app = new Application();
					app.setId(LoginFrame.id_str);
				}else {
					credit = app.getCredit();
					//complete = app.getComplete();
					list = app.getList();
					count = app.getCount();
					for (int i = 0; i < list.length; i++) {
						
						for (int j = 0; j < list[i].size(); j++) {
							
							complete[i][j] = list[i].get(j);

						}
					}
					credit_now.setText("�� "+credit+" ���� ��û�Ǿ����ϴ�");
					cancel.setVisible(true);
					//cancel.setEnabled(true);
					fc.add(jsp);
					
				
				}
				
				ask.setEnabled(true);
				
			}
		});
		//���� load
		
//		SystemLoad sl = new SystemLoad();
//		app = sl.sysLoader(getId.getText());
//		if(app == null) {
//			app = new Application();
//			app.setId(getId.getText());
//		}else {
//			credit = app.getCredit();
//			complete = app.getComplete();
//		}
		

		ask.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				int row = jtable.getSelectedRow();
				boolean run = true;
				TableModel model = jtable.getModel();
				char[] a = new char[3];
				char[] b = new char[3];
		
				
				for (int i = 0; i < complete.length; i++) {
					if (model.getValueAt(row, 2).equals(complete[i][2])) {
						FrameOverlap fo = new FrameOverlap();
						fo.overlap.setText("! [" + model.getValueAt(row, 2) + "]��(��) \n �̹� ��û�ϼ̽��ϴ� !");
						count--;
						run = false;
						break ;
					}
				}
				
			
				if(run) {
				tt: for (int i = 0; i < count; i++) {
					int plus = 0;
					for (int j = 0; j < Integer.parseInt(complete[i][3]); j++) {
						
						a[j] = (char) (complete[i][6].charAt(2) + plus);
						plus++;
					}
					plus = 0;
					
					for (int j = 0; j < Integer.parseInt((String) model.getValueAt(row, 3)); j++) {
						
						b[j] = (char) (((String) model.getValueAt(row, 6)).charAt(2) + plus);
						plus++;
					}
					if (complete[i][6].charAt(0) == ((String) model.getValueAt(row, 6)).charAt(0)) {

						for (int q = 0; q < a.length; q++) {
							for (int k = 0; k < b.length; k++) {
								if (a[q] == b[k]) {
									FrameTime ft = new FrameTime();
									count--;
									run = false;
									break tt;
								}
							}//inner
						}//outer

					}
				}//tt
				}


				if(run) {
				for (int j = 0; j < model.getColumnCount(); j++) {
					Object obj = model.getValueAt(row, j);
					complete[count][j] = (String) obj;
				}
				credit += Integer.parseInt(complete[count][3]);

				if (credit >= 16) {
					credit -= Integer.parseInt(complete[count][3]);
					credit_now.setText("�� " + credit + "���� ��û�Ǿ����ϴ�");
					FrameFail ff = new FrameFail();
					for(int i = 0; i<header.length; i++) {
						complete[count][i] = null;
					}
					
					count--;
				} else {

					credit_now.setText("�� " + credit + "���� ��û�Ǿ����ϴ�");
					FrameSuccess fs = new FrameSuccess();

					fs.success.setText(complete[count][2] + " ������û ����");

				}
				}//run if

				fc.add(jsp);
				cancel.setEnabled(true);
				cancel.setVisible(true);

				for (int j = 0; j < header.length; j++) {
					if (count >= complete.length) {
						break;
					}else {
						list[count].add(complete[count][j]);
						if(list[count].size() > header.length) {
							for(int i = header.length; i<list[count].size(); i++ ) {
								list[count].remove(i);
							}
						}
					}
				}
				count++;
				//cancel.setEnabled(true);
				save.setEnabled(true);
//				for(int i = 0; i<8; i++) {
//					System.out.println(list[i]);
//				}

			}
		});

		// ������� ��ư Ŭ������ ��
		cancel.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				int roww = table.getSelectedRow();
				if(list[roww].size() == 0) {
					FrameBlank fb = new FrameBlank();
				}else {
					
				credit -= Integer.parseInt(complete[roww][3]);
				

				for (int i = 0; i < list[roww].size();) {
					list[roww].remove(i);

				}
				for (int i = roww; i < list.length - 1; i++) {
					list[i] = list[i + 1];
				}

				for (int i = 0; i < list.length; i++) {
					if (list[i].size() == 0) {
						for (int j = 0; j < header.length; j++) {
							complete[i][j] = null;
						}
					}
					for (int j = 0; j < list[i].size(); j++) {
						
						complete[i][j] = list[i].get(j);

					}
				}
				
				FrameCancel fca = new FrameCancel();
				

				fc.add(jsp);
				credit_now.setText("�� " + credit + "���� ��û�Ǿ����ϴ�");
				count--;
				}//else
			}
		});
		
		
		
		//����
		save.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				
				app.setCredit(credit);
				//app.setComplete(complete);
				app.setList(list);
				app.setCount(count);
				//System.out.println(list[0].get(2));
				
				SystemSave ss = new SystemSave();
				ss.infoSave(app);
				// TODO Auto-generated method stub
				
			}
		});
		
		//System.out.println(app.getId());
		

		// fc�� ������Ʈ�� �߰�
		
		fc.add(login);
		fc.add(info);
		fc.add(search);
		fc.add(studies);
		fc.add(major);
		fc.add(credit_now);
		fc.add(ask);
		fc.add(cancel);
		fc.add(save);
		//fc.add(back);
		
		

		// fc �⺻����
		fc.setResizable(false);
		fc.setVisible(true);

		fc.addWindowListener(new WindowAdapter() {

			public void windowClosing(WindowEvent e) {
				fc.dispose();
			};

		});
		
	}
//public static void main(String[] args) {
//	FrameClass fc = new FrameClass();
//}
}