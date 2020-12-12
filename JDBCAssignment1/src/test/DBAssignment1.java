package test;
import java.sql.*;
import java.util.*;
public class DBAssignment1 {
	public static void main(String[] args) {
try {
Scanner s= new Scanner(System.in);
System.out.println("Enter the ServiceNo");
String SERNO=s.nextLine();
System.out.println("Enter the ServiceName");
String SERNAME=s.nextLine();
System.out.println("Enter the FirstStation");
String FSTATION =s.nextLine();
System.out.println("Enter the LastStation");
String LSTATION=s.nextLine();
System.out.println("Enter the DepartureTime");
String DTIME=s.nextLine();
System.out.println("Entre the ArrivalTime");
String ATIME=s.nextLine();
System.out.println("Enter the price");
float EBPRIC=Float.parseFloat(s.nextLine());
System.out.println("Enter the AvailableSeat");
Integer AVLSEAT=Integer.parseInt(s.nextLine());

Class.forName("oracle.jdbc.driver.OracleDriver");
Connection con=DriverManager.getConnection
("jdbc:oracle:thin:@localhost:1521:XE","scott","tiger");
PreparedStatement ps=con.prepareStatement
("INSERT INTO BUSDETAILS28 VALUES(?,?,?,?,?,?,?,?)");
ps.setString(1,SERNO);
ps.setString(2,SERNAME );
ps.setString(3, FSTATION);
ps.setString(4,LSTATION);
ps.setString(5,DTIME );
ps.setString(6,ATIME);
ps.setFloat(7,EBPRIC);
ps.setInt(8,AVLSEAT);
int k=ps.executeUpdate();
if(k>0)
{
System.out.println("....Data Inserted..........");
}
s.close();
con.close();
}//end of try
	catch(Exception e) {e.printStackTrace();}
}
}
