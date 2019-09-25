package com.wordcount;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class WCRunner {
	static final Scanner scanFile = new Scanner(System.in);
	public static void main(String[] args) {
		File f = null;
		String filePath;
		do {
			if (f != null && !f.exists()) { // stops it from printing message the first time by "!=null" and only second
											// time onwards assuming no file is found.
				System.out.println("This file doesn't exist");
			}
			System.out.println("Please enter the file path that you would like to perform a word count on: ");
			filePath = scanFile.nextLine();
			f = new File(filePath);
		} while (!f.exists());

		String fileAsString = new WCRunner().fileInputReader(f);
		System.out.println("\nThe total word count of the file " + f + " is " + wordCount(fileAsString));
	}

	public static int wordCount(String stringToCount) {
		String[] stringArr = stringToCount.split("[\\s]+");
		int counter = 0;
		int countModifier = 0;
		for (String word : stringArr) {
			if (word.matches("[\\W]")) { // doesn't count words that are made up of non word characters
				countModifier--; // deducts these words from total count
				continue;
			}
			counter++;
			System.out.println(counter + " " + word);
		}
		int count = stringArr.length + countModifier;
		return count;

	}

	public String fileInputReader(File file) { // import file to read
		BufferedReader br;
		String str = ""; // empty String ready to add each line read by file one by one. Resulting in
							// total String of file.
		String a; // a represents each individual line read by Buffered reader as string.
		try {
			br = new BufferedReader(new FileReader(file));
			while ((a = br.readLine()) != null) {
				str += a;
			}

		} catch (FileNotFoundException fnf) {
			System.out.println("File not found.");
		} catch (IOException ioe) {
			ioe.printStackTrace();
		}
		return str;
	}
	/*
	 * public boolean fileValidator(String pathOfFile) { pathOfFile. }
	 */
}
