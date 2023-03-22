package resources;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

import java.io.*;
import java.util.Properties;

public class Utils {

    public static RequestSpecification req;


    public RequestSpecification requestCommonUtility() throws IOException {


        if (req == null) {
            PrintStream log = new PrintStream(new FileOutputStream("log.txt"));


            req = new RequestSpecBuilder()
                    .addFilter(RequestLoggingFilter.logRequestTo(log))                                      //Logging request details
                    .addFilter(ResponseLoggingFilter.logResponseTo(log))                                    //Logging Response details
                    .setBaseUri(getBaseURL("baseURL"))
                    .addQueryParam("key", "qaclick123")
                    .setContentType(ContentType.JSON).build();

        }
        return req;

    }


    public ResponseSpecification responseCommonUtility() {

        ResponseSpecification res = new ResponseSpecBuilder().expectStatusCode(200).expectContentType(ContentType.JSON).build();

        return res;
    }


    public static String getBaseURL(String key) throws IOException {

        Properties prop = new Properties();
        FileInputStream fis = new FileInputStream("src/test/java/resources/global.properties");
        prop.load(fis);
        return prop.getProperty(key);
    }

    public String getJsonPath(Response response, String key) {


        String result = response.asString();

        JsonPath js = new JsonPath(result);
        return js.get(key).toString();
    }
}
