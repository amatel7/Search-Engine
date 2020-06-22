package com.se;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.google.gson.Gson;
import com.se.model.Book;
import com.se.model.BookSummary;
import com.se.model.PostRequest;
import com.se.model.PostResponse;
import com.se.utils.SEHttp;
import com.se.utils.Utility;

public class FindBook {
	static Gson gson = new Gson();
	static SEHttp HTTP = new SEHttp();
	static String URL = "https://ie4djxzt8j.execute-api.eu-west-1.amazonaws.com/coding";

	public static void main(String[] args) {
		// example
		List<String> qrys = Arrays.asList(new String[] { "is your problems", "achieve take book" });

		FindBook fb = new FindBook();
		fb.findAll(qrys, 3);
	}

	public List<Book> findAll(List<String> queries, Integer limit) {
		Utility utils = new Utility();

		List<BookSummary> ll = new ArrayList<BookSummary>();
		List<Book> books = new ArrayList<Book>();
		for (String qry : queries) {
			ll = utils.search(qry, limit);
			for (BookSummary bs : ll) {
				Book book = new Book();
				book.id = bs.id;
				book.author = findAuthor(gson.toJson(new PostRequest(bs.id)));
				book.query = qry;
				book.summary = bs.summary;

				if (!books.contains(book)) {
					books.add(book);
				}

			}
		}
		return books;
	}

	public String findAuthor(String data) {
		String result = null;

		try {
			result = gson.fromJson(SEHttp.post(URL, data), PostResponse.class).author;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

}
