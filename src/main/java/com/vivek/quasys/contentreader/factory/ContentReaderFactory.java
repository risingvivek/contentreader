package com.vivek.quasys.contentreader.factory;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URL;
import com.vivek.quasys.contentreader.ContentReader;
import com.vivek.quasys.contentreader.impl.FileContentReader;
import com.vivek.quasys.contentreader.impl.UrlContentReader;
/**
 * Using Factory pattern to read from the URI.
 * Calls the UrlConentReader if the provided a valid URL.
 * Else would call the FileContentReader to read from a local file.
 */
public class ContentReaderFactory {
	
	public ContentReader getContentReader(URI uri) throws IOException {
		
		if (uri == null) return null;
		
		if (isValidURI(uri)) {			
			return new UrlContentReader();
		} else {
			return new FileContentReader();
		}
	}
	
	private boolean isValidURI(URI uri) throws IOException {
		
		try {
			URL url = uri.toURL();
			HttpURLConnection huc = (HttpURLConnection) url.openConnection();
			int responseCode = huc.getResponseCode();
			if(responseCode == HttpURLConnection.HTTP_OK)
				return true;	
		} catch(IllegalArgumentException iae) {
			return false;
		}
		
		return false;
	}
}
