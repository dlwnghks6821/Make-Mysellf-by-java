import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;


public class Order {
	//--->��ǰ�Է� scanner<---//
	Scanner sc1= new Scanner(System.in);
	//--->�����Է� scanner<---//
	Scanner sc2 = new Scanner(System.in);
	//--->����Ϲ�ȣ �Է� scanner<---//
	Scanner sc3 = new Scanner(System.in);
	//--->����Ϲ�ȣ ArrayList<---//
	ArrayList<String> mobile1 = new ArrayList<String>();
	//--->�޴�ArrayList<---//
	ArrayList<String> menu1 = new ArrayList<String>();
	//--->����ArrayList<---//
	ArrayList<Integer> count1 = new ArrayList<Integer>();
	Order(){
		mobile1 = new ArrayList<String>();
		menu1 = new ArrayList<String>();
		count1= new ArrayList<Integer>();
	}
	//-->addOrder = ��ǰ,����,������ �Է¹޾ƾ���<--//
		void addOrder(Connection conn) throws SQLException {
		String sql1="insert into apap values(?,?,?)";
		 PreparedStatement ps1 = conn.prepareStatement(sql1);
		
		System.out.println("���Ͻô� ��ǰ�� �Է����ּ���.��Ҵ� ����");
        String menu = sc1.nextLine();
        //��ǰ ArrayList����//
        menu1.add(menu);
        while(!menu.equals("")) {
        	System.out.println("������ �Է����ּ���.");
        	int count = sc2.nextInt();
        	//���� ArrayList����//
        	count1.add(count);
        	System.out.println("");
        	System.out.println("����Ϲ�ȣ�� �Է����ּ���.");
            String mobile = sc3.nextLine();
            //����Ϲ�ȣ ArrayList����//
            mobile1.add(mobile);
            //��ǰDB//
			ps1.setString(1,menu );
            //����DB//
            ps1.setInt(2,count);
            //����Ϲ�ȣDB//
            ps1.setString(3, mobile);
            ps1.executeUpdate();
            System.out.println("���Ͻô� ��ǰ�� �Է����ּ���.��Ҵ� ����");
            menu = sc1.nextLine();
            menu1.add(menu);
        }
        
        
	}
    void getMethod() {
    	for(int i = 0 ; i<=mobile1.size();i++) {
    	  System.out.println(mobile1.get(i));
    	}
    	for(int j = 0 ; j<=menu1.size();j++) {
    		System.out.println(menu1.get(j));
    	}
    	for(int k = 0 ; k<=count1.size();k++) {
    		System.out.println(count1.get(k));
    	}
    	
    }

}