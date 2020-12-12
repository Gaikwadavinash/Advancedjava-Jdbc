/*Get the data from db based on empid*/
package test;
import java.sql.*;
import java.util.*;
public class DBCon6 {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
try {
Scanner s= new Scanner(System.in);
System.out.println("Enter the EmpiD ");
String EMPID=s.nextLine();
Class.forName("oracle.jdbc.driver.OracleDriver");
Connection con=DriverManager.getConnection
("jdbc:oracle:thin:@localhost:1521:XE","scott","tiger");
PreparedStatement ps=con.prepareStatement
("SELECT *FROM EMPDATA28 WHERE EMPID=?");
ps.setString(1,EMPID);
ResultSet rs=ps.executeQuery();
if(rs.next()){
	System.out.println("Ename:"+rs.getString(1)+
"\nBSal:"+rs.getInt(3)+"\nHra:"+rs.getInt(4)+
"\nDa:"+rs.getInt(5)+"\nTotal:"+rs.getInt(6));
}else {
	System.out.println("Record Not Found");
}//else
}//end of try 
	catch(Exception e) {e.printStackTrace();}
	}

}
