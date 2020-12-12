package test;
import java.sql.*;
import java.util.*;
import java.io.*;
import java.io.IOException;
public class DBConStream4 {
	public static void main(String[] args) {
Scanner s=null;
Connection con=null;
try {
s=new Scanner(System.in);
System.out.println("Enter the id");
String id=s.nextLine();
Class.forName("oracle.jdbc.driver.OracleDriver");
con=DriverManager.getConnection
("jdbc:oracle:thin:@localhost:1521:XE","scott","tiger");
PreparedStatement ps=con.prepareStatement
("select *from Charactertab28 where id=?");
ps.setString(1,id);
ResultSet rs=ps.executeQuery();
if(rs.next()){
Clob c=rs.getClob(2);
Reader r=c.getCharacterStream();
File f=new File("F:\\DBStream\\text2.txt");
FileWriter fw= new FileWriter(f);
int ch;
while((ch=r.read())!=-1) {
	fw.write(ch);
}
fw.close();
System.out.println("Retrive Data Sucessfully");
}else {
	System.out.println("Invalid id ");
}
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
catch(IOException ioe) {
	System.out.println("Invalid Stream");
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
