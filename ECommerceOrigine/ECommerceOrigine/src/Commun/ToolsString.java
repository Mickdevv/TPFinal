package Commun;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ToolsString {

  public static String RecupCurrentDateHeure() {
	  DateFormat format = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
	  Date date = new Date();
	  String str = new String(format.format(date));
	  str = str.replace("/", "");
	  str = str.replace(" ", "");
	  str = str.replace(":", "");
	  
	  System.out.println(str );
	  
	  return str;
	  
  }
  
  
}
