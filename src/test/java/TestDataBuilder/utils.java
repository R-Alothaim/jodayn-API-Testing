package TestDataBuilder;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Properties;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class utils {
  public static RequestSpecification req;
  public io.restassured.specification.RequestSpecification requestspec() throws IOException{
    if(req==null){
    PrintStream log = new PrintStream(new FileOutputStream("logging.txt"));
    
   req = new RequestSpecBuilder().setBaseUri(getGlobalValue("baseUrl")).addFilter(RequestLoggingFilter.logRequestTo(log))
   .addFilter(ResponseLoggingFilter.logResponseTo(log)).setContentType(io.restassured.http.ContentType.JSON).build();
  return req;
    }
    return req;
  }
  public static String getGlobalValue(String key) throws IOException

  {
    Properties prop = new Properties();
    FileInputStream file = new FileInputStream("C:\\Users\\RayanAlOthaim\\OneDrive - JODAYN\\Documents\\VSC\\API testing\\Proj2\\jodayn\\src\\test\\java\\TestDataBuilder\\global.properties");
    prop.load(file);
   return prop.getProperty(key);
    
  }
  public String getJsonPath(Response response, String key){
    String resp = response.asString();
    JsonPath js = new JsonPath(resp);
   return js.get(key);
  }
}
