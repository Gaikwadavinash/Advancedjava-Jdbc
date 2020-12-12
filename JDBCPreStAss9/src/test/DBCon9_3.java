/*Retrive the data from DataBase based on Id*/
package test;
import java.util.*;
import java.sql.*;
public class DBCon9_3 {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
try {
Scanner s= new Scanner(System.in);
System.out.println("Enter the ID");
int ID=Integer.parseInt(s.nextLine());
Class.forName("oracle.jdbc.driver.OracleDriver");
Connection con=DriverManager.getConnection
("jdbc:oracle:thin:@localhost:1521:XE","scott","tiger");
PreparedStatement ps=con.prepareStatement
("SELECT *FROM CUSTOMER28 WHERE ID=?");
ps.setInt(1,ID);
ResultSet rs=ps.executeQuery();
if(rs.next()) {
	System.out.println("Name:"+rs.getString(2)+"\nAge:"+rs.getInt(3)+
"\nAddr:"+rs.getString(4)+"\nSalary:"+rs.getFloat(5));
}else {
	System.out.println("ID is Not Valid");
}
}//end try 
catch(Exception e) {e.printStackTrace();}
		
	}

}
