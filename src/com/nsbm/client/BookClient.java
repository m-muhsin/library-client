package com.nsbm.client;

import java.util.List;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.nsbm.model.Book;

public class BookClient {

	private Client client;

	public BookClient() {
		client = ClientBuilder.newClient();
	}
	
	public String getTest() {
		WebTarget target = client.target("http://localhost:8080/library-services/webapi/");
		Response response = target.path("books").request(MediaType.TEXT_PLAIN).get();
		return response.readEntity(String.class);
	}
	
	public List<Book> getBooks() {
		
		WebTarget target = client.target("http://localhost:8080/library-services/webapi/");
		List<Book> response = target.path("books/all").request(MediaType.APPLICATION_XML)
				.get(new GenericType<List<Book>> () {});
		return response;
	}
	
	public String getBook(String bookId) {
		
		WebTarget target = client.target("http://localhost:8080/library-services/webapi/");
		Response response = target.path("books/" + bookId).request(MediaType.APPLICATION_JSON)
				.get();
		if(response.getStatus() != 200) {
			System.out.println(response.getStatus() + ": there was an error in the server.");
			return null;
		};
		return response.readEntity(String.class);
	}
	
	public String addBook(Book book) {
		WebTarget target = client.target("http://localhost:8080/library-services/webapi/");
		Response response = target.path("books/book").request(MediaType.APPLICATION_XML)
				.post(Entity.entity(book, MediaType.APPLICATION_XML));
		return response.readEntity(String.class);
	}
}
