/*Delete book details based on Bcode*/
package test;
import java.util.*;
import java.sql.*;
public class DBCon8 {
public static void main(String[] args) {
	Scanner s=null;
	Connection con=null;
try {
	s= new Scanner(System.in);
System.out.println("Enter the Bcode");
String BCODE=s.nextLine();
Class.forName("oracle.jdbc.driver.OracleDriver");
con=DriverManager.getConnection
("jdbc:oracle:thin:@localhost:1521:XE","scott","tiger");
PreparedStatement ps1=con.prepareStatement
("SELECT *FROM BOOKDETAILS28 WHERE BCODE=?");
ps1.setString(1, BCODE);
ResultSet rs=ps1.executeQuery();
if(rs.next()) {
//System.out.println("Display the Book code Details..:");
PreparedStatement ps2=con.prepareStatement
("DELETE FROM BOOKDETAILS28 WHERE BCODE=?");
ps2.setString(1,BCODE);	
int k=ps2.executeUpdate();
if(k>0) {
	System.out.println("Data Delete..");}
}
else {	
System.out.println("Book Code Is Not valid");
}
}
catch(Exception e ){e.printStackTrace();}
}
}
