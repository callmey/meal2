package CreateDataBase;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class SelectDB {

	private static ResultSet rs = null;
	
	public SelectDB() {}
	
	public static void cuisine(PreparedStatement pstmt) {
		
		try {
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				int d1 = rs.getInt(1);
				String d2= rs.getString(2);
			
				System.out.print("���� : "+d1+"\t");
				System.out.print("����  : "+d2+"\t");
				
				System.out.println("");
				
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	}
	public static void meal(PreparedStatement pstmt) {
		try {
					
			//5.����
			//DBMS�� ���� �� ������� �������ִ� ��ü : ResultSet
			rs = pstmt.executeQuery();				
			
			//6.���ڵ庰�� ���� ó��
			
			while(rs.next()) {
				int d1 = rs.getInt(1);
				int d2 = rs.getInt(2);
				String d3 = rs.getString(3);
				int d4 = rs.getInt(4);
				int d5 = rs.getInt(5);
				short d6 = rs.getShort(6);
			
				System.out.print("���� : "+d1+"\t");
				System.out.print("����  : "+d2+"\t");
				System.out.print("���ĸ� : "+d3+"\t");
				System.out.print("����  : "+d4+"\t");
				System.out.print("�������ɼ���  : "+d5+"\t");
				System.out.print("�����Ǹ޴�  : "+d6+"\t");
				
				System.out.println("");
				
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	}
	
	public static void member(PreparedStatement pstmt) {
		try {
					
			//5.����
			//DBMS�� ���� �� ������� �������ִ� ��ü : ResultSet
			rs = pstmt.executeQuery();				
			
			//6.���ڵ庰�� ���� ó��
			
			while(rs.next()) {
				int d1 = rs.getInt(1);
				String d2 = rs.getString(2);
				String d3 = rs.getString(3);
			
				System.out.print("��� : "+d1+"\t");
				System.out.print("�����  : "+d2+"\t");
				System.out.print("�н����� : "+d3+"\t");
				
				System.out.println("");
				
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	}
	
	public static void orderlist(PreparedStatement pstmt) {
		try {
					
			//5.����
			//DBMS�� ���� �� ������� �������ִ� ��ü : ResultSet
			rs = pstmt.executeQuery();				
			
			//6.���ڵ庰�� ���� ó��
			
			while(rs.next()) {
				int d1 = rs.getInt(1);
				int d2 = rs.getInt(2);
				int d3 = rs.getInt(3);
				int d4 = rs.getInt(4);
				int d5 = rs.getInt(5);
				int d6 = rs.getInt(6);
				Date d7 = rs.getDate(7);
				
				System.out.print("���� : "+d1+"\t");
				System.out.print("����  : "+d2+"\t");
				System.out.print("��ȣ : "+d3+"\t");
				System.out.print("���Ĺ�ȣ : "+d4+"\t");
				System.out.print("���  : "+d5+"\t");
				System.out.print("���ֹ��ݾ� : "+d6+"\t");
				System.out.print("�ֹ����� : "+d7+"\t");
				
				System.out.println("");
				
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	}
}
