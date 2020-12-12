package macess;
import test.*;
import java.sql.*;
import java.util.*;
public class DBCon1 {

public static void main(String[] args) {
try {
	Scanner s= new Scanner(System.in);
	System.out.println("Enter the student Name:");
	 String uName=s.nextLine();
	System.out.println("Enter the Branch:");
	String br = s.nextLine();
	if(br.length()==3){
	BranchCheck bc=new BranchCheck();
	boolean z=bc.verify(br.toUpperCase());
	if(z)
	{
	System.out.println("enter the rollNo");
	String rollNo=s.nextLine();
	if(rollNo.length()==10)
	{
	Validation v =new Validation();
	boolean k = v.Validate(br.toUpperCase(),rollNo.substring(6,8));
	if(k)
	{
	int p=0,totmarks=0,i=1;
	System.out.println("Enter the six Sub:");
	while(i<=6)
	{
	System.out.println("enter the marks:");
	int sub =Integer.parseInt(s.nextLine());
	i++;
	if(sub<0 || sub>100)
	{
	System.out.println("Invalid submarks");
	i--;
	continue;
	}
	if(sub>=0 && sub<=34)
	{
	p=1;
	}
	totmarks=totmarks+sub;
	}//end of loop
	SResult sr=new SResult();
	sr.cal(totmarks,p);
	sr.getResult();
	Class.forName("oracle.jdbc.driver.OracleDriver");
	Connection con=DriverManager.getConnection
	("jdbc:oracle:thin:@localhost:1521:XE","scott","tiger");
	PreparedStatement ps=con.prepareStatement
	("INSERT INTO STUDENTDATA28 VALUES (?,?,?,?,?)");
	ps.setString(1,uName);
	ps.setString(2,rollNo);
	ps.setString(3,br );
	ps.setFloat(4,sr.per);
	ps.setString(5,sr.result);
	int m=ps.executeUpdate();
	if(m>0) {
		System.out.println("DataInserted");
	}//end of if
	else
	{
	System.out.println("invalid roll_no....with branch");
		}//end of if
	}
	else
	{
	System.out.println("invalid roll_No");
	}
	}//end of if

	else
	{
	System.out.println("branch not avilable with rollNo");
	}
	}//end of if
	else
	{
	System.out.println("invalid branch");
	}
	}
}
catch(Exception e) {e.printStackTrace();}
}
}
