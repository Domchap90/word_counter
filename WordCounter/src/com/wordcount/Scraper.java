package com.wordcount;

import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;


public class Scraper {

	public static void main(String[] args) {
		String url = "https://www.bbc.co.uk/news";
		String htmlString = webPageReader(url);
		System.out.println("The total word count of the web page " + url + " is " + WCRunner.wordCount(htmlString));

	}

	public static String webPageReader(String website) {
		try {
			Document doc = Jsoup.connect(website).userAgent("Mozilla/5.0 ").get();
			return doc.text();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
}
