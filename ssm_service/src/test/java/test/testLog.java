package test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.log4j.Logger;
import org.junit.Test;

public class testLog {

	private static Logger logger = Logger.getLogger(Test.class);  
	
	@Test
	public void testLog(){
//		String reg = "^\\{?\\}?$";
//		String reg = "\\{([^}]*)\\}";
		String reg = "\\{(.*?)\\}";
		Pattern pattern = Pattern.compile(reg);
		String str = "11zzz{xc23}zxc_+{312}{{}}}23{gggh}45{gh7}745{cvcvb}786{zxcb}zxb";
		Matcher match = pattern.matcher(str);
		while(match.find()) {
			System.out.println(match);
		}
		System.out.println(match);
	}
}
