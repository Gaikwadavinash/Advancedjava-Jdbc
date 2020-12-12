package test;
import java.sql.*;
import java.io.*;
import java.util.*;
public class DBConStream2 {
public static void main(String[] args){
Scanner s= null;
Connection con=null;
try {
s=new Scanner(System.in);
System.out.println("Enter the Id");
String id=s.nextLine();
Class.forName("oracle.jdbc.driver.OracleDriver");
con=DriverManager.getConnection
("jdbc:oracle:thin:@localhost:1521","scott","tiger");
PreparedStatement ps=con.prepareStatement
("select *from BinaryTab28 where id=?");
ps.setString(1, id);
ResultSet rs=ps.executeQuery();
if(rs.next()) {
Blob b=rs.getBlob(2);
byte by[]=b.getBytes(1,(int)b.length());
File f=new File("F:\\DBStream\\kk.jpeg");
FileOutputStream fos= new FileOutputStream(f); 
fos.write(by);
fos.close();
System.out.println("retrive Data Sucessfully");
}
else {
	System.out.println("Invalid Number");
}
}catch(IOException fne) {
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
