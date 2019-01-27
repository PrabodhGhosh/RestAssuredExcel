package tests;

import java.io.IOException;
import static io.restassured.RestAssured.given;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import base.Base;
import io.restassured.RestAssured;
import utility.FetchData;

public class AddBook {
	
  @Test 
  public void verifyAddingBooks() throws IOException {
	  
	    Base.initialize();
		RestAssured.baseURI= Base.prop.getProperty("BaseURL");
		
		for(int i = 1; i<4; i++) {
		
		given()
		.header("Content-Type","application/json")
		.body("{\n" + 
				"\n" + 
				"\"name\":\"Learn Appium Automation with Java\",\n" + 
				"\"isbn\":\""+ FetchData.getData("AddBook", i, 1)+",\n" + 
				"\"aisle\":\""+FetchData.getData("AddBook", i, 2)+",\n" + 
				"\"author\":\"John foe\"\n" + 
				"}\n" + 
				" \n" + 
				"")
		.when()
		.post("/Library/Addbook.php")
		.then()
		.assertThat()
		.statusCode(200);
		}
	  
  }
  
  
  }