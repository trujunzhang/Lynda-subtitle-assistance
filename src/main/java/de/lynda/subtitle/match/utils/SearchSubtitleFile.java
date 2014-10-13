package de.lynda.subtitle.match.utils;

import java.io.File;

public class SearchSubtitleFile {

	public static void findInDirectory(File subtitleFile, File dest) {
		String subtitleFileName = subtitleFile.getName();

		File[] files = dest.listFiles();

		for (File movFile : files) {
			String fName = movFile.getName();

			if (movFile.isDirectory()) {

				findInDirectory(movFile, dest);

			} else {

				if (CheckSameName.isMatch(fName, subtitleFileName)) {
					// Copy subtitle file to dest fold
				}

			}
		}
	}
}
