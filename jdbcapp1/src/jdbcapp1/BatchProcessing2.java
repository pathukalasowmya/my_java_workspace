package jdbcapp1;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.UUID;



public class BatchProcessing2 {
 private static connection connection;

public static void main(String[] args) throws ClassNotFoundException, SQLException {
	String driver,url,userName,password;
	driver="com.mysql.cj.jdbc.Driver";//driver class present in this 
	url ="jdbc:mysql://localhost:3306/db11223";
	userName = "root";
	password ="root";
	
	String INSERT_QUERY1 = "insert into employee values(101,'Wills',55000)";
	String INSERT_QUERY2 = "insert into employee values(102,'Smith',55000)";
	String INSERT_QUERY3 = "insert into employee values(103,'Jones',55000)";
	String INSERT_QUERY4 = "insert into employee values(104,'Alice',55000)";
	String INSERT_QUERY5 = "insert into employee values(105,'Alex',55000)";


	
	//1.loading driverClass
		//it is optional from java 1.5vDisplayEmployeeDetails.java
		Class.forName(driver);
		
		//2.Establish connection
		Connection con =DriverManager.getConnection(url,userName,password);
		
		//3. Create statement /preparedStatement/callableStatement object
		 Statement statement = con.createStatement();
		 statement.addBatch("INSERT INTO EMPLOYEE(ID, NAME, SAL , MOBILE) "
		  + "VALUES (101,'Wills','55000',9988776655)");
		 statement.addBatch("INSERT INTO EMPLOYEE(ID, NAME, SAl,MOBILE) "
		  + "VALUES (102,'Smith','55000',8899776655)");
		 statement.addBatch("INSERT INTO EMPLOYEE(ID, NAME, SAL,MOBILE) "
				  + "VALUES (103,'Jones','55000',9876543210)");
		 statement.addBatch("INSERT INTO EMPLOYEE(ID, NAME, SAL,MOBILE) "
				  + "VALUES (104,'Alice','55000',7788334455)");
		 statement.addBatch("INSERT INTO EMPLOYEE(ID, NAME, SAL,MOBILE) "
				  + "VALUES (105,'Alex','55000',8976543220)");
		 
		 String[] EMPLOYEE = new String[]{"Wills","Smith","Jones","Alice","Alex"};
		 int[] Sal = new int[]{55000,55000,55000,55000,55000};

		 String insertEmployeeSQL = "INSERT INTO EMPLOYEE(ID, NAME, Sal,MOBILE) "
		  + "VALUES (?,?,?,?)";

		PreparedStatement ps = connection.prepareStatement(insertEmployeeSQL);
		 
		for(int i = 0; i < EMPLOYEE.length; i++){
		    String employeeId = UUID.randomUUID().toString();
		    ps.setInt(1,eid);
		    ps.setString(2,"Wills"[i]);
		    ps.setLong(3,Sal[i]);
		    ps.addBatch();
		}
		ps.executeBatch();
	
		 statement.executeBatch();
		//5.close resources
	     ps.close();
	     con.close();
}
}

