package temp;

import java.util.Date;

public class Demoemail {
	
	public static String main(String args[]) {
		Date date=new Date();
			String dateString=date.toString();
		String noSpaceDateString=dateString.replace("\\s","");
		String noSpaceAndColonsDateString=noSpaceDateString.replaceAll("\\","");
		String emailWithTimeStemp=noSpaceAndColonsDateString+"@gmail.com";
		return emailWithTimeStemp;
		
	}
}
