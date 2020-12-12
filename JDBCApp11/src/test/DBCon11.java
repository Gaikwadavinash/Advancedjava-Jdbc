/*product delete to DataBase Table based on pid */
package test;
import java.util.*;
import java.sql.*;
public class DBCon11 {
public static void main(String[] args) {
		// TODO Auto-generated method stub
try {
	Scanner s= new Scanner(System.in);
System.out.println("Enter the PID");
String PID=s.nextLine();
Class.forName("oracle.jdbc.driver.OracleDriver");
Connection con=DriverManager.getConnection
("jdbc:oracle:thin:@localhost:1521:XE","scott","tiger");
PreparedStatement ps1=con.prepareStatement
("SELECT *FROM PRODUCT28 WHERE PID=?");
ps1.setString(1,PID);
ResultSet rs=ps1.executeQuery();
if(rs.next()) {
System.out.println("Display Product Id:"+rs.getString(1));
PreparedStatement ps2=con.prepareStatement
("DELETE FROM PRODUCT28 WHERE PID=?");
ps2.setString(1,PID);
int k=ps2.executeUpdate();
if(k>0) {
	System.out.println("Data Deleted....");
}
}
}catch(Exception e) {e.printStackTrace();}
	
	}

}
