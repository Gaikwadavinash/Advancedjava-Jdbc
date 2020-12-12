/*Retriving data From DataBase using Prcedure*/
package test;
import java.sql.*;
import java.util.*;
public class DBCon13 {
	public static void main(String[] args) {
		
Scanner s=null;
Connection con=null;
try {
s= new Scanner(System.in);
System.out.println("Enter the eId");
String eId=s.nextLine();
Class.forName("oracle.jdbc.driver.OracleDriver");
con=DriverManager.getConnection
("jdbc:oracle:thin:@localhost:1521:XE","scott","tiger");

}catch(SQLIntegrityConstraintViolationException icve) {
System.out.println("Procedure or Duplicated related Issue");	
}
catch(ClassNotFoundException cn) {
	System.out.println("Connection or Queries Related Issue");
}
catch(SQLException e) {
	System.out.println("Driver Related Issue");
}
finally {
	if(s!=null)
    s.close();
	if(con!=null)
		try {
con.close();			
		}catch(Exception e) {e.printStackTrace();}
}

	}
}
