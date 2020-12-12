package test;
import java.sql.*;
import java.util.*;
public class DBCon4 {
public static void main(String[] args) {
	try {
	Scanner s= new Scanner(System.in);
	Class.forName("oracle.jdbc.driver.OracleDriver");
	Connection con=DriverManager.getConnection
	("jdbc:oracle:thin:@localhost:1521:XE","scott","tiger");
	PreparedStatement ps=con.prepareStatement
("INSERT INTO BOOKDETAILS28 VALUES(?,?,?,?,?)"); 
	System.out.println("Enter the No Book.... ");
int n=Integer.parseInt(s.nextLine());
for(int i=1;i<=n;i++) {
System.out.println("Enter the BCODE");
String BCODE=s.nextLine();
System.out.println("Enter the BNAME");
String BNAME=s.nextLine();
System.out.println("Enter the BAUTHOR");
String BAUTHOR=s.nextLine();
System.out.println("Enter the BPRICE");
Float BPRICE=Float.parseFloat(s.nextLine());
System.out.println("Enter the BQTY");
int BQTY=Integer.parseInt(s.nextLine());
ps.setString(1,BCODE);
ps.setString(2,BNAME );
ps.setString(3,BAUTHOR);
ps.setFloat(4, BPRICE);
ps.setInt(5, BQTY);
int k=ps.executeUpdate();
if(k>0) {
	System.out.println("Data Is Updated..");
}
}
con.close();
s.close();
}catch(Exception e){e.printStackTrace();}
}
}

