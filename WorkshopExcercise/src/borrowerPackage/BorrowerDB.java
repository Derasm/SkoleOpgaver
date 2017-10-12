package borrowerPackage;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import sun.security.jca.GetInstance.Instance;

public class BorrowerDB {
	private Connection connection = null;
	private static BorrowerDB borrowerDB; 
	private static final String driverClass = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
	private static final String dbName = "borrower";
	private static final String serverAddress = "192.168.56.2";
	private static final int serverPort = 1433;
	private static final String userName = "sa";
	private static final String passWord = "secret";
	
	private BorrowerDB() {
		String ConnectionString = String.format("jdbc:sqlserver://%s:%d;databasename=%s;user=%s;password=%s",
		serverAddress, serverPort, dbName, userName, passWord);
		try {
			Class.forName(driverClass);
			connection = DriverManager.getConnection(ConnectionString); 
		} catch (ClassNotFoundException e) {
			System.out.println("could not load JDBC Driver");
			e.printStackTrace();
		} catch (SQLException e) {
			System.out.println("could not connect to database");
			e.printStackTrace();
		}
	}
	
	public static BorrowerDB getInstance() {
		if(borrowerDB == null) {
			borrowerDB = new BorrowerDB();
		} 
		return borrowerDB; 
		
			
	}
	
}
