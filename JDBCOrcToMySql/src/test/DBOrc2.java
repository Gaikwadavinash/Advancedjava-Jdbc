package test;
import java.util.*;
import java.sql.*;
public class DBOrc2 {
	public static void main(String[] args) {
Connection con1=null;
Connection con2=null;
Statement stm1=null;
Statement stm2=null;
PreparedStatement ps2=null;
try {		
con1=DriverManager.getConnection
("jdbc:oracle:thin:@localhost:1521:XE","scott","tiger");
con2=DriverManager.getConnection
("jdbc:mysql://localhost:3306/bookdeatils28",
"root","manager");
con1.createStatement();
ResultSet rs=stm1.executeQuery
("select *from bookdetails28");
int count=0;
while(rs.next()) {
count++;	
String bcode=rs.getString(1);	
PreparedStatement ps=con2.prepareStatement
("insert into bookdetails28 values(?,?,?,?,?)");
ps.setString(1,bcode);

}
}
catch(SQLIntegrityConstraintViolationException icve) {
System.out.println("Duplicate or procedure realted issue ");
}
catch(SQLException e) {
	System.out.println("Connection or Query related Issue");
}
	}
}
