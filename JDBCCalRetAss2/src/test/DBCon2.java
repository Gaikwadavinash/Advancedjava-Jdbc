package test;
import java.util.*;
import java.sql.*;
public class DBCon2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s=null;
		Connection con=null;
		try{
		s= new Scanner(System.in);
		System.out.println("Enter the userName");
		String userName=s.nextLine();
		
		System.out.println("Enter the pword");
		String pWord=s.nextLine();
		
		Class.forName("oracle.jdbc.driver.OracleDriver");
		con=DriverManager.getConnection
		("jdbc:oracle:thin:@localhost:1521:XE","scott","tiger");
CallableStatement cs=con.prepareCall
("{call RetriveUserData28(?,?,?,?,?,?,?,?)}");
cs.setString(1,userName);
cs.setString(2,pWord);
cs.registerOutParameter(3,Types.VARCHAR);
cs.registerOutParameter(4,Types.BIGINT);
cs.registerOutParameter(5,Types.VARCHAR);
cs.registerOutParameter(6,Types.VARCHAR);
cs.registerOutParameter(7,Types.VARCHAR);
cs.registerOutParameter(8,Types.SMALLINT);
cs.execute();
System.out.println("uName:"+userName+"\npword:"+pWord+
"\nAddr:"+cs.getString(3)+"\nphNo:"+cs.getLong(4)+
"\nmId:"+cs.getString(5)+"\nfName:"+cs.getString(6)+
"\nlName:"+cs.getString(7)+"\nAge:"+cs.getInt(8));
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

		
		
