package test;

import java.util.Calendar;

import org.omg.PortableServer.THREAD_POLICY_ID;

public class tset3 extends Thread{
	 
	 static int year(long millisec){
	      return (int)((millisec/(3600000)) % 24)+9;
	 }
	 static int month(long millisec){
	      return (int)((millisec/(3600000)) % 24)+9;
	 }
	 static int day(long millisec){
	      return (int)((millisec/(3600000)) % 24)+9;
	 }
	 static int hour(long millisec){
	      return (int)((millisec/(3600000)) % 24)+9;
	 }
	 static int minute(long millisec) {
	      return (int)((millisec/60000) % 60);
	 }
	 static int second(long millisec) {
	      return (int)((millisec/1000) % 60);
	 }
	 
	public static void main(String[] args) {
/*		long millisec = System.currentTimeMillis();
		System.out.println("�� : "+year(millisec));
		System.out.println("�� : "+month(millisec));
		System.out.println("�� : "+month(millisec));
		System.out.println("�� : "+month(millisec));
		System.out.println("�� : "+month(millisec));
		System.out.println("�� : "+month(millisec));
		*/
		
		new tset3().run();

	}
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
		int year = cal.get ( cal.YEAR );
		int month = cal.get ( cal.MONTH ) + 1 ;
		int date = cal.get ( cal.DATE ) ;
		 
		
		 
		//���� (��,��,��)
		int hour = cal.get ( cal.HOUR_OF_DAY ) ;
		int min = cal.get ( cal.MINUTE );
		int sec = cal.get ( cal.SECOND );

		System.out.println("�� : "+year);
		System.out.println("�� : "+month);
		System.out.println("�� : "+date);
		System.out.println("�� : "+hour);
		System.out.println("�� : "+min);
		System.out.println("�� : "+sec);
		}
	}
}
