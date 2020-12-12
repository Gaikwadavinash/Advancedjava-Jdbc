/*oracle DataBase table transfer to my mysql database table*/

package test;
import java.sql.*;
import java.util.*;
public class DBOrc1 {
	public static void main(String[] args) throws Exception{
Class c1=Class.forName("oracle.jdbc.driver.OracleDriver");
//Class c2=Class.forName("com.mysql.jdbc.Driver");
Connection con1=DriverManager.getConnection
("jdbc:oracle:thin:@localhost:1521:XE","scott","tiger");
Connection Con2=DriverManager.getConnection
("jdbc:mysql://localhost:3306/bookdeatils28",
"root","manager");	
Statement stm1=con1.createStatement();

Statement stm2=Con2.createStatement();
ResultSet rs=stm1.executeQuery
("SELECT *FROM bookdetails28");
int count=0;
while(rs.next()) {
count++;
String BCODE=rs.getString(1);
String BNAME=rs.getString(2);
String BAUTHOR=rs.getString(3);
float BPRICE=rs.getFloat(4);
int BQTY=rs.getInt(5);
String sqlQuery=String.format
("INSERT INTO BOOKDETAILS28 VALUES('%s','%s','%s',%f,%d)",
BCODE,BNAME,BAUTHOR,BPRICE,BQTY);
stm2.executeUpdate(sqlQuery);
}
System.out.println("data Transfer sucessfully:"+count);
	}
	}
	
