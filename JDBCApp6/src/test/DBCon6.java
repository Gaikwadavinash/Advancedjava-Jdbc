package test;
import java.sql.*;
import java.util.*;
public class DBCon6 {
public static void main(String[] args) {
try {
Scanner s= new Scanner(System.in);
System.out.println("Enter the UserName");
String  UNAME =s.nextLine();
System.out.println("Enter the PassWord");
String PWORD=s.nextLine();
Class.forName("oracle.jdbc.driver.OracleDriver");
Connection con=DriverManager.getConnection
("jdbc:oracle:thin:@localhost:1521:XE","scott","tiger");
PreparedStatement ps=con.prepareStatement
("SELECT *FROM USERRESG28 WHERE UNAME=? AND PWORD=?");
ps.setString(1,UNAME);
ps.setString(2,PWORD );
ResultSet rs=ps.executeQuery();
if(rs.next()) {
System.out.println("FirstName:"+rs.getString(3)+"\nLastName:"+rs.getString(4)+
		"\nAddress:"+rs.getString(5)+"\nPhoneNo:"+rs.getLong(6)+
		"\nMailId:"+rs.getString(7));	
}else {
	System.out.println("USERNAME AND PASS INVALID");
}//end of else
con.close();
s.close();
}//end of try
catch(Exception e) {e.printStackTrace();}
	}
}
