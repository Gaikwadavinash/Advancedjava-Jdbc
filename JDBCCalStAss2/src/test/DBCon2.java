
/*Procedure are created 1st the Insert the data thorugh procedure name*/
/* Insert Data into Employee Details 2 table using Callable Statements*/
package test;
import java.util.*;
import java.sql.*;
public class DBCon2 {
	public static void main(String[] args) {
Scanner	 s=null;
Connection con=null;
try {
	s=new Scanner(System.in);
System.out.println("Enter the eId");
String eId=s.nextLine();
System.out.println("Enter the eName");
String eName=s.nextLine();
System.out.println("Enter the eDesg");
String eDesg=s.nextLine();
System.out.println("Enter the bSal");
float bSal=Float.parseFloat(s.nextLine());
System.out.println("Enter the sName");
String sName=s.nextLine();
System.out.println("Enter the city");
String city=s.nextLine();
System.out.println("Enter the pincode");
int pincode=Integer.parseInt(s.nextLine());

Class.forName("oracle.jdbc.driver.OracleDriver");
con=DriverManager.getConnection
("jdbc:oracle:thin:@localhost:1521:XE","scott","tiger");
CallableStatement cs=con.prepareCall
("{call CreateEmpData28(?,?,?,?,?,?,?)}");
cs.setString(1,eId);
cs.setString(2, eName);
cs.setString(3, eDesg);
cs.setFloat(4,bSal);
cs.setString(5, sName);
cs.setString(6,city );
cs.setInt(7,pincode );
cs.execute();
System.out.println("Data Updated Two tables..");
}catch(	SQLIntegrityConstraintViolationException icve) {
	System.out.println("Invalid Procedure ");
}catch(ClassNotFoundException cnfe) {
	System.out.println("Connection or query related");
}catch(SQLException e) {
	System.out.println("Driver related.. ");
}
finally {
	if(s!=null)s.close();
	if(con!=null) {
		try {
			con.close();
		}catch(Exception e) {e.printStackTrace();}
	}
}
	}
}
