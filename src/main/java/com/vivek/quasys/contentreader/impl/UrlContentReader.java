package com.vivek.quasys.contentreader.impl;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URI;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import com.vivek.quasys.contentreader.ContentReader;

/**
 * The implementaion class that reads the content from the provided Url.
 */
public class UrlContentReader extends BaseContentReader implements ContentReader {

	@Override
	public void readContent(URI uri) {

		Map<Integer, Integer> wordsLengthMap = new HashMap<Integer, Integer>();

		Integer totalWordCount = 0;

		try {

			Scanner sc = new Scanner(uri.toURL().openStream());
			while (sc.hasNext()) {
				eachLengthCounter(sc.next().toString(), wordsLengthMap);
				totalWordCount++;
			}
			sc.close();
			System.out.println("Word count = " + totalWordCount);
			System.out.println("Average word length = " + calculateAverage(wordsLengthMap, totalWordCount));
			wordsLengthMap.forEach((k, v) -> System.out.println("Number of words of " + k + " is " + v));
			System.out.println("The most frequently occurring word length is " + maxUsedValue(wordsLengthMap).getKey()
					+ ", for word lengths of " + maxUsedValue(wordsLengthMap).getValue());
		} catch (FileNotFoundException e) {

			e.printStackTrace();
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
