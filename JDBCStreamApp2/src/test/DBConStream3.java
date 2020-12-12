package test;
import java.io.*;
import java.io.IOException;
import java.sql.*;
import java.util.*;
public class DBConStream3{
	public static void main(String[] args) {
Scanner s=null;
Connection con=null;
try{
s=new Scanner(System.in);	
System.out.println("Enter the id");
String id=s.nextLine();
System.out.println("Enter the filepath and Name");
File f=new File(s.nextLine());
FileReader fr= new FileReader(f);
Class.forName("oracle.jdbc.driver.OracleDriver");
con=DriverManager.getConnection
("jdbc:oracle:thin:@localhost:1521:XE","scott","tiger");
PreparedStatement ps=con.prepareStatement
("insert into CharacterTab28 values(?,?)");
ps.setString(1,id);
ps.setCharacterStream(2,fr,(int)f.length());
int k=ps.executeUpdate();
if(k>0)
	System.out.println("Retrive Data Sucefully");

}catch(FileNotFoundException fne) {
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
	}
}//end finally
	
	}
}
