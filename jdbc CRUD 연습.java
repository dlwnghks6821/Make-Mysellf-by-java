import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class NewTest1 {

	public static void main(String[] args) {
		//����������//
		String driver = "oracle.jdbc.driver.OracleDriver";
		//localhost ���� ������ �ƴ� ��Ʈ��ȣ , �ּҰ� �ʿ�//
		String url = "jdbc:oracle:thin:@localhost:1521:orcl";
		//user id //
		String user = "system";
		//password//
		String password = "human123";
			try {
					Class.forName(driver);
					Connection conn = DriverManager.getConnection(url, user, password);
			System.out.println("����Ŭ ���� ����");
			System.out.println("jdbc driver �ε� ����"); 
			Scanner sc1= new Scanner(System.in);		
			Scanner sc2= new Scanner(System.in);
			Scanner sc3 = new Scanner(System.in);
			Scanner sc4 = new Scanner (System.in);
			Scanner sc5 = new Scanner(System.in);
			Scanner sc6 = new Scanner(System.in);
			Scanner t  = new Scanner(System.in);
			Scanner w = new Scanner(System.in);
			Scanner u = new Scanner(System.in);
			System.out.println("1.�޴��߰� 2.�޴����� 3.�޴����� 4.�޴���ȸ 0.����");
			int select1 = sc1.nextInt();
			while(select1!=0) {
				switch(select1) {
				case 1:
					String sql1="insert into  fruits values(?,?)";
					 PreparedStatement ps1 = conn.prepareStatement(sql1);
					 System.out.println("�߰��� �޴��� �Է����ּ���.");
		    		 String menu1 = sc2.nextLine();

		    		 while(!menu1.equals("")) {
		    			 System.out.println("������ �Է����ּ���");
		    			 int price1 = sc3.nextInt();
		    			 ps1.setString(1,menu1);
		    			 ps1.setInt(2, price1);
		    			 ps1.executeUpdate();
		    			 System.out.println("�߰��� �޴��� �Է����ּ���.");
		 		    	 menu1 = sc2.nextLine();
		 		    	 
		    		 }
		    		 ps1.close();
		    		 break;
		    		 
				case 2:
					String sql2 = "delete from fruits where name=?";
				    PreparedStatement ps2 = conn.prepareStatement(sql2);
				    System.out.println("������ ���� �̸��� �Է����ּ���.");
				    String fruitName = sc4.nextLine();
				    while(!fruitName.equals("")) {
				    	ps2.setString(1, fruitName);
				    	ps2.executeUpdate();
				    	System.out.println("������ ���� �̸��� �Է����ּ���.");
					    fruitName = sc4.nextLine();
				    	
				    }
				    ps2.close();
				    break;
				  
				case 3:
					String sql3="update menu set name=?, price=? where name=?";
					PreparedStatement ps3 = conn.prepareStatement(sql3);
					System.out.println("�ٲٽ� �����޴� �̸��� �Է��ϼ���(���� �Է½� ����)");
					String m5 = t.nextLine();
					while(!m5.equals("")) {
						String oldmenu =m5;
						System.out.println("�ٲٽ� ���ο� �޴� �̸��� �Է��ϼ���(��ҽ� �����޴��̸� �Է�)");
						String m6 = w.nextLine();
						String newmenu =m6;
						System.out.println("�ٲٽ� ���ο� �޴��� ������ �Է��ϼ���(��ҽ� �����޴����� �Է�)");
						int m7 = u.nextInt();
						int newprice = m7;
						ps3.setString(1, newmenu);
						ps3.setInt(2, newprice);
						ps3.setString(3, oldmenu);
						ps3.executeUpdate();
						System.out.println("�ٲٽ� �����޴� �̸��� �Է��ϼ���(���� �Է½� ����)");
						m5 = t.nextLine();
						
					}
				   ps3.close();
				
				   break;
				case 4:
					String sql = "select *from fruits";
					Statement stmt=null;
					stmt=conn.createStatement();
					ResultSet rs=stmt.executeQuery(sql);
					System.out.println("�޴� | ����");
					while(rs.next()) {
						String me_name=rs.getString("name");
						int me_price=rs.getInt("price");
						System.out.println(me_name +" | "+me_price);
					}
					stmt.close();
					break;
				
				
				
				
				
				}
				System.out.println("1.�޴��߰� 2.�޴����� 3.�޴����� 4.�޴���ȸ 0.����");
				select1 = sc1.nextInt();
			
				
			
			}		
			System.out.println("����Ǿ����ϴ�.");
			conn.close();
					
					
				}catch (ClassNotFoundException e) {
					System.out.println("jdbc driver �ε� ����");
				} catch (SQLException e) {
					System.out.println("����Ŭ ���� ����");
				}

	}

}
