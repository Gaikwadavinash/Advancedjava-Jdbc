/*1st procedure are created then insert the data */
/*insert the data by callable Statement*/
package test;
import java.util.*;
import java.sql.*;
public class DBCon1{
public static void main(String[] args) {
Scanner s=null;
Connection con=null;
try {
s=new Scanner(System.in);
System.out.println("Enter the uName");
String uName=s.nextLine();
System.out.println("Enter the pWord");
String pWord=s.nextLine();
System.out.println("Enter the fName");
String fName=s.nextLine();
System.out.println("Enter the lName");
String lName=s.nextLine();
System.out.println("Enter the age");
int age=Integer.parseInt(s.nextLine());
System.out.println("Enter the addr");
String addr=s.nextLine();
System.out.println("Enter the phNo");
long phNo=Long.parseLong(s.nextLine());
System.out.println("Enter the mid");
String mid=s.nextLine();
Class.forName("oracle.jdbc.driver.OracleDriver");
con=DriverManager.getConnection
("jdbc:oracle:thin:@localhost:1521:XE","scott","tiger");
CallableStatement cs=con.prepareCall
("{call userData28(?,?,?,?,?,?,?,?)}");
cs.setString(1,uName);
cs.setString(2, pWord);
cs.setString(3,fName);
cs.setString(4,lName);
cs.setInt(5,age);
cs.setString(6, addr);
cs.setLong(7,phNo);
cs.setString(8,mid);
cs.execute();
System.out.println("Data Updated Sucessfull Two Tables");
}
catch(SQLIntegrityConstraintViolationException icve) {
	System.out.println("Invalid procedure");
}
catch(ClassNotFoundException cnfe){
	System.out.println("Connection or Query related ");
}
catch(SQLException e) {
	System.out.println("Driver related");
}
finally {
	if(s!=null)
		s.close();
	if(con!=null) {
}try {
	con.close();
}catch(Exception e) {e.printStackTrace();}
	}//end finally
}
}