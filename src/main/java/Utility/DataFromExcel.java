package Utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;

public class DataFromExcel {
	
public static String[][] FetchDataFromExcel() throws Exception, IOException{

File file=new File(".//TestData//TestData1.xlsx");
FileInputStream Fin=new FileInputStream(file);
	
XSSFWorkbook wb=new XSSFWorkbook(Fin);	
XSSFSheet sheet=wb.getSheet("Sheet1");
int RowNum=sheet.getPhysicalNumberOfRows();
int ColNum=sheet.getRow(0).getLastCellNum();	

String data[][]=new String[RowNum][ColNum];

for(int i=0;i<RowNum;i++){
XSSFRow Row=sheet.getRow(i);
for(int j=0;j<ColNum;j++){
XSSFCell Column=Row.getCell(j);	
data[i][j]=Row.getCell(j).getStringCellValue();
}

}
return data;
}

	

}
