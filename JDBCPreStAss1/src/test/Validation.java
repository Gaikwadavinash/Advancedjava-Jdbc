package test;
public class Validation {
public boolean k;
public String b;
public boolean Validate(String br,String code) {
	{
		switch(code){
		case"05":b="CSE";
		break;
		case"02":b="EEE";
		break;
		case"04":b="ECE";
		break;}
		if(b!=null)
		{
		if(b.equals(br))
		{
		k=true;
		}
		}

		return k;
		}
}}
