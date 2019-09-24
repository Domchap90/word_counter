package com.wordcount;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class WCRunner {

	public static void main(String[] args) {
		File f = new File("/home/domchap90/Documents/GYM TODO");
		String fileAsString = new WCRunner().fileInputReader(f);
		System.out.println("The total word count of the file is " + wordCount(fileAsString));
	}

	public static int wordCount(String stringToCount) {
		// regex expression of 1 or more non worded characters separating spaces
		String[] stringArr = stringToCount.split("[\\W]+");
		int count = stringArr.length;
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
}
