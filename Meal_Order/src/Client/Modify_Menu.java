package Client;

import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import Database.Modify_Menu_Server;
import Database.New_Menu_Register_Server;

public class Modify_Menu extends JFrame{
	
private GridBagConstraints c;
	
	private JLabel memberno;
	private JLabel membername;
	private JLabel passwd;
	private JLabel passwdcorrect;
	
	private JComboBox<String> cuisinetype;
	private JTextField mealName;
	private JComboBox<String> price;
	private JComboBox<String> maxcount;
	
	private String[] str_cuisinetype = {"�ѽ�", "�߽�", "�Ͻ�", "���"};
	private String[] str_price = new String[23];//1000~1200(500����)
	private String[] str_maxcount = new String[51];//0~50
	
	private int priceindex = 0;
	private int countindex = 0;
	
	private String cuisineNumber = null;
	private String name =null;
	
	private JButton exit;
	private JButton register;
	private JButton button;	
	
	public Modify_Menu(int cuisineNo, String check_menuName, String check_menuprice, String check_menucount) {
		/////������ �޾ƿ´�. ����,�޴���,����,�������ɼ���
		
		setBounds(100, 100, 430, 310);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setTitle("�޴� ����");
		setResizable(false);
	
		setLayout(new GridBagLayout());
	    c = new GridBagConstraints();
	    
	    int start = 1000;
	    
	    for(int i=0;i<str_price.length;i++) {
	    	str_price[i] = Integer.toString(start);
	    	if(str_price[i].equals(check_menuprice)) {
	    		priceindex = i;
	    	}
	    		start+=500;
	    }	   
	    
	    for(int i=0;i<str_maxcount.length;i++) {
	    	str_maxcount[i] = Integer.toString(i);
	    	if(str_maxcount[i].equals(check_menucount)) {
	    		countindex = i;
	    	}
	    }
		
		memberno = new JLabel("����");
		c.fill = GridBagConstraints.HORIZONTAL;
		c.ipady = 30;
		c.gridx = 0;
		c.gridy = 0;
		add(memberno,c);
		
		membername = new JLabel("�޴���");
		c.fill = GridBagConstraints.HORIZONTAL;
		c.ipady = 30;
		c.gridx = 0;
		c.gridy = 1;
		add(membername,c);
		
		passwd = new JLabel("����");
		c.fill = GridBagConstraints.HORIZONTAL;
		c.ipady = 30;
		c.gridx = 0;
		c.gridy = 2;
		add(passwd,c);
		
		passwdcorrect = new JLabel("�������ɼ���");
		c.fill = GridBagConstraints.HORIZONTAL;
		c.ipady = 30;
		c.gridx = 0;
		c.gridy = 3;
		add(passwdcorrect, c); 
		
		cuisinetype = new JComboBox<>(str_cuisinetype);
		cuisinetype.setSelectedIndex(cuisineNo-1);
		c.fill = GridBagConstraints.HORIZONTAL;
		c.ipady = 30;
		c.gridx = 1;
		c.gridy = 0;
		add(cuisinetype, c); 
		
		mealName = new JTextField();
		c.fill = GridBagConstraints.HORIZONTAL;
		c.ipady = 30;
		c.gridx = 1;
		c.gridy = 1;
		mealName.setText(check_menuName); //���⿡ �޾ƿ� �̸�
		name = mealName.getText();
		add(mealName, c); 
		
		price = new JComboBox<>(str_price);
		price.setSelectedIndex(priceindex);
		c.fill = GridBagConstraints.HORIZONTAL;
		c.ipady = 30;
		c.ipadx = 30;
		c.weightx = 0.5;
		c.gridx = 1;
		c.gridy = 2;
		add(price, c);
		
		maxcount = new JComboBox<>(str_maxcount);
		maxcount.setSelectedIndex(countindex);
		c.fill = GridBagConstraints.HORIZONTAL;
		c.ipady = 30;
		c.gridx = 1;
		c.gridy = 3;
		add(maxcount, c); 
		
		register = new JButton("���");
		c.fill = GridBagConstraints.HORIZONTAL;
		c.ipady = 30;
		c.gridx = 0;
		c.gridy = 4;
		register.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				switch(cuisinetype.getSelectedItem().toString()) {
				case "�ѽ�" : 
					cuisineNumber = "1";
					break;
				case "�߽�" :
					cuisineNumber = "2";
					break;
				case "�Ͻ�" : 
					cuisineNumber = "3";
					break;
				case "���" : 
					cuisineNumber = "4";
					break;
				}
				
		
				new Modify_Menu_Server().modify(check_menuName,cuisineNumber,
					mealName.getText(), price.getSelectedItem().toString(),
					maxcount.getSelectedItem().toString());
					showMessage("Message", "�޴��� �����Ǿ����ϴ�.");
					dispose();
					new Menu_Manager(Integer.valueOf(cuisineNumber));
				
			}
		});
		add(register,c);
		
		exit = new JButton("�ݱ�");
		c.fill = GridBagConstraints.HORIZONTAL;
		c.ipady = 30;
		c.gridx = 1;
		c.gridy = 4;
		exit.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();	
			}
		});
		add(exit,c);
		
	
		setVisible(true);	
	}
	private void showMessage(String title, String message) 
	{
		Font fontbt = new Font("����", Font.BOLD,15);
		JLabel input = new JLabel(message);
		input.setFont(fontbt);
		JOptionPane.showMessageDialog(null, input, title, JOptionPane.INFORMATION_MESSAGE);
	}
	private void showErrorMessage(String title, String message) 
	{
		Font fontbt = new Font("����", Font.BOLD,15);
		JLabel input = new JLabel(message);
		input.setFont(fontbt);
		JOptionPane.showMessageDialog(null, input, title, JOptionPane.ERROR_MESSAGE);
	}	
	
}
