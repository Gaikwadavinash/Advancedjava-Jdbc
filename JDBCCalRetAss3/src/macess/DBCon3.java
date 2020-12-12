package macess;
import java.sql.*;
import java.util.*;
import test.*;
public class DBCon3{
	public static void main(String[] args) {
Scanner s=null;
Connection con=null;
try {
s= new Scanner(System.in);
System.out.println("Enter the RollNo");
String rNo=s.nextLine();
if(rNo.length()==10) {
Class.forName("oracle.jdbc.driver.OracleDriver");
con=DriverManager.getConnection
("jdbc:oracle:thin:@localhost:1521:XE","scott","tiger");
CallableStatement cs=con.prepareCall
("{call retrivestudata28(?,?,?,?,?,?,?,?,?,?,?,?)}");
cs.setString(1,rNo);
cs.registerOutParameter(2,Types.VARCHAR);
cs.registerOutParameter(3,Types.VARCHAR);
cs.registerOutParameter(4,Types.BIGINT);
cs.registerOutParameter(5,Types.VARCHAR);
cs.registerOutParameter(6,Types.VARCHAR);
cs.registerOutParameter(7,Types.VARCHAR);
cs.registerOutParameter(8,Types.VARCHAR);
cs.registerOutParameter(9,Types.INTEGER);
cs.registerOutParameter(10,Types.INTEGER);
cs.registerOutParameter(11,Types.FLOAT);
cs.registerOutParameter(12,Types.VARCHAR);
cs.execute();
System.out.println("rNo:"+rNo+"\nstuName:"+cs.getString(2)+
"\nbrach:"+cs.getString(3)+"\nphNo:"+cs.getLong(4)+
"\nmId:"+cs.getString(5)+"\nsName:"+cs.getString(6)+
"\ncity:"+cs.getString(7)+"\nState:"+cs.getString(8)+
"\npincode:"+cs.getLong(9)+"\ntotalMarks:"+cs.getInt(10)+
"\nper:"+cs.getFloat(11)+"\ngrade:"+cs.getString(12));
	
System.out.println("Retrive data Sucessfully");	
}else {
	System.out.println("Invalid RollNo");
}
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
finally {
	if(s!=null)
		s.close();
	if(con!=null) {
try {

con.close();
}catch(Exception e) {e.printStackTrace();}
	}//end finally
}
}
}
	
	