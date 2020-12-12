package test;
import java.sql.*;
import java.util.*;
public class DBCon7 {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
try {
@SuppressWarnings("resource")
Scanner s= new Scanner(System.in);
System.out.println("Enter the BookCode");
String BCODE=s.nextLine();
Class.forName("oracle.jdbc.driver.OracleDriver");
Connection con=DriverManager.getConnection
("jdbc:oracle:thin:@localhost:1521:XE","scott","tiger");
PreparedStatement ps=con.prepareStatement
("SELECT *FROM BOOKDETAILS28 WHERE BCODE=?");
ps.setString(1,BCODE);
ResultSet rs=ps.executeQuery();
if(rs.next()) {
	System.out.println("BName:"+rs.getString(2)+"\nAuthorname:"+rs.getString(3)+"\nBprice:"+rs.getFloat(4)+
			"\nBqty:"+rs.getInt(5));
}//
else {
	System.out.println("Book Code is Invald ");
}
}//end of try
catch(Exception e) {e.printStackTrace();}
	}

}
