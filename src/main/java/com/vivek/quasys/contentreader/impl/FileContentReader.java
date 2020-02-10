package com.vivek.quasys.contentreader.impl;

import java.io.File;
import java.io.FileNotFoundException;
import java.net.URI;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import com.vivek.quasys.contentreader.ContentReader;

/**
 * 
 * The implementation class that reads the information from a file. It then
 * displays the output accordingly
 */
public class FileContentReader extends BaseContentReader implements ContentReader {

	@Override
	public void readContent(URI uri) {

		File fileName = new File(uri.getPath());

		Map<Integer, Integer> wordsLengthMap = new HashMap<Integer, Integer>();

		Integer totalWordCount = 0;

		try {
			Scanner sc = new Scanner(fileName);

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
		}

	}

}
