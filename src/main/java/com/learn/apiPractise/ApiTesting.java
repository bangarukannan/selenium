package com.learn.apiPractise;

import com.jayway.restassured.RestAssured;
import com.jayway.restassured.response.Response;
import org.apache.http.entity.ContentType;
import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;

public class ApiTesting {

    public static void main(String[] args) throws JSONException {
        Response response = RestAssured.given().content(ContentType.APPLICATION_JSON).get("https://reqres.in/api/users/2");
        response.getBody().prettyPrint();
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("name","morpheus");
        jsonObject.put("job","zion resident");
        Response response1 = RestAssured.given().body(jsonObject).patch("https://reqres.in/api/users/2");
        response1.getBody().prettyPrint();
        response1.getBody();
    }
}
