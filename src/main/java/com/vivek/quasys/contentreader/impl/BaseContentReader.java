package com.vivek.quasys.contentreader.impl;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

/**
 * 
 * Base abstract class having the common methods used by the implementation class for ContentReader.
 */
public abstract class BaseContentReader {
	
	/**
	 * Count the length of each word. Also takes care of dot.
	 * @param str the input string.
	 * @param wordsLengthMap the map that gets populated with input string length and total count.
	 */
	public void eachLengthCounter(String str, Map<Integer, Integer> wordsLengthMap) {
		
		str = str.replace(".", "");
		Integer strLength = str.length();
		Integer count = wordsLengthMap.get(strLength);
		if (count != null) count++;
		else count = 1;
		
		wordsLengthMap.put(strLength, count);
	
	}
	
	/**
	 * Calculate the average word length.
	 * @param wordsLengthMap the HashMap containing the word length and the count.
	 * @param totalWordCount the total word count.
	 * @return the average word length of type BigDecimal.
	 */
	public BigDecimal calculateAverage(Map<Integer, Integer> wordsLengthMap, Integer totalWordCount) {
        
		List<Integer> valueList = new ArrayList<Integer>();
		
		wordsLengthMap.forEach((k,v)-> valueList.add(k * v));
		
	    double sumValue = valueList.stream().mapToDouble(a -> a).sum();
	    
		return BigDecimal.valueOf(sumValue).divide(BigDecimal.valueOf(totalWordCount), 3, RoundingMode.HALF_UP);

	}
	
	/**
	 * Find the most frequently occuring word.
	 * @param <K> the key.
	 * @param <V> the value.
	 * @param the input map.
	 * @return the most frequently occuring word.
	 */
	public <K, V extends Comparable<V>> Entry<K, V> maxUsedValue(Map<K, V> map) {
	    Map.Entry<K, V> maxEntry = Collections.max(map.entrySet(), (Map.Entry<K, V> e1, Map.Entry<K, V> e2) -> e1.getValue()
	        .compareTo(e2.getValue()));
	    return maxEntry;
	}

}
