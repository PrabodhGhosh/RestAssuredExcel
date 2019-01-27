package tests;

import static io.restassured.RestAssured.given;

import java.io.IOException;


import org.testng.annotations.Test;

import base.Base;
import io.restassured.RestAssured;
import utility.FetchData;


public class DeleteBook {
	
	@Test 
	
	public void verifyDeleteBook() throws IOException {

    Base.initialize();
	RestAssured.baseURI= Base.prop.getProperty("BaseURL");
	
	for(int i=1;i<4; i++)
		
	{
	
	given()
	.header("Content-Type","application/json")
	.body("{\n" + 
			" \n" + 
			"\"ID\" : \""+FetchData.getData("DeleteBook", i, 1)+"\n" + 
			" \n" + 
			"}\n" + 
			"")
	.when()
	.post("/Library/DeleteBook.php")
	.then()
	.assertThat()
	.statusCode(200);
	
	}
	
}
}