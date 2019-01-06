package Utility;

import org.openqa.selenium.WebDriver;

public class TestEngine {
	
static WebDriver driver;	
	
public static void main(String...s) throws Exception{
Utility Util=new Utility(driver);	
String[][] Keywords=DataFromExcel.FetchDataFromExcel();

//Find the number of rows:
int RowNum=Keywords.length;
int ColNum=Keywords[0].length;
System.out.println("RowNum"+RowNum);
System.out.println("ColNum"+ColNum);	
	

String TC_Name=Keywords[0][0];
String Step_No=Keywords[0][1];
String Step_Name=Keywords[0][2];
String Function=Keywords[0][3];
String Locator=Keywords[0][4];
String LocatorValue=Keywords[0][5];
String Parameter=Keywords[0][6];
String Execute=Keywords[0][7];

//System.out.println(Execute);

for(int i=1;i<RowNum;i++){
String content_FN=Keywords[i][3];
String content_Locator=Keywords[i][4];
String content_LValue=Utility.fetchValue(Keywords[i][5]);
String content_Parameter=Keywords[i][6];
String content_Execute=Keywords[i][7];

System.out.println(content_FN+ "\t"+content_Locator+ "\t"+content_LValue+ "\t"+content_Parameter);

if(content_Execute.equalsIgnoreCase("Y")){

switch(content_FN){		
case "Launch":
Util.LaunchBrowser();
break;
case "EnterText":
Util.EnterText(content_Locator, content_LValue, content_Parameter);
break;
case "click":
Util.Click(content_Locator, content_LValue);	
break;
case "WaitTime":
Utility.WaitTime();	

}
}
}
}
}
