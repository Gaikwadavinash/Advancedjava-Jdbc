package test;
import java.sql.*;
public class DScrollable1 {
	public static void main(String[] args) {
try {
Class.forName("oracle.jdbc.driver.OracleDriver");
Connection con=DriverManager.getConnection
("jdbc:oracle:thin:@localhost:1521:XE","scott","tiger");
PreparedStatement ps=con.prepareStatement
("select *from product28",1004,1007);
ResultSet rs=ps.executeQuery();
rs.afterLast();
System.out.println("Display the table in previous order");
while(rs.previous()) {
	System.out.println(rs.getString(1)+"\t"+rs.getString(2)+
"\t"+rs.getFloat(3)+"\t"+rs.getInt(4));
}
System.out.println("Display the 2nd Row Data");
rs.absolute(2);
	System.out.println(rs.getString(1)+"\t"+rs.getString(2)+
"\t"+rs.getFloat(3)+"\t"+rs.getInt(4));

}catch(Exception e) {e.printStackTrace();}
	}
}
