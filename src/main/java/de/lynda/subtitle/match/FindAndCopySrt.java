package de.lynda.subtitle.match;

import de.lynda.subtitle.match.utils.SearchSubtitleFile;

import java.io.File;

/**
 * Created by djzhang on 10/13/14.
 */
public class FindAndCopySrt {

	public static void findAndCopy(File subtitleFold, File dest) {
		File[] files = subtitleFold.listFiles();

		for (File subtitleFile : files) {

			if (subtitleFile.isDirectory()) {

				findAndCopy(subtitleFile, dest);

			} else {

				SearchSubtitleFile.findInDirectory(subtitleFile, dest);

			}

		}
	}
}
