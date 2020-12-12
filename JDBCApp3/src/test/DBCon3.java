package test;
import java.sql.*;
import java.util.*;
public class DBCon3 {
public static void main(String[] args) {
try {
@SuppressWarnings("resource")
Scanner s= new Scanner(System.in);
System.out.println("Enter the Product Id");
String PID=s.nextLine();
System.out.println("Enter the Product Name ");
String PNAME=s.nextLine();
System.out.println("Enter the Product Price");
float PPRICE=Float.parseFloat(s.nextLine());
System.out.println("Enter the Product Qty");
Integer PQTY=Integer.parseInt(s.nextLine());
Class.forName("oracle.jdbc.driver.OracleDriver");//STEP1
Connection con=DriverManager.getConnection
("jdbc:oracle:thin:@localhost:1521:XE","scott","tiger");//SETP2
 PreparedStatement ps=con.prepareStatement
("INSERT INTO PRODUCT28 VALUES(?,?,?,?)");//STEP3
ps.setString(1,PID);
ps.setString(2, PNAME);
ps.setFloat(3,PPRICE);
ps.setInt(4,PQTY);
int k=ps.executeUpdate();//STEP4
if(k>0){
System.out.println("........Data inserted....");
}
con.close();//SETP5
}//end of try block
catch(ClassNotFoundException | SQLException e)
{e.printStackTrace();}
	}

}
