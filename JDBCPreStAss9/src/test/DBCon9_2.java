/*Retrive the Data from DataBase Table*/
package test;
import java.sql.*;
import java.util.*;
public class DBCon9_2{
	public static void main(String[] args) {
		// TODO Auto-generated method stub
try {
Class.forName("oracle.jdbc.driver.OracleDriver");
Connection con=DriverManager.getConnection
("jdbc:oracle:thin:@localhost:1521:XE","scott","tiger");
Statement stm=con.createStatement();
ResultSet rs=stm.executeQuery
("SELECT *FROM CUSTOMER28");
while(rs.next()) {
	System.out.println(rs.getInt(1)+"\t"+rs.getString(2)+
"\t"+rs.getInt(3)+"\t"+rs.getString(4)+"\t\t "+rs.getFloat(5));
}
}catch(Exception e) {e.printStackTrace();}
		
	}

}
