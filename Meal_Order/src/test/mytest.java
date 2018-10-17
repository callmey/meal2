package test;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;

import javax.swing.DefaultCellEditor;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;

import Client.Manager;
import Database.GetMenu;

public class mytest extends JFrame{
	
	private JButton all_select;
	private JButton search;
	private JButton modify;
	private JButton delete;
	private JButton todayMenu;
	private JButton exit;
	
	private JLabel typelabel;
	private JComboBox<String> type;
	private String[] cuisinetype = {"�ѽ�","�߽�","�Ͻ�","���"};
	private String[] table_title = {"","mealName", "price","maxCount","todayMeal"};
	
	private JPanel buttonpanel;
	private JPanel tablepanel;

	private JCheckBox checkbox;
	
	private Object[][] data = {};
	private DefaultTableModel model;
	
	private JScrollPane scrollpane;
	private JTable table;
	
	private GridBagConstraints c;
	
	private String[] check_menucount;
	private String[] check_menuName;
	private String[] check_todayMeal;
	private String[] check_menuprice;

	private int cuisineNo = 1;
	
	private int arrsize = 0;
	
	private DefaultTableCellRenderer dt;
	private DefaultTableCellRenderer checkboxrender;
	
	
	public mytest() {
		
		setBounds(50, 50, 605, 538);
		//setResizable(false);
		setTitle("�޴� ����");
		addWindowListener(new WindowAdapter() {
			
			@Override
			public void windowClosing(WindowEvent e) {
				new Manager();
				dispose();
			}
		});
		
		setLayout(null);
		
		buttonpanel = new JPanel(new GridBagLayout());
		buttonpanel.setBounds(0,0,600,50);
		//buttonpanel.setBackground(Color.BLACK);
		tablepanel = new JPanel(new GridLayout(1, 1));
		tablepanel.setBounds(0,50,600,450);

		c= new GridBagConstraints();
		
		Object [][] datas = {{false,"ȫ�浿","20","��"},{true,"�踻��","18","��"}};
		
		///������ �ޱ�
		model = new DefaultTableModel(datas,table_title){ 
			public boolean isCellEditable(int row, int column)
			{ 
				return column == 0; 
			} 
		}; 
		
		
		//////��ư�� ��
		
		
		all_select = new JButton("��� ����");
		all_select.setFont(buttonFont());
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 0;
		c.gridy = 0;
		c.insets = new Insets(0, 0, 0, 5);
		buttonpanel.add(all_select,c);
		
		typelabel = new JLabel("����:");
		typelabel.setFont(buttonFont());
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 1;
		c.gridy = 0;
		buttonpanel.add(typelabel,c);
		
		type = new JComboBox<String>(cuisinetype);
		type.setFont(buttonFont());
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 2;
		c.gridy = 0;
		buttonpanel.add(type,c);
		
		search = new JButton("�˻�");
		search.setFont(buttonFont());
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 3;
		c.gridy = 0;
		buttonpanel.add(search,c);
		
		modify = new JButton("����");
		modify.setFont(buttonFont());
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 4;
		c.gridy = 0;
		buttonpanel.add(modify,c);
		
		delete = new JButton("����");
		delete.setFont(buttonFont());
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 5;
		c.gridy = 0;
		buttonpanel.add(delete,c);
		
		todayMenu = new JButton("�����Ǹ޴�����");
		todayMenu.setFont(buttonFont());
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 6;
		c.gridy = 0;
	
		buttonpanel.add(todayMenu,c);
		
		exit = new JButton("�ݱ�");
		exit.setFont(buttonFont());
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 7;
		c.gridy = 0;
		exit.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				new Manager();
				dispose();
			}
		});
		buttonpanel.add(exit,c);
		
		///////////////���̺� �г�
		
		 checkboxrender = new DefaultTableCellRenderer()
		 {
		  public Component getTableCellRendererComponent  // ��������
		   (JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column)
		  {
		   JCheckBox box= new JCheckBox();
		   box.setSelected(false);  
		   box.setHorizontalAlignment(JLabel.CENTER);
		   return box;
		  }
		 };
		 
		
		table = new JTable(model);
		//�� ���� ����
		table.getColumnModel().getColumn(0).setPreferredWidth(5); 
		
		dt =  new DefaultTableCellRenderer();
		dt.setHorizontalAlignment(SwingConstants.CENTER);
		for(int i= 1 ;i<table.getColumnCount();i++) {
			table.getColumnModel().getColumn(i).setCellRenderer(dt);
		}
		table.getColumn("").setCellRenderer(checkboxrender);
		checkbox = new JCheckBox();
		checkbox.setHorizontalAlignment(JLabel.CENTER);

		
		table.getColumn("").setCellEditor(new DefaultCellEditor(checkbox));
		
		scrollpane = new JScrollPane(table);
		//scrollpane.setPreferredSize(new Dimension(width, height));
		//scrollpane.setBounds(0, 0, 600, 550);
		scrollpane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		
		
		tablepanel.add(scrollpane);
		
		
		add(tablepanel);
		add(buttonpanel);
		setVisible(true);
	}
	

	private Font buttonFont() {
		return new Font("����", Font.BOLD, 13);
	}
	
	public static void main(String[] args) {
		new mytest();
	}
}
