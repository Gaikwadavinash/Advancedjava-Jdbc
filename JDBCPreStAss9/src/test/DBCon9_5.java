/*Delete the record from database based on Name*/
package test;
import java.sql.*;
import java.util.*;
public class DBCon9_5 {
public static void main(String[] args) {
		// TODO Auto-generated method stub
try {
Scanner s=new Scanner(System.in);
System.out.println("Enter the Name:");
String NAME=s.nextLine();
Class.forName("oracle.jdbc.driver.OracleDriver");
Connection con=DriverManager.getConnection
("jdbc:oracle:thin:@localhost:1521:XE","scott","tiger");
PreparedStatement ps1=con.prepareStatement
("SELECT *FROM CUSTOMER28 WHERE NAME=?");
ps1.setString(1,NAME);
ResultSet rs=ps1.executeQuery();
if(rs.next()) {
PreparedStatement ps2=con.prepareStatement
("DELETE FROM CUSTOMER28 WHERE NAME=?");
ps2.setString(1,NAME);
int k=ps2.executeUpdate();
if(k>0){
System.out.println("Data Deleted.....");	
}
}else {
	System.out.println("Invalid Name..");
}
}catch(Exception e) {e.printStackTrace();}
	
	}

}
