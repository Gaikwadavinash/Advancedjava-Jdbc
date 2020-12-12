/*callable statement*/
package test;
import java.sql.*;
import java.util.*;
public class DBCon12 {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
Scanner s=null;
Connection con=null;
try {
s= new Scanner(System.in);
System.out.println("Enter the AccNo");
long accNo=Long.parseLong(s.nextLine());

System.out.println("Enter the CustName");
String custName=s.nextLine();

System.out.println("Enter the Balance");
float bal=Float.parseFloat(s.nextLine());

System.out.println("Enter the AccType");
String accType=s.nextLine();

System.out.println("Enter the Adress");
String addr=s.nextLine();

System.out.println("Enter the PhoneNo");
long phNo=Long.parseLong(s.nextLine());
	
Class.forName("oracle.jdbc.driver.OracleDriver");
con=DriverManager.getConnection
("jdbc:oracle:thin:@localhost:1521:XE","scott","tiger");
CallableStatement cs=con.prepareCall
("{call CreateAccount28(?,?,?,?,?,?)}");
cs.setLong(1,accNo);
cs.setString(2,custName);
cs.setFloat(3,bal);
cs.setString(4,accType);
cs.setString(5,addr);
cs.setLong(6,phNo);
cs.execute();
System.out.println("successfully....");
}
catch(SQLIntegrityConstraintViolationException icve) {
	System.out.println("Invalid procedure");
}
catch(ClassNotFoundException cnfe) {
	System.out.println("driver related");
}
catch(SQLException e) {
	System.out.println("Connection or query Realted ");
}
finally {
	if(con!=null) {
		try {
		con.close();	
		}catch(SQLException e) {e.printStackTrace();}
	}
	if(s!=null)
		s.close();
}//end fi
	}

}
