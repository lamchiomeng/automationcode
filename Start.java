import java.io.IOException;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.commons.io.IOUtils;
import org.apache.poi.ss.usermodel.Cell;
import java.io.InputStream;
import java.io.InputStreamReader;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import java.io.BufferedReader;
import java.io.FileInputStream;
import org.apache.poi.ss.usermodel.DataFormatter;
public class Start {
    public static int count;
    public static String testability;
    public static String tc_name;
    public static String jar_filepath;    
    public static String test_data;
    public static String test_data_tab;
    public static String test_result;
    public static String test_cycle;
    DataFormatter df;    
    public Start() {
        this.df = new DataFormatter();
    }    
    public static void main(final String[] args) throws IOException, Throwable {
        final DataFormatter df = new DataFormatter();
        final FileInputStream StartInput = new FileInputStream("C:\\TA\\TestConfig.xlsx");
        final XSSFWorkbook StartInputWB = new XSSFWorkbook(StartInput);
        final XSSFSheet sheet = StartInputWB.getSheet("Config");
        //System.out.println("Amount of Row in test config : "+ sheet.getLastRowNum());
        //System.out.println("Total test case = " + sheet.getLastRowNum());
        Start.count = 1;
        //while (start.count <= sheet.getLastRowNum()) {
        for(Start.count = 1; Start.count <= sheet.getLastRowNum(); Start.count++){	            
            System.out.println(" ");
            System.out.println("Test case no. " +Start.count);
            final XSSFRow row = sheet.getRow(Start.count);
            Start.testability = row.getCell(0).toString();            
            Start.jar_filepath = row.getCell(2).toString();
            Start.tc_name = row.getCell(1).toString();
            Start.test_data = row.getCell(3).toString();
            Start.test_cycle = df.formatCellValue(row.getCell(4));
            //System.out.println("test cycle from start.jar = " + start.test_cycle);
            System.out.println("Test Case Name : " + Start.tc_name);
            if (Start.testability.equals("Y") || Start.testability.equals("Y)")) {                
                final Process p = Runtime.getRuntime().exec("cmd /c start /wait java -jar " + Start.jar_filepath + " " + Start.tc_name + " " + Start.test_data + "  " + Start.test_cycle );
                p.waitFor(); //   wait(); //    waitFor();
                System.out.println("Test Case " + Start.tc_name + " completed");
            }//if            
            else {
            	System.out.println("Test Case " + Start.tc_name + " not selected for execution");
            }
        }//for
        System.out.println("     ");
        System.out.println("Test completed");
    }// main
}//start




























































