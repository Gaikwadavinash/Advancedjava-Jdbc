package test;
import java.util.*;
import java.sql.*;
public class Con1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
Scanner s=null;
Connection sqlCon=null;
Class c1=null;
try {
c1=forName("com.mysql.jdbc.Driver");
sqlCon=DriverManager.getConnection
("jdbc:mysql://localhost:3306/bookdeatils28",
"root","manager");	
System.out.println("Connection Created..");
	}catch(Exception e) {e.printStackTrace();}
	}

	private static Class forName(String string) {
		// TODO Auto-generated method stub
		return null;
	}
}
