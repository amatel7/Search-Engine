package com.se.model;

import java.util.HashMap;
import java.util.List;

/**
 * Model for data saved in Json
 * @author amantelkar
 *
 */
public class Books {
	public List<String> titles;
	public List<String> queries;
	public List<BookSummary> summaries;
	public HashMap<Integer, BookSummary> summaryhash;
	public List<BookAuthor> authors;

}
