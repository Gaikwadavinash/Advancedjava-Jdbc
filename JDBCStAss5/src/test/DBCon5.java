package test;
import java.sql.*;
import java.util.*;
public class DBCon5 {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
try {
Scanner s= new Scanner(System.in);
System.out.println("Enter the rollNo");
String rollNo= s.nextLine();
if(rollNo.length()==10){
Class.forName("oracle.jdbc.driver.OracleDriver");
Connection  con=DriverManager.getConnection
("jdbc:oracle:thin:@localhost:1521:XE","scott","tiger");
PreparedStatement ps=con.prepareStatement
("SELECT *FROM STUDENTDATA28 WHERE rollNo=?");
ps.setString(1,rollNo);
ResultSet rs=ps.executeQuery();
if(rs.next()) {
	System.out.println("Uname:"+rs.getString(1)+
"\nBrn:"+rs.getString(3)+"\nPer:"+rs.getFloat(4)+
"\nResult:"+rs.getString(5));
} else {
	System.out.println("Data does Not Match..");
}//
}else {
	System.out.println("Inavlid rollNo length..");
}//end else
}catch(Exception e) {e.printStackTrace();}
		
	}

}
