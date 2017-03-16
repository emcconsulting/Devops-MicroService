package com.emc.ps.appmod;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;

import org.testng.annotations.Test;

import com.consol.citrus.annotations.CitrusTest;
import com.consol.citrus.dsl.testng.TestNGCitrusTestDesigner;
import com.consol.citrus.http.client.HttpClient;
import com.consol.citrus.message.Message;
import com.consol.citrus.message.MessageType;
import com.fasterxml.jackson.core.JsonProcessingException;


@Test
public class BookIT extends TestNGCitrusTestDesigner {

	@Autowired
	@Qualifier("tntCitrusClient")
	private HttpClient tntClient;

	@CitrusTest
	public void testInfo()
			throws JsonProcessingException {
		http()
		.client(tntClient)
		.get("/api/utilities/book/info")
		.payload("[\"New MS1!!!\"]");
	}
	
	@CitrusTest
	public void testGetBookById()
			throws JsonProcessingException {
		
		variable("bookId", 1);
		variable("name", "Kite Runner");
		variable("author", "Khalid hosseini");
		variable("price", 350.0);
		variable("isbn", "B001");
		
		http()
        	.client(tntClient)
        	.send()
        	.get("/api/utilities/book/${bookId}")
        	.accept("application/json");
        

        http()
            .client(tntClient)
            .receive()
            .response(HttpStatus.OK)
            .messageType(MessageType.JSON)
            .payload("{ \"id\": ${bookId}, \"name\": \"${name}\", \"author\": \"${author}\","
            		+ " \"price\": ${price},\"isbn\":\"${isbn}\"}");
		
		
	}
}
