/*Update the book price based on book details */
package test;
import java.sql.*;
import java.util.*;
public class DBCon7 {
	public static void main(String[] args) {
try {
Scanner s= new Scanner(System.in);
System.out.println("Enter the Bcode..");
String BCODE=s.nextLine();
Class.forName("oracle.jdbc.driver.OracleDriver");
Connection con=DriverManager.getConnection
("jdbc:oracle:thin:@localhost:1521:XE","scott","tiger");
PreparedStatement ps1=con.prepareStatement
("SELECT *FROM BOOKDETAILS28 WHERE BCODE=?");
ps1.setString(1,BCODE);
ResultSet rs=ps1.executeQuery();
if(rs.next()) {
System.out.println("Display the price:"+rs.getFloat(4));
System.out.println("Enter the New Price of Book...");
float BPRICE=Long.parseLong(s.nextLine());
PreparedStatement ps2=con.prepareStatement
("UPDATE BOOKDETAILS28 SET BPRICE=? WHERE BCODE=?");
ps2.setFloat(1,BPRICE);
ps2.setString(2,BCODE);
int k=ps2.executeUpdate();
if(k>0) {
	/*System.out.println("BName:"+rs.getString(2)+
"\nBAuthor:"+rs.getString(3)+"\nBPrice:"+rs.getFloat(4)+
"\nBQty:"+rs.getInt(5));*/
	System.out.println("Data Updated");
}
}//end if
else {
	System.out.println("Invalid bookCOde");
}//end else
}//end of try
catch(Exception e) {e.printStackTrace();}
		
	}

}
