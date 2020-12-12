package test;
import java.sql.*;
public class UpdateAvg {
	public static void main(String[] args){
		// TODO Auto-generated method stub
		try {
			//Scanner s=new Scanner(System.in);
		//	System.out.println("Enter the EmpNo");
//String NAME=s.nextLine();
Class.forName("oracle.jdbc.driver.OracleDriver");
Connection con=DriverManager.getConnection
("jdbc:oracle:thin:@localhost:1521:XE","scott","tiger");
Statement stm=con.createStatement();
ResultSet rs=stm.executeQuery
("UPDATE EMPLOYEE28 SET SAL=10000*2");
int k = 0;
	while (k>0){
System.out.println(+rs.getFloat(1));
//System.out.println("Data updated...");
		}
	System.out.println("Data updated...");
}catch(Exception e) {e.printStackTrace();}
	
}
}

	