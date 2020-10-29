import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class NewTest1 {

	public static void main(String[] args) {
		//정해져있음//
		String driver = "oracle.jdbc.driver.OracleDriver";
		//localhost 부터 공통이 아님 포트번호 , 주소가 필요//
		String url = "jdbc:oracle:thin:@localhost:1521:orcl";
		//user id //
		String user = "system";
		//password//
		String password = "human123";
			try {
					Class.forName(driver);
					Connection conn = DriverManager.getConnection(url, user, password);
			System.out.println("오라클 연결 성공");
			System.out.println("jdbc driver 로딩 성공"); 
			Scanner sc1= new Scanner(System.in);		
			Scanner sc2= new Scanner(System.in);
			Scanner sc3 = new Scanner(System.in);
			Scanner sc4 = new Scanner (System.in);
			Scanner sc5 = new Scanner(System.in);
			Scanner sc6 = new Scanner(System.in);
			Scanner t  = new Scanner(System.in);
			Scanner w = new Scanner(System.in);
			Scanner u = new Scanner(System.in);
			System.out.println("1.메뉴추가 2.메뉴제거 3.메뉴수정 4.메뉴조회 0.종료");
			int select1 = sc1.nextInt();
			while(select1!=0) {
				switch(select1) {
				case 1:
					String sql1="insert into  fruits values(?,?)";
					 PreparedStatement ps1 = conn.prepareStatement(sql1);
					 System.out.println("추가할 메뉴를 입력해주세요.");
		    		 String menu1 = sc2.nextLine();

		    		 while(!menu1.equals("")) {
		    			 System.out.println("가격을 입력해주세요");
		    			 int price1 = sc3.nextInt();
		    			 ps1.setString(1,menu1);
		    			 ps1.setInt(2, price1);
		    			 ps1.executeUpdate();
		    			 System.out.println("추가할 메뉴를 입력해주세요.");
		 		    	 menu1 = sc2.nextLine();
		 		    	 
		    		 }
		    		 ps1.close();
		    		 break;
		    		 
				case 2:
					String sql2 = "delete from fruits where name=?";
				    PreparedStatement ps2 = conn.prepareStatement(sql2);
				    System.out.println("삭제할 과일 이름을 입력해주세요.");
				    String fruitName = sc4.nextLine();
				    while(!fruitName.equals("")) {
				    	ps2.setString(1, fruitName);
				    	ps2.executeUpdate();
				    	System.out.println("삭제할 과일 이름을 입력해주세요.");
					    fruitName = sc4.nextLine();
				    	
				    }
				    ps2.close();
				    break;
				  
				case 3:
					String sql3="update menu set name=?, price=? where name=?";
					PreparedStatement ps3 = conn.prepareStatement(sql3);
					System.out.println("바꾸실 기존메뉴 이름을 입력하세요(공백 입력시 종료)");
					String m5 = t.nextLine();
					while(!m5.equals("")) {
						String oldmenu =m5;
						System.out.println("바꾸실 새로운 메뉴 이름을 입력하세요(취소시 기존메뉴이름 입력)");
						String m6 = w.nextLine();
						String newmenu =m6;
						System.out.println("바꾸실 새로운 메뉴의 가격을 입력하세요(취소시 기존메뉴가격 입력)");
						int m7 = u.nextInt();
						int newprice = m7;
						ps3.setString(1, newmenu);
						ps3.setInt(2, newprice);
						ps3.setString(3, oldmenu);
						ps3.executeUpdate();
						System.out.println("바꾸실 기존메뉴 이름을 입력하세요(공백 입력시 종료)");
						m5 = t.nextLine();
						
					}
				   ps3.close();
				
				   break;
				case 4:
					String sql = "select *from fruits";
					Statement stmt=null;
					stmt=conn.createStatement();
					ResultSet rs=stmt.executeQuery(sql);
					System.out.println("메뉴 | 가격");
					while(rs.next()) {
						String me_name=rs.getString("name");
						int me_price=rs.getInt("price");
						System.out.println(me_name +" | "+me_price);
					}
					stmt.close();
					break;
				
				
				
				
				
				}
				System.out.println("1.메뉴추가 2.메뉴제거 3.메뉴수정 4.메뉴조회 0.종료");
				select1 = sc1.nextInt();
			
				
			
			}		
			System.out.println("종료되었습니다.");
			conn.close();
					
					
				}catch (ClassNotFoundException e) {
					System.out.println("jdbc driver 로딩 실패");
				} catch (SQLException e) {
					System.out.println("오라클 연결 실패");
				}

	}

}
