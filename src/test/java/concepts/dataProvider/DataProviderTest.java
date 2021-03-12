package concepts.dataProvider;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.lang.reflect.Method;

public class DataProviderTest {

//    @Test(dataProvider = "provideEmpData")
    @Test(dataProvider = "provideMultipleData") //To reuse the same dataprovider method for all test method
    public void testDataProvider(Employee data){
        System.out.println("NAME is "+data.getName());
        System.out.println("ID is "+data.getId());
    }

//    @Test(dataProvider = "provideStrData")
    @Test(dataProvider = "provideMultipleData")
    public void testStringDataProvider(String data){
        System.out.println("String Data "+data);
    }

    /*
    * Return object can be single or two dimensional array
    * */
    @DataProvider
    public Object[] provideEmpData(){
        return new Employee[]{
                new Employee("Kannan", "123"),
                new Employee("Learning", "234")
        };
    }

    @DataProvider
    public Object[] provideStrData(){
        return new String[]{"FAITH", "HARDWORK", "CONFIDENCE"};
    }

    /*
    * To handle multiple test and different data providers, Method (reflect class) can be used to compare the calling method name
    * */
    @DataProvider
    public Object[] provideMultipleData(Method method){
        if(method.getName().equalsIgnoreCase("testDataProvider")){
            return new Employee[]{
                    new Employee("Kannan", "123"),
                    new Employee("Learning", "234")
            };
        }else if(method.getName().equalsIgnoreCase("testStringDataProvider")){
            return new String[]{"FAITH", "HARDWORK", "CONFIDENCE"};
        }
        return null;
    }
}
