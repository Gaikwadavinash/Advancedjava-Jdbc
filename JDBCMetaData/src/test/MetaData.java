package test;
import java.sql.*;
import java.util.*;
public class MetaData {
public static void main(String[] args) {
try {
Class.forName("oracle.jdbc.driver.OracleDriver");
Connection con=DriverManager.getConnection
("jdbc:oracle:thin:@localhost:1521:XE","scott","tiger");
DatabaseMetaData dmd=con.getMetaData();
System.out.println("DriverVersion:"+dmd.getDriverMajorVersion());
PreparedStatement ps1=con.prepareStatement
("insert into Product28 values(?,?,?,?)");
ps1.setString(1,"A10110");
ps1.setString(2,"CM");
ps1.setFloat(3,5000);
ps1.setInt(4,10);
int k=ps1.executeUpdate();
ParameterMetaData pmd=ps1.getParameterMetaData();
System.out.println("Class:"+pmd.getClass());
PreparedStatement ps2=con.prepareStatement
("Select *From Product28");
ResultSetMetaData rsmd=ps2.getMetaData();
System.out.println("Column Count:"+rsmd.getColumnCount());
}catch(Exception e) {e.printStackTrace();}
}
}
