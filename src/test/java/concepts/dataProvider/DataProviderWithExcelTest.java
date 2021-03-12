package concepts.dataProvider;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class DataProviderWithExcelTest {

    /*
    * This implementation model has a drawback due to argument needs to maintain as per the excel column.
    * It can be override using the hasmap implementation.
    * */
//    @Test(dataProvider = "readDataFrmxl")
    public void testDataFromxl(String sno, String username, String pwd, String id, String userid){
        System.out.println(sno+". "+username+" / "+pwd+" / "+userid);
    }

    @DataProvider
    public Object[][] readDataFrmxl() {
//        FileInputStream fileInputStream;
        Object[][] data = null;
        try{
            FileInputStream fileInputStream = new FileInputStream(System.getProperty("user.dir")+"/input/inputData.xlsx");
            XSSFWorkbook workbook = new XSSFWorkbook(fileInputStream);
            Sheet sheet = workbook.getSheet("userSheet");
            int rowCount = sheet.getLastRowNum();
            int columnCount = sheet.getRow(0).getLastCellNum();
            data = new Object[rowCount-1][columnCount];
            for(int i=1; i<rowCount; i++){
                for(int j=0; j<columnCount; j++){
                    data[i-1][j] = sheet.getRow(i).getCell(j).getStringCellValue();
                }
            }
            fileInputStream.close();
        }catch (IOException e){
            e.printStackTrace();
        }
        return data;
    }

    @Test(dataProvider = "readDataFrmXLtoMap")
    public void testDdataProWithMap(Map<String, String> data){
        for(String key : data.keySet()){
            System.out.println(key+" - "+data.get(key));
        }
    }

    @DataProvider
    public Object[] readDataFrmXLtoMap(){
        Object[] data = null;
        try{
            FileInputStream fileInputStream = new FileInputStream(System.getProperty("user.dir")+"/input/inputData.xlsx");
            XSSFWorkbook workbook = new XSSFWorkbook(fileInputStream);
            Sheet sheet = workbook.getSheet("userSheet");
            int rowCount = sheet.getLastRowNum();
            int columnCount = sheet.getRow(0).getLastCellNum();
            data = new Object[rowCount-1];
            for(int i=1; i<rowCount; i++){
                Map<String, String> eachRow = new HashMap<>();
                for(int j=0; j<columnCount; j++){
                    eachRow.put(sheet.getRow(0).getCell(j).getStringCellValue(), sheet.getRow(i).getCell(j).getStringCellValue());
                }
                data[i-1]=eachRow;
            }
            fileInputStream.close();
        }catch (IOException e){
            e.printStackTrace();
        }
        return data;
    }
}
