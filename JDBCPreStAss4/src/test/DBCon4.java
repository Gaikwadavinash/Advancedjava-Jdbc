package test;
import java.sql.*;
import java.util.*;
public class DBCon4 {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
try {
	Scanner s= new Scanner(System.in);
System.out.println("Enter the Empid");
String id =s.nextLine();
Class.forName("oracle.jdbc.driver.OracleDriver");
Connection con=DriverManager.getConnection
("jdbc:oracle:thin:@localhost:1521:XE","scott","tiger");
PreparedStatement ps=con.prepareStatement
("SELECT *FROM EMPLOYEE28 WHERE id=?");
ps.setString(1,id);
ResultSet rs=ps.executeQuery();
while(rs.next()) {
	System.out.println("Name:"+rs.getString(2)+"\nDesg:"+
rs.getString(3)+"\nSal:"+rs.getInt(4));
}
		}catch(Exception e){e.printStackTrace();}
	}

}
