package com.se.lemma;

import java.io.IOException;
import java.util.List;

import org.apache.http.client.ClientProtocolException;
import org.junit.Test;

import com.google.gson.Gson;
import com.se.FindBook;
import com.se.model.BookSummary;
import com.se.model.PostRequest;
import com.se.utils.Utility;


public class Lemmatization {
	
	
	@Test
	public void post() throws ClientProtocolException, IOException {
		
		System.out.println(new FindBook().findAuthor(new Gson().toJson(new PostRequest(-1))));
	}
	
//	@Test
	public void test() throws IOException {
//		Book b = new Book();
		Utility u = new Utility();
		
		
//		System.out.println(removeUnnecessaryToken("is your problems"));

		List<BookSummary> ll = u.search("is your problems", 3);
		System.out.println("result" + ll.size());
		
		System.out.println(new Gson().toJson(ll));
		for(BookSummary bs : ll) {
			System.out.println(bs.summary);
		}
	}
	
}
