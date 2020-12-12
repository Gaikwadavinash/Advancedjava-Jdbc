package test;
import java.util.*;
import java.sql.*;
public class DBCon3 {
	@SuppressWarnings("resource")
	public static void main(String[] args) {
try{
	Scanner s= new Scanner(System.in);
	System.out.println("Enter the Product Id");
	String PID=s.nextLine();
	if(PID.length()==4) {
	Class.forName("oracle.jdbc.driver.OracleDriver");
	Connection con=DriverManager.getConnection
	("jdbc:oracle:thin:@localhost:1521:XE","scott","tiger");
	PreparedStatement ps=con.prepareStatement
	("SELECT *FROM PRODUCT28 WHERE PID=?");
	ps.setString(1, PID);
	ResultSet rs=ps.executeQuery();
	if(rs.next()) {
		System.out.println("PRODUCT NAME:"+rs.getString(2)
		+"\nPRODUCT PRICE:"+rs.getFloat(3)+
		"\nPRODUCT QTY:"+rs.getInt(4));
	}else {
		System.out.println("Invald product ID");
	}
	}else {
		System.out.println("Product Id Length is not Match");
	}
}//end  try
	catch(Exception e) {e.printStackTrace();}
	}

}
