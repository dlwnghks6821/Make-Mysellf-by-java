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



		
				}catch (ClassNotFoundException e) {
					System.out.println("jdbc driver �ε� ����");
				} catch (SQLException e) {
					System.out.println("����Ŭ ���� ����");
				}