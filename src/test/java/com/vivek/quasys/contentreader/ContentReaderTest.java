package com.vivek.quasys.contentreader;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import com.vivek.quasys.contentreader.factory.ContentReaderFactory;

public class ContentReaderTest {
	
	private static ContentReaderFactory crFactory;
	private static ContentReader reader;
	
	
	@BeforeAll
	static void setup() {
		crFactory = new ContentReaderFactory();
	}	
	
	@Test
	public void testContentReader() throws URISyntaxException, IOException {
	
		URI uri = URI.create("src/main/resources/inputfile.txt");
		reader = crFactory.getContentReader(uri);
		Assertions.assertDoesNotThrow(() -> reader.readContent(uri));
		
	}
	
	@Test
	public void testURLContentReader() throws URISyntaxException, IOException {
	
		URI uri = URI.create("https://www.bible.com/en-GB/bible/1/GEN.1.KJV");
		reader = crFactory.getContentReader(uri);
		Assertions.assertDoesNotThrow(() -> reader.readContent(uri));
		
	}

}
