package com.se.testcases;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;

import com.google.gson.Gson;
import com.se.FindBook;
import com.se.model.Book;
import com.se.model.BookSummary;
import com.se.utils.Utility;

public class SearchUtility {
	Gson gson = new Gson();

	@Test
	public void search() {
		List<String> qrys = Arrays.asList(new String[] { "is your problems", "achieve take book", "life sentences book",
				"relationships idea to", "new and mistakes", "life a all", "trying yourself your", "comparing to than",
				"are restaurant prices", "you and is", "writer book writing", "comedians details spent", "three you of",
				"the is production ", "have of customer", "explainable realize the", "your think thoughts ",
				"work the true", " and to", "a and in", "to opportunities words ", "of output thought",
				"christopher photos book", "condemned only the", "the human are", "that much it", "you book life",
				"how power not", "and he worked", "of book sentences ", "life resonate in", "practice the book",
				"assets be the", "from the the", "world development they", "eicmeciem coecmoecmec", "of them the",
				"the procrastination strategies", "sentences all of", "what based hope", "disconnect view we",
				"master of three", "improve reliable income", "a is gift", "capitalism of selection ",
				"we extra example ", "minds impacts it", "of memories brains", "and life that", "back tiny track",
				"brain creativity mirror", "easy thinking at", "great you from", "is his at", "skills three better" });

		Utility u = new Utility();
		for (String qry : qrys) {
			List<BookSummary> ll = u.search(qry, 3);
			System.out.println("Query ===== " + qry);
			System.out.println("Results === " + gson.toJson(ll));
			System.out.println("================================");
			System.out.println("================================");
		}

	}

	@Test
	public void searchBook() {
		List<String> qrys1 = Arrays.asList(
				new String[] { "is your problems", "achieve take book", "life sentences book", "relationships idea to",
						"new and mistakes", "life a all", "trying yourself your", "comparing to than" });

		List<String> qrys2 = Arrays.asList(new String[] { "are restaurant prices", "you and is", "writer book writing",
				"comedians details spent", "three you of", "the is production ", "have of customer",
				"explainable realize the", "your think thoughts " });

		List<String> qrys3 = Arrays.asList(new String[] { "work the true", " and to", "a and in",
				"to opportunities words ", "of output thought", "christopher photos book", "condemned only the",
				"the human are", "that much it", "you book life" });

		List<String> qrys4 = Arrays.asList(new String[] { "how power not", "and he worked", "of book sentences ",
				"life resonate in", "practice the book", "assets be the", "from the the", "world development they",
				"eicmeciem coecmoecmec", "of them the" });

		List<String> qrys5 = Arrays.asList(new String[] { "the procrastination strategies", "sentences all of",
				"what based hope", "disconnect view we", "master of three", "improve reliable income", "a is gift",
				"capitalism of selection " });

		List<String> qrys6 = Arrays.asList(new String[] { "we extra example ", "minds impacts it", "of memories brains",
				"and life that", "back tiny track", "brain creativity mirror", "easy thinking at", "great you from",
				"is his at", "skills three better" });

		FindBook fb = new FindBook();

		List<Book> ll = fb.findAll(qrys1, 3);
		System.out.println("Results === " + gson.toJson(ll));
		System.out.println("================================");
		System.out.println("================================");
		
		
		List<Book> ll1 = fb.findAll(qrys2, 3);
		System.out.println("Results === " + gson.toJson(ll1));
		System.out.println("================================");
		System.out.println("================================");
		
		
		List<Book> ll2 = fb.findAll(qrys3, 3);
		System.out.println("Results === " + gson.toJson(ll2));
		System.out.println("================================");
		System.out.println("================================");
		
		
		List<Book> ll3 = fb.findAll(qrys4, 3);
		System.out.println("Results === " + gson.toJson(ll3));
		System.out.println("================================");
		System.out.println("================================");
		
		
		
		List<Book> ll4 = fb.findAll(qrys5, 3);
		System.out.println("Results === " + gson.toJson(ll4));
		System.out.println("================================");
		System.out.println("================================");
		
		
		
		List<Book> ll5 = fb.findAll(qrys6, 3);
		System.out.println("Results === " + gson.toJson(ll5));
		System.out.println("================================");
		System.out.println("================================");
		
		

	}

}
