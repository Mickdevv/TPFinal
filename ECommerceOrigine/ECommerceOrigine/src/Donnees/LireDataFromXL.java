package Donnees;

import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;

public class LireDataFromXL {
	public static String getCell (XSSFSheet sheet , int irow, int icol) {

		String retValue;

		XSSFCell cell = sheet.getRow(irow).getCell(icol);
		if (cell!=null) {
			CellType typecell = sheet.getRow(irow).getCell(icol).getCellType();
			switch(typecell){

			case BLANK:
				retValue= "";
				break;
				
			case STRING:
				retValue= sheet.getRow(irow).getCell(icol).getStringCellValue();
				if (retValue=="<VIDE>") {
					retValue = "";
				}
				break;
				
			case NUMERIC:
				Double d = sheet.getRow(irow).getCell(icol).getNumericCellValue();
				int n=d.intValue();
				retValue= Integer.toString(n);
				break;
			default: 
				retValue= "??";
			}
		} else {
			retValue = "";
		}
		
		System.out.println("CellValue(" + irow + "," + icol + ") : #" + retValue + "#");
		return retValue;
	}
}