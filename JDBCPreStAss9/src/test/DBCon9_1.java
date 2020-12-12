/*Insert record In Data based table*/
package test;
import java.sql.*;
import java.util.*;
public class DBCon9_1 {
public static void main(String[] args) {
Scanner	 s=null;
Connection con=null;
try {
s=new Scanner(System.in);
System.out.println("Enter the Id:");
int ID=Integer.parseInt(s.nextLine());
System.out.println("Enter the Name:");
String NAME=s.nextLine();
System.out.println("Enter the Age");
int AGE=Integer.parseInt(s.nextLine());
System.out.println("Enter the Adress");
String ADDR=s.nextLine();
System.out.println("Enter the Salary");
float SALARY=Float.parseFloat(s.nextLine());
Class.forName("oracle.jdbc.driver.OracleDriver");
con=DriverManager.getConnection
("jdbc:oracle:thin:@localhost:1521:XE","scott","tiger");
PreparedStatement ps=con.prepareStatement
("INSERT INTO CUSTOMER28 VALUES(?,?,?,?,?)");
ps.setInt(1, ID);
ps.setString(2,NAME);
ps.setInt(3,AGE);
ps.setString(4,ADDR);
ps.setFloat(5, SALARY);
int k=ps.executeUpdate();
if(k>0) {
	System.out.println("Data Inserted Table");
}
}
catch(Exception e) {e.printStackTrace();}
	}

}
