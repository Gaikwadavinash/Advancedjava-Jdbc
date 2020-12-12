/*Update the Adress in DataBase Table*/
package test;
import java.util.*;
import java.sql.*;
public class DBCon9_4 {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
try {
Scanner s= new Scanner(System.in);
System.out.println("Enter the Id");
int ID=Integer.parseInt(s.nextLine());
System.out.println("Enter the Name");
String NAME=s.nextLine();
Class.forName("oracle.jdbc.driver.OracleDriver");
Connection con=DriverManager.getConnection
("jdbc:oracle:thin:@localhost:1521:XE","scott","tiger");
PreparedStatement ps1=con.prepareStatement
("SELECT *FROM CUSTOMER28 WHERE ID=? AND NAME=?");
ps1.setInt(1,ID);
ps1.setString(2,NAME);
ResultSet rs=ps1.executeQuery();
if(rs.next()) {
System.out.println("Display the Address:"+rs.getString(4));
System.out.println("Enter the Adress:");
String ADDRESS=s.nextLine();
PreparedStatement ps2=con.prepareStatement
("UPDATE CUSTOMER28 SET ADDRESS=? WHERE ID=? AND NAME=?");
ps2.setString(1,ADDRESS);
ps2.setInt(2,ID);
ps2.setString(3,NAME);
int k=ps2.executeUpdate();
if(k>0){
	System.out.println("Data Updated...");
}
}
else {
	System.out.println("Invalid Id And Name");
}
}catch(Exception e) {e.printStackTrace();}
		
		
	}

}
