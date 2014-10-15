package de.lynda.subtitle.match;

import de.lynda.subtitle.match.utils.SearchSubtitleFold;

import java.io.*;
import java.util.List;
import java.util.Properties;

public class SearchAndCopyHelper {
	/**
	 * Define a global variable that identifies the name of a file that contains the developer's API key.
	 */
	private static final String PROPERTIES_FILENAME = "subtitle.properties";

	private static File source;
	private static File dest;

	public static void main(String[] args) {
		getResources();
	}

	public static void getResources() {
		// Read the developer key from the properties file.
		Properties properties = new Properties();
		try {
			InputStream in = getInputStream();
			properties.load(in);

		} catch (IOException e) {
			System.err.println("There was an error reading " + PROPERTIES_FILENAME + ": " + e.getCause() + " : "
					+ e.getMessage());
			System.exit(1);
		}

		source = new File(properties.getProperty("subtitle.source.path"));
		dest = new File(properties.getProperty("media.source.path"));

		if (source.exists() == false) {
			System.out.println("not found *source* path: " + source.getAbsolutePath());
			System.exit(1);
		}
		if (dest.exists() == false) {
			System.out.println("not found *dest* path: " + dest.getAbsolutePath());
			System.exit(1);
		}

		SearchSubtitleFold searchSubtitleFold = new SearchSubtitleFold();
		searchSubtitleFold.findInDirectory(source, dest.getName());

		List<File> searchPath = searchSubtitleFold.searchPath;
		if (searchPath.size() == 0) {
			System.out.printf("not found");
		} else if (searchPath.size() > 1) {
			System.out.printf("found multiple path");
			for (int i = 0; i < searchPath.size(); i++) {
				System.out.println(searchPath.get(i).getAbsolutePath());
			}
		}

		File subtitleFold = searchPath.get(0);
		FindAndCopySrt findAndCopySrt = new FindAndCopySrt(subtitleFold, dest);
		findAndCopySrt.startFindAndCopyTask();
	}

	private static InputStream getInputStream() {
		String home = System.getenv("HOME");
		File desktopPath = new File(home, String.format("Desktop/Lynda-subtitle-assistance/config/%s",
				PROPERTIES_FILENAME));

		try {
			return new FileInputStream(desktopPath);
		} catch (FileNotFoundException e) {
			System.out.println("not found " + desktopPath.getAbsolutePath());
			e.printStackTrace();
		}
		return null;
	}
}
