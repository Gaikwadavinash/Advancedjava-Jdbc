package test;
import java.util.*;
import java.sql.*;
public class SelectTest8 {
public static void main(String[] args) {
try {
Scanner s= new Scanner(System.in);
System.out.println("Enter the EmpNo");
int EmpNo=Integer.parseInt(s.nextLine());
Class.forName("oracle.jdbc.driver.OracleDriver");
Connection con=DriverManager.getConnection
("jdbc:oracle:thin:@localhost:1521:XE","scott","tiger");
Statement stm=con.createStatement();
ResultSet rs=stm.executeQuery
("SELECT EMPNO,ENAME,SAL,JOB FROM EMP WHERE EMPNO="+EmpNo);
while(rs.next())
{
System.out.println(rs.getInt(1)+"\t"+rs.getString(2)
+"\t"+rs.getFloat(3)+"\t"+rs.getString(4));
}
con.close();
s.close();
}//end of try
catch(Exception e) {e.printStackTrace();}
}

}

