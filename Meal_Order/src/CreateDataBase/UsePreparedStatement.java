package CreateDataBase;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.SQLException;


//sql���� preparesatatment�� ��Ƽ� �װ� �������ִ� Ŭ����
public class UsePreparedStatement {

	private static PreparedStatement st = null;
	
	public UsePreparedStatement() {	}
	
	public static PreparedStatement getprestat(Connection conn,String sql) {
		try {
			st = conn.prepareStatement(sql);
		} catch (SQLException e) {
			System.out.println("���� : "+e);
		}
		return st;
	}
}
