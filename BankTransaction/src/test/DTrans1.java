package test;
import java.io.IOException;
import java.sql.*;
import java.util.*;
public class DTrans1 {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
Scanner s=null;
Connection con=null;
try {
s=new Scanner(System.in);
System.out.println("Enter the accNo(Home)");
String accNo=s.nextLine();
Class.forName("oracle.jdbc:driver.OracleDriver");
con=DriverManager.getConnection
("jdbc:oracle:thin:@localhost:1521:XE","scott","tiger");
PreparedStatement ps1=con.prepareStatement
("select *from bank28 where bal=bal+ ? where accNo=? ");
con.setAutoCommit(false);
con.setSavepoint(); 
ps1.setString(1,accNo);
ResultSet rs=ps1.executeQuery();
if(rs.next()) {
Float bal=rs.getFloat(3);
System.out.println("Enter the accNo2(Benificary....)");
long accNo2=Long.parseLong(s.nextLine());
ps1.setLong(1,accNo2);
ResultSet rs2=ps1.executeQuery();
if(rs2.next()) {
	
}else
ps1.setFloat(2,);	
}else {
	System.out.println("Invalid accNo....");
}
}catch(SQLIntegrityConstraintViolationException icve) {
	
System.out.println("Invalid procedure or Duplicate related Issue");
}
catch(IOException ioe) {
System.out.println("File related Exception");
}
catch(ClassNotFoundException cnf) {
	System.out.println("Driver related Exception");
}
catch(SQLException e) {
	System.out.println("Connection or Query related Issue");
}
}
}
