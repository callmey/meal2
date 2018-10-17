package Client;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.Calendar;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTabbedPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.Timer;

public class User extends JFrame{
private GridBagConstraints c;
	
	private JButton kr;//�ѽ�
	private JButton ch;//�߽�
	private JButton jp;//�Ͻ�
	private JButton am;//���
	
	private Connection conn;
	private PreparedStatement pstmt;
	
	private JLabel maintext;
	private JComponent menu;
	private JTextArea timer;
	
	private JTabbedPane tab;
	private JPanel panel1;
	private JPanel panel2;
	private JPanel panel3;
		
	private String name = null;
	private char[] password = null; 
	private int new_memberno = 0;
	
	public User() {
		
		setBounds(100, 100, 515, 820);
		//setDefaultCloseOperation(EXIT_ON_CLOSE);
		setTitle("�ı� �߸� ���α׷�");
		setLayout(null);
		setResizable(false);
		
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				new Client_Main_Home_Grid();
				dispose();
			}
		});
		
		panel1 = new JPanel();
		panel2 = new JPanel(new GridLayout(1, 1));
		panel3 = new JPanel();
		tab = new JTabbedPane();
		
		Font font = new Font("����", Font.BOLD, 23);
		
		maintext = new JLabel("�ı� �߸� ���α׷�");
		maintext.setHorizontalTextPosition(SwingConstants.CENTER);
		maintext.setFont(font);
		
		maintext.setBounds(0, 0, 510, 50);
		panel1.setBounds(0, 0, 510, 50);
		
		panel1.add(maintext);
		add(panel1);
		
		menu = makeMenuPanel(); // ���⿡ �޴��� �� �� �����
		tab.addTab("�޴�", menu);
		
		panel2.setBounds(0,50,510,700);
		
		panel2.add(tab);
	    add(panel2);
	    
	    
	    timer = new JTextArea();
	    timer.setEditable(false);
	    timer.setBounds(0, 0, 510, 40);
	    timer.setBackground(Color.black);
	    timer.setForeground(Color.WHITE);
	    timer.setFont(font);
	    Runnable r = new CurrentTime();
	    Thread t = new Thread(r);
	    t.start();
	    
	    panel3.setBounds(0, 750, 510, 40);
	    panel3.setBackground(Color.BLACK);
	    
	    panel3.add(timer);
	    add(panel3);
	    
	    
	    setVisible(true);
	}
	 protected JComponent makeMenuPanel() {
	        JPanel panel = new JPanel(new GridLayout(2, 2));
	        
	        kr = new JButton(new ImageIcon("src/Image/menu_1.png"));
	        kr.setToolTipText("�ѽ�");
	        kr.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					new Settlement_Menu(1);
					dispose();
				}
			});
	        
	        ch = new JButton(new ImageIcon("src/Image/menu_2.png"));
	        ch.setToolTipText("�߽�");
	        ch.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					new Settlement_Menu(2);
					dispose();
				}
			});
	        
	        jp = new JButton(new ImageIcon("src/Image/menu_3.png"));
	        jp.setToolTipText("�Ͻ�");
	        jp.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					new Settlement_Menu(3);
					dispose();
				}
			});
	        
	        am = new JButton(new ImageIcon("src/Image/menu_4.png"));	        
	        am.setToolTipText("���");
	        am.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					new Settlement_Menu(4);
					dispose();
				}
			});
	        
	        panel.add(kr);
	        panel.add(ch);
	        panel.add(jp);
	        panel.add(am);
	        return panel;
	    }
	 	
	    
	 class CurrentTime implements Runnable{

			@Override
			public void run() {
				while(true) {
					
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
					Calendar cal = Calendar.getInstance();
					 
					//���� �⵵, ��, ��
				/*	int year = cal.get ( cal.YEAR );
					int month = cal.get ( cal.MONTH ) + 1 ;
					int date = cal.get ( cal.DATE ) ;
					 
					
					//���� (��,��,��)
					int hour = cal.get ( cal.HOUR_OF_DAY ) ;
					int min = cal.get ( cal.MINUTE );
					int sec = cal.get ( cal.SECOND );*/
					
					timer.setText("����ð� : "+cal.get ( cal.YEAR )+"��"+(cal.get ( cal.MONTH ) + 1 )
							+"��"+cal.get ( cal.DATE )+"��"
							+cal.get ( cal.HOUR_OF_DAY )+"��"+cal.get ( cal.MINUTE )+"��"+cal.get ( cal.SECOND )+"��");
				}
			}
			
			
	} 
	 
	/* public static void main(String[] args) {
		new User();
	}*/
}


