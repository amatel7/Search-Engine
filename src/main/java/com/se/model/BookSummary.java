package com.se.model;

import java.util.HashMap;

/**
 * Model for Book Summary Object
 * @author amantelkar
 *
 */
public class BookSummary {
	public Integer id;
	public String summary;
	public HashMap<String, Integer> wordCounts;

	public BookSummary() {

	}

	public BookSummary(BookSummary bs) {
		this.id = bs.id;
		this.summary = bs.summary;
	}
}
