package com.wordcount;

import java.io.IOException;
import java.util.Scanner;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;


public class Scraper {
	static final Scanner scan = new Scanner(System.in);

	public static void main(String[] args) {
		String userWebpage;
		String htmlString;
		do {
			System.out.println("Please enter the url of a webpage that you would like to perform a word count on: ");
			userWebpage = scan.nextLine();
		} while (validateURL(userWebpage) == false);

		htmlString = webPageReader(userWebpage);
		System.out.println(
				"The total word count of the web page " + userWebpage + " is " + WCRunner.wordCount(htmlString));
	}

	public static String webPageReader(String website) {
		try {
			Document doc = Jsoup.connect(website).userAgent("Mozilla/5.0 ").get();
			return doc.text();
		} catch (IllegalArgumentException iae) {
			System.out.println("The url entered is not valid! ");

		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

	public static boolean validateURL(String webpage) {
		boolean validator = true;
		try {
			Jsoup.connect(webpage).userAgent("Mozilla/5.0 ").get();
		} catch (IllegalArgumentException iae) {
			System.out.println("The url entered is not valid! ");
			validator = false;
		} catch (IOException e) {
			e.printStackTrace();
		}
		return validator;

	}

}
