/*Primary key */
package test;
import java.util.*;
import java.sql.*;
public class DBCon10{
	public static void main(String[] args){
/*without try with resources*/
Scanner s=null;
Connection con=null;
//mention above 8 and 9 Lines show above
try{
s=new Scanner(System.in);
System.out.println("Enter the PID");
String PID=s.nextLine();
System.out.println("Enter the PNAME");
String PNAME=s.nextLine();
System.out.println("Enter the PPRICE");
float PPRICE=Float.parseFloat(s.nextLine());
System.out.println("Enter the PQTY");
int PQTY=Integer.parseInt(s.nextLine());
Class.forName("oracle.jdbc.driver.OracleDriver");
con=DriverManager.getConnection
("jdbc:oracle:thin:@localhost:1521:XE","scott","tiger");
PreparedStatement ps1=con.prepareStatement
("INSERT INTO PRODUCT28 VALUES(?,?,?,?)");
ps1.setString(1,PID);
ps1.setString(2,PNAME);
ps1.setFloat(3,PPRICE);
ps1.setInt(4,PQTY);
int k=ps1.executeUpdate();
if(k>0) {
	System.out.println("Data Inserted..");
}
}//end of try
catch(SQLIntegrityConstraintViolationException incve ) 
{
		System.out.println("Alrady exit record or Null");
}

catch(ClassNotFoundException  cnfe)
{
	System.out.println("Driver Connection Problem");
}
catch(SQLException ce)
{
System.out.println("Connection or Query problem ");
}
finally {
	if(s!=null) {  
		s.close();
	}
if(con!=null) {
try {
con.close();
}catch(SQLException e) {e.printStackTrace();}
              }
}//end finally
}
}