package test;
import java.util.*;
import java.sql.*;
public class DBCon5 {
	public static void main(String[] args) {
try{
	Scanner s = new Scanner(System.in);
System.out.println("Enter the USERNAME");
String uname=s.nextLine();
System.out.println("Enter the PASSWORD");
String pword=s.nextLine();
System.out.println("Enter the FISRTNAME");
String fname=s.nextLine();
System.out.println("Enter the LASTNAME");
String lname=s.nextLine();
System.out.println("Enter the ADDRESS");
String addr=s.nextLine();
System.out.println("Enter the PHNUMBER");
Long phno=Long.parseLong(s.nextLine());
System.out.println("Enter the MAILID");
String mid=s.nextLine();
Class.forName("oracle.jdbc.driver.OracleDriver");
Connection con=DriverManager.getConnection
("jdbc:oracle:thin:@localhost:1521:XE","scott","tiger");
PreparedStatement ps=con.prepareStatement
("insert into USERRESG28 values(?,?,?,?,?,?,?)");
ps.setString(1,uname );
ps.setString(2,pword);
ps.setString(3,fname);
ps.setString(4,lname);
ps.setString(5,addr);
ps.setString(6,mid);
ps.setLong(7,phno);
int k=ps.executeUpdate();
if(k>0) {
	

System.out.println("Data Inserted....");
}
con.close();
s.close();
}//end of try
catch(Exception e) {e.printStackTrace();}
}
}
