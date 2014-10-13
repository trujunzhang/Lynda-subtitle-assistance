package de.lynda.subtitle.match;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class SearchAndCopyHelper {
	/**
	 * Define a global variable that identifies the name of a file that contains the developer's API key.
	 */
	private static final String PROPERTIES_FILENAME = "subtitle.properties";

	private static String source;
	private static String dest;

	public static void main(String[] args) {
		getResources();
	}

	public static void getResources() {
		// Read the developer key from the properties file.
		Properties properties = new Properties();
		try {
			InputStream in = SearchAndCopyHelper.class.getResourceAsStream("/" + PROPERTIES_FILENAME);
			properties.load(in);

		} catch (IOException e) {
			System.err.println("There was an error reading " + PROPERTIES_FILENAME + ": " + e.getCause() + " : "
					+ e.getMessage());
			System.exit(1);
		}

		source = properties.getProperty("subtitle.source.path");
		dest = properties.getProperty("media.source.path");
	}
}
