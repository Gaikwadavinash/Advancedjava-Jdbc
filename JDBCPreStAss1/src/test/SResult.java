package test;
import macess.*;
public class SResult {
	public float per;
	public String result;
	public Object ps;
public void cal(int total,int p) {
	per=(float)total/6;
	if(p==1) {
		result="fail";
	}
	else if(per>=70 && per<=100) {
		result="Dist ";
	}
	else if(per<=70 && per>=60) {
		result="first Class";
	}
	else if(per<=60 && per>=50 ) {
		result="Second Class";
	}
	else if(per>=35 && per<=50) {
		result="Third Class";
	}
	}
public void getResult() {
	System.out.println("per:"+per);
	System.out.println("result :"+result);
}

}

