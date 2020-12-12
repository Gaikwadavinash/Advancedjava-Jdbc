/*comment of the program insert the multiple recored inserted using 
data Base Table using Batch Processing*/
/*without comment using bacth processing only one recode insert used 
 multiple record inserted used prepared Statement */
/*one a single table used insert recored in database table using 
 prepared Statement*/
package test;
import java.sql.*;
public class DBatch2 {
	public static void main(String[] args) {
	try {	
Class.forName("oracle.jdbc.driver.OracleDriver");
Connection con=DriverManager.getConnection
("jdbc:oracle:thin:@localhost:1521:XE","scott","tiger");
PreparedStatement ps=con.prepareStatement
("insert into product28 values('A144','mat',500,10)");
ps.addBatch(); 

int k[]=ps.executeBatch();
 /*
ps.setString(1,"A132");
ps.setString(2,"book");
ps.setFloat(3, 55000);
ps.setInt(4,10);
ps.addBatch();
ps.setString(1,"A133");
ps.setString(2,"bottal");
ps.setFloat(3, 550);
ps.setInt(4,10);
ps.addBatch();
int k[]=ps.executeBatch();*/
int  count=0;
for(int i=0;i<k.length;i++) {
	count++;
	System.out.println("Record Updated Sucessfully.....");
	System.out.println("count:"+count);
}	
	}catch(Exception e) {e.printStackTrace();}
	}
}
