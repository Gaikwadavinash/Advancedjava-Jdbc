package test;
import java.util.*;
import java.sql.*;
import java.io.*;
public class DBConStream1 {
public static void main(String[] args){
Scanner s=null;
Connection con=null;
try {
	s= new Scanner(System.in);
System.out.println("Enter the Id");
String iD=s.nextLine();
System.out.println("Enter the fileName & Path");
File f=new File(s.nextLine());
FileInputStream fis=new FileInputStream(f);
Class.forName("oracle.jdbc.driver.OracleDriver");
con=DriverManager.getConnection
("jdbc:oracle:thin:@localhost:1521:XE","scott","tiger");
PreparedStatement ps=con.prepareStatement
("Insert into BinaryTab28 values(?,?)");
ps.setString(1,iD);
ps.setBinaryStream(2,fis, (int)f.length());
int k=ps.executeUpdate();
if(k>0) {
	System.out.println("Binary Stream Stored Sucessfully");
}
con.close();
}
catch(FileNotFoundException fne) {
	System.out.println("Invalid file path");
}
catch(NumberFormatException nfe) {
	System.out.println("Only Integer value");
}
catch(SQLIntegrityConstraintViolationException icve) {
	System.out.println("Invalid procedure");
}
catch(ClassNotFoundException cnfe){
	System.out.println("Connection or Query related ");
}
catch(SQLException e) {
	System.out.println("Driver related");
}
finally {
	if(s!=null)
		s.close();
	if(con!=null) {
try {

con.close();
}catch(Exception e) {e.printStackTrace();}
	}//end finally
}
	

	}
}
