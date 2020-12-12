package test;
public class BranchCheck {
	
		public boolean z;
	public 	boolean verify(String br)
		{
		switch(br){
		case "EEE":z=true;
		         break;
		case "ECE":z=true;
		           break;
		     case "CEE":z=true;
		          break;
		  default:z=false;
		}
		return z;
		}//end of switch
		
		}//end of class

