package com.se.utils;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.gson.Gson;
import com.se.model.Books;
import com.se.model.BookSummary;

/**
 * Utility for reading the data from file 
 * @author amantelkar
 *
 */
public class Utility {

	static final Logger LOG = LoggerFactory.getLogger(Utility.class);

	public static Books books;
	public static SNlp nlp;

	Gson gson = new Gson();
	static {
		try {
			books = readData();
			books.summaryhash = new HashMap<>();

			nlp = new SNlp();
			for (BookSummary sum : books.summaries) {
				books.summaryhash.put(sum.id, sum);
				sum.wordCounts = nlp.lemmatize(sum.summary.replace("The Book in Three Sentences:", ""));
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static Books readData() throws IOException {
		BufferedReader reader = new BufferedReader(
				new FileReader("/Users/amantelkar/workspace/temp/Search-Engine/data.json"));
		StringBuilder stringBuilder = new StringBuilder();
		String line = null;
		String ls = System.getProperty("line.separator");
		while ((line = reader.readLine()) != null) {
			stringBuilder.append(line);
			stringBuilder.append(ls);
		}
		// delete the last new line separator
		stringBuilder.deleteCharAt(stringBuilder.length() - 1);
		reader.close();

		String content = stringBuilder.toString();

		return new Gson().fromJson(content, Books.class);
	}

	public List<BookSummary> search(String query, Integer limit) {
		List<BookSummary> bss = new ArrayList<BookSummary>();

		HashMap<String, Integer> qCount = nlp.lemmatize(query);
		Map<Integer, Map<String, Integer>> countPresentInSearch = new HashMap<Integer, Map<String, Integer>>();
		HashMap<Integer, Integer> countVal = new HashMap<Integer, Integer>();
		if (qCount.size() > 0) {
			for (BookSummary bs : books.summaries) {
				HashMap<String, Integer> summqCount = new HashMap<>();
				Integer totalCount = 0;
				for (String key : qCount.keySet()) {
					if (bs.wordCounts.get(key) != null) {
						summqCount.put(key, bs.wordCounts.get(key));
						totalCount = totalCount + bs.wordCounts.get(key);
					}

				}
				countPresentInSearch.put(bs.id, summqCount);
				countVal.put(bs.id, totalCount);

			}
		}
		countVal = sortMapReverse(countVal);
		if (limit == null) {
			limit = countVal.size();
		}

		int counter = 0;
		for (Integer i : countVal.keySet()) {
			BookSummary bs = new BookSummary(books.summaryhash.get(i));
			bss.add(bs);
			counter++;
			if (counter >= limit) {
				break;
			}
		}

		return bss;
	}


	public HashMap<Integer, Integer> sortMapReverse(HashMap<Integer, Integer> countVal) {

		HashMap<Integer, Integer> sortedMap = new LinkedHashMap<>();
		countVal.entrySet().stream().sorted(Map.Entry.comparingByValue())
				.forEachOrdered(x -> sortedMap.put(x.getKey(), x.getValue()));

		HashMap<Integer, Integer> reverseSortedMap = new LinkedHashMap<>();
		countVal.entrySet().stream().sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
				.forEachOrdered(x -> reverseSortedMap.put(x.getKey(), x.getValue()));

		return reverseSortedMap;
	}
}
