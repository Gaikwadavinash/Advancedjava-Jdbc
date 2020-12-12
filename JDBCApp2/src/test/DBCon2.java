/*Retrive Data from DataBasse Table*/
/*create table Product28(pid varchar2(10),pname varchar2(15),
  2  pprice number(10,2),pqty number(10));*/
/*Insert into product28 values('A101','KB',500,10); */

package test;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
public class DBCon2 {
public static void main(String[] args) {
try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con=DriverManager.getConnection
			("jdbc:oracle:thin:@localhost:1521:XE","scott","tiger");
			Statement stm=con.createStatement();
			ResultSet rs=stm.executeQuery("SELECT *FROM PRODUCT28");
			while(rs.next()) {
				System.out.println(rs.getString(1)+"\t"+rs.getString(2)+"\t"+
			rs.getString(3)+"\t"+rs.getString(4));
			}
			con.close();		
					}//end of try
				catch(Exception e) {e.printStackTrace();}
				}
			}

			