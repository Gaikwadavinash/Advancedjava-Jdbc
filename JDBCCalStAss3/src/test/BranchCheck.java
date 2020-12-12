package test;

public class BranchCheck {
	public boolean z;
	public String code;
	public 	boolean verify(String br,String code)
		{
		switch(code){
		case "05":code="EEE";
		         break;
		case "04":code="ECE";
		           break;
		     case "03":code="CEE";
		          break;
		 // default:z=false;
		}
		if(br!=null)
		{
		if(br.equals(code))
		{
		z=true;
		}
		}
		return z;
		}//end of switch
		
		}//end of class



