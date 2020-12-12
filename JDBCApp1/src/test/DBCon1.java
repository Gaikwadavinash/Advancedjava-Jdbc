/*Retrive the Data from DataBase Table*/
 /*create table Employee28(id varchar2(10),name varchar2(15),
  desg varchar2(10),sal number(10));/*
  /*Insert into employee28 values('A101','RAM','SE',10000); */

package test;
import java.sql.*;
public class DBCon1 {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
Class.forName("oracle.jdbc.driver.OracleDriver");
Connection con=DriverManager.getConnection
("jdbc:oracle:thin:@localhost:1521:XE","scott","tiger");
Statement stm=con.createStatement();
ResultSet rs=stm.executeQuery("select *from employee28");
while(rs.next()) {
	System.out.println(rs.getString(1)+"\t"+rs.getString(2)+"\t"+
rs.getString(3)+"\t"+rs.getInt(4));
}
System.out.println("Display Data");
con.close();		
		}//end of try
	catch(Exception e) {e.printStackTrace();}
	}
}

