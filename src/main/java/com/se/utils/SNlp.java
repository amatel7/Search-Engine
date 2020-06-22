package com.se.utils;

import java.util.HashMap;
import java.util.List;
import java.util.Properties;

import edu.stanford.nlp.ling.CoreAnnotations.LemmaAnnotation;
import edu.stanford.nlp.ling.CoreAnnotations.SentencesAnnotation;
import edu.stanford.nlp.ling.CoreAnnotations.TokensAnnotation;
import edu.stanford.nlp.ling.CoreLabel;
import edu.stanford.nlp.pipeline.Annotation;
import edu.stanford.nlp.pipeline.StanfordCoreNLP;
import edu.stanford.nlp.util.CoreMap;

/**
 * Utility for NLP using standford nlp core api
 * @author amantelkar
 *
 */
public class SNlp {

	protected StanfordCoreNLP pipeline;

	public SNlp() {
		Properties props;
		props = new Properties();
		props.put("annotators", "tokenize, ssplit, pos, lemma");

		this.pipeline = new StanfordCoreNLP(props);
	}

	public HashMap<String, Integer> lemmatize(String documentText) {
		documentText = removeUnnecessaryToken(documentText);
		HashMap<String, Integer> wordCount = new HashMap<String, Integer>();
		// create an empty Annotation just with the given text
		Annotation document = new Annotation(documentText);
		// run all Annotators on this text
		this.pipeline.annotate(document);
		// Iterate over all of the sentences found
		List<CoreMap> sentences = document.get(SentencesAnnotation.class);
		for (CoreMap sentence : sentences) {
			// Iterate over all tokens in a sentence
			for (CoreLabel token : sentence.get(TokensAnnotation.class)) {
				// Retrieve and add the lemma for each word into the list of lemmas
				String key = token.get(LemmaAnnotation.class);
				if (wordCount.get(key) != null) {
					wordCount.put(key, wordCount.get(key) + 1);
				} else {
					wordCount.put(key, 1);
				}
			}
		}
		return wordCount;
	}

	public String removeUnnecessaryToken(String str) {
		str = str.replaceAll("\\.", " ");
		str = str.replaceAll(",", " ");
		str = str.replaceAll(" a ", " ");
		str = str.replaceAll(" an ", " ");
		str = str.replaceAll(" the ", " ");
		str = str.replaceAll(" i ", " ");
		str = str.replaceAll(" is ", " ");
		str = str.replaceAll(" am ", " ");
		str = str.replaceAll(" the ", " ");
		str = str.replaceAll(" at ", " ");
		str = str.replaceAll(" of ", " ");
		str = str.replaceAll(" and ", " ");
		str = str.replaceAll(" will ", " ");
		str = str.replaceAll(" in ", " ");
		str = str.replaceAll(" but ", " ");
		str = str.replaceAll(" to ", " ");
		str = str.replaceAll(" for ", " ");
		str = str.replaceAll(" as ", " ");
		str = str.replaceAll(" that ", " ");
		str = str.replaceAll(" you ", " ");
		str = str.replaceAll(" your ", " ");

		str = str.replaceAll("a ", " ");
		str = str.replaceAll("an ", " ");
		str = str.replaceAll("the ", " ");
		str = str.replaceAll("i ", " ");
		str = str.replaceAll("is ", " ");
		str = str.replaceAll("is ", " ");
		str = str.replaceAll("am ", " ");
		str = str.replaceAll("the ", " ");
		str = str.replaceAll("at ", " ");
		str = str.replaceAll("of ", " ");
		str = str.replaceAll("and ", " ");
		str = str.replaceAll("will ", " ");
		str = str.replaceAll("in ", " ");
		str = str.replaceAll("but ", " ");
		str = str.replaceAll("to ", " ");
		str = str.replaceAll("for ", " ");
		str = str.replaceAll("as ", " ");
		str = str.replaceAll("that ", " ");
		str = str.replaceAll("you ", " ");
		str = str.replaceAll("your ", " ");

		return str;
	}

}
