package Donnees;

import java.io.FileInputStream;
import java.io.IOException;
import java.net.BindException;
import java.util.Properties;

public class ReadProperty {

	   private String fileName;

	   public ReadProperty(String fileName) {
	       this.fileName = fileName;
	}

	   public String getProperty(String locator) throws IOException {
		    Properties objProp = new Properties();
		    FileInputStream ObjFile = new FileInputStream(fileName);
	              try {
	      		    objProp.load(ObjFile);
	             } catch (BindException e) {
	                     // e.printStackTrace();
	            }
	           String data = objProp.getProperty(locator)  ;                               
	        return data;
	   }
}
