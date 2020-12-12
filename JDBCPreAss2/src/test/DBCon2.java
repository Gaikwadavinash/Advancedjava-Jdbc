/* This Data base table name is EMPDATA28 */
package test;
import java.sql.*;
import java.util.*;
public class DBCon2{
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
Scanner s=new Scanner(System.in);
System.out.println("Enter the Name");
String eName=s.nextLine();
System.out.println("Enter the EmpID");
String EmpId=s.nextLine();
System.out.println("Enter the Basic Salary");
int bsal=Integer.parseInt(s.nextLine());

int Hra,Da;
Hra=(int) (bsal*0.93);
Da=(int) (bsal*0.63);
int total=bsal+Hra+Da;
System.out.println("hra:"+Hra);
System.out.println("Da:"+Da);
System.out.println("total:"+total);
Class.forName("oracle.jdbc.driver.OracleDriver");
Connection con=DriverManager.getConnection
("jdbc:oracle:thin:@localhost:1521:XE","scott","tiger");

PreparedStatement ps=con.prepareStatement
("INSERT INTO EMPDATA28 VALUES(?,?,?,?,?,?)");

ps.setString(1, eName);
ps.setString(2, EmpId);
ps.setInt(3,bsal);
ps.setInt(4, Hra);
ps.setInt(5, Da);
ps.setInt(6, total);
int k=ps.executeUpdate();
if(k>0) {
	System.out.println("Data updatd");
}

	}catch(Exception e) {e.printStackTrace();}
	}
}