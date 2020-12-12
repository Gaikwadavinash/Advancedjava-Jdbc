/*Updating Phone Number db Table USERRESG28*/
package test;
//import java.awt.datatransfer.SystemFlavorMap;
import java.sql.*;
import java.util.*;

//import javax.swing.text.html.HTMLDocument.HTMLReader.PreAction;
public class DBCon9 {
	public static void main(String[] args) {
try {
Scanner s= new Scanner(System.in);
System.out.println("Enter the UserName:");
String UNAME=s.nextLine();
System.out.println("Enter the PassWord");
String PWORD=s.nextLine();
Class.forName("oracle.jdbc.driver.OracleDriver");
Connection con = DriverManager.getConnection
("jdbc:oracle:thin:@localhost:1521:XE","scott","tiger");
PreparedStatement ps1=con.prepareStatement
("SELECT *FROM USERRESG28 WHERE UNAME=? AND PWORD=?");
ps1.setString(1, UNAME);
ps1.setString(2, PWORD);
ResultSet rs=ps1.executeQuery();
if(rs.next()){
	System.out.println("Display The PhoneNo:"+
rs.getLong(6));
	System.out.println("Enter The New Phone No.");
long PHNO=Long.parseLong(s.nextLine());
PreparedStatement ps2=con.prepareStatement
("UPDATE USERRESG28 SET PHNO=? WHERE UNAME=? AND PWORD=?");
ps2.setLong(1,PHNO);
ps2.setString(2,UNAME);
ps2.setString(3,PWORD);
int k=ps2.executeUpdate();
if(k>0) {
	/*System.out.println("FirstName:"+rs.getString(3)
+"\nLastName:"+rs.getString(4)+"\nAddr:"+rs.getString(5)+
"\nPhNo:"+rs.getLong(2)+"\nMid:"+rs.getString(7));*/
	System.out.println("Data Upadated...");
}
System.out.println("Data Upadated...");
}else {
	System.out.println("Invalid UserName and PassWord");
}
}catch(Exception e) {e.printStackTrace();}		
		
	}

}
