package automation.utils;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Date;
import java.util.Properties;

public class CommonUtils {
	public static String generateNewEmail() {
		String noSpaceDateString = new Date().toString().replaceAll("\\s", "");
		String noSpaceAndnoColonsDateString = noSpaceDateString.replaceAll("\\:", "");
		String emailWithTimeStamp = noSpaceAndnoColonsDateString + "@gmail.com";
		return emailWithTimeStamp;
	}
	
	public static Properties loadProperties() {
		Properties prop = new Properties();
		try {
			FileReader fr = new FileReader(System.getProperty("user.dir")+"\\src\\test\\resources\\application.properties");
			prop.load(fr);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return prop;
	}
}
