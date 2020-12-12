/*JDBCApp8 Project Folder Same as Class sir*/
package test;
import java.sql.*;
import java.util.*;
public class DBAssignment2 {
public static void main(String[] args) {
try {
Scanner s= new Scanner(System.in);
System.out.println("Enter the Book Code");
String BCODE= s.nextLine();
System.out.println("Enter the Book Name");
String BNAME=s.nextLine();
System.out.println("Enter the Book Author Name");
String BAUTHOR=s.nextLine();
System.out.println("Enter the Book Price");
float BPRICE=Float.parseFloat(s.nextLine());
System.out.println("Enter the Book Qty");
Integer BQTY=Integer.parseInt(s.nextLine());
	Class.forName("oracle.jdbc.driver.OracleDriver");
Connection con=DriverManager.getConnection
("jdbc:oracle:thin:@localhost:1521:XE","scott","tiger");
PreparedStatement ps=con.prepareStatement
("INSERT INTO BOOKDETAILS28 VALUES(?,?,?,?,?)");
ps.setString(1,BCODE);
ps.setString(2,BNAME );
ps.setString(3,BAUTHOR);
ps.setFloat(4, BPRICE);
ps.setInt(5, BQTY);
int k=ps.executeUpdate();
if(k>0)
{
	System.out.println("............Data Inserted..........");
}
s.close();
con.close();
}//end of try
catch(Exception e) {e.printStackTrace();}
	}

}
