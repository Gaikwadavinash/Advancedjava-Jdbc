package macess;
import test.*;
import java.sql.*;
import java.util.*;
public class DBCon3 {
	public static void main(String[] args) {
	Scanner s=null;
	Connection con=null;
try {
s= new Scanner(System.in);
System.out.println("Enter the RollNo");
String rNo=s.nextLine();
if(rNo.length()==10) {
Validation v= new Validation();	
boolean k=v.Validate(rNo.substring(6,8));
if(k){
System.out.println("Enter the StudentName");
String stuName=s.nextLine();
System.out.println("Enter the Branch");
String branch=s.nextLine();
if(branch.length()==3) {
BranchCheck bc= new BranchCheck();
boolean z=bc.verify(branch.toUpperCase(),rNo.substring(6, 8));
if(z){
System.out.println("Enter the PhoneNo");
long phNo=Long.parseLong(s.nextLine());
System.out.println("Enter the mailId");
String mid=s.nextLine();
System.out.println("Enter the StretName");
String sName=s.nextLine();
System.out.println("Enter the City");
String city=s.nextLine();
System.out.println("Enter the State");
String state=s.nextLine();
System.out.println("Enter the PinCode");
long pincode=Long.parseLong(s.nextLine());
int i=1,p=0,totalMarks=0;
System.out.println("Enter the 6Sub Marks");
while(i<=6) {
	System.out.println("Enter the Marks");
	int sub=Integer.parseInt(s.nextLine());
	i++;
if(sub<0 || sub>100) {
	System.out.println("Invalid marks");

i--;
continue;
}
if(sub>=0 && sub<=34){
	p=1;
}
totalMarks=sub+totalMarks;
}//end while	
SResult sr=new SResult();
sr.cal(totalMarks, p);
sr.getResult();
Class.forName("oracle.jdbc.driver.OracleDriver");
con=DriverManager.getConnection
("jdbc:oracle:thin:@localhost:1521:XE","scott","tiger");
CallableStatement cs=con.prepareCall
("{call StuData28(?,?,?,?,?,?,?,?,?,?,?,?)}");
cs.setString(1,rNo);
cs.setString(2,stuName);
cs.setString(3,branch);
cs.setLong(4,phNo);
cs.setString(5,mid);
cs.setString(6,sName);
cs.setString(7,city);
cs.setString(8,state);
cs.setLong(9,pincode);
cs.setInt(10,totalMarks);
cs.setFloat(11,sr.per);
cs.setString(12,sr.result);
cs.execute();
System.out.println("Data Sucessfully Store In DataBase");
}
}else {
	System.out.println("Invalid Branch");
}
}
else {
	System.out.println("code is invalid");
}
}else {
	System.out.println("Invalid rollNo.....");
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