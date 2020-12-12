package test;
import java.sql.*;
public class DBatch1 {
	public static void main(String[] args) {
try {
Class.forName("oracle.jdbc.driver.OracleDriver");
Connection con=DriverManager.getConnection
("jdbc:oracle:thin:@localhost:1521:XE","scott","tiger");
Statement stm=con.createStatement();
stm.addBatch
("insert into employee28 values('A131','ALLEN','TE',1500)");
stm.addBatch
("insert into product28 values('A131','PD',2000,15)");
int k[]=stm.executeBatch();
int count=0;
for(int i=0;i<k.length;i++) {
	count++;
	System.out.println("Inserted record SucessFully...");
	System.out.println("count:"+count);
}
}catch(Exception e) {e.printStackTrace();}

	}
}
