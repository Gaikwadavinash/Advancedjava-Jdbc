package test;
import java.sql.*;
import java.util.*;
public class DBCon1 {
	public static void main(String[] args) { 
Scanner s=null;
Connection con=null;
try{
s= new Scanner(System.in);
System.out.println("Enter the eId");
String EID=s.nextLine();
Class.forName("oracle.jdbc.driver.OracleDriver");
con=DriverManager.getConnection
("jdbc:oracle:thin:@localhost:1521:XE","scott","tiger");
CallableStatement cs=con.prepareCall
("{call RETRIVEEMPDATA28(?,?,?,?,?,?,?)}");
cs.setString(1,EID);
cs.registerOutParameter(2,Types.VARCHAR);
cs.registerOutParameter(3,Types.VARCHAR);
cs.registerOutParameter(4,Types.FLOAT);
cs.registerOutParameter(5,Types.VARCHAR);
cs.registerOutParameter(6,Types.VARCHAR);
cs.registerOutParameter(7,Types.SMALLINT);
cs.execute();
System.out.println("eId:"+EID+"\neName:"+cs.getString(2)+
"\neDesg:"+cs.getString(3)+"\nbSal:"+cs.getFloat(4)+
"\nsName:"+cs.getString(5)+"\ncity:"+cs.getString(6)+
"\npincode:"+cs.getLong(7));
		}catch(SQLIntegrityConstraintViolationException icve) {
		System.out.println("Procedure or Duplicated related Issue");	
		}
		catch(ClassNotFoundException cn) {
			System.out.println("Connection or Queries Related Issue");
		}
		catch(SQLException e) {
			System.out.println("Driver Related Issue");
		}
	finally {
if(s!=null)
s.close();
if(con!=null)
				try {
		con.close();			
				}catch(Exception e) {e.printStackTrace();}
		}

			}
		}

