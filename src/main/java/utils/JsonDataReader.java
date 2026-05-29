package utils;

import java.io.FileReader;
import java.lang.reflect.Method;

import org.testng.annotations.DataProvider;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

public class JsonDataReader {
	
	private JsonObject readJsonData() throws Exception {
	       
        JsonParser parser = new JsonParser ();
        return (JsonObject) parser.parse(new FileReader("src/test/resources/TestData/testdata.json"));
    } 


@DataProvider(name = "jsondata")
public Object[][] data(Method method) throws Exception {
    String testName = method.getName();
    JsonObject allData = readJsonData();
    JsonArray testdata = allData.getAsJsonArray(testName);
    
    Object[][] result = new Object[testdata.size()][1];
    for (int i = 0; i < testdata.size(); i++) {
        result[i][0] = testdata.get(i);
    }
    return result;
}
}
