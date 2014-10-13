package de.lynda.subtitle.match.utils;

import java.io.File;
import java.util.LinkedList;
import java.util.List;

public class SearchSubtitleAndCopyTask {

	public static void execute(File movFile, List<File> subtitleFileList) {
		List<File> matchList = new LinkedList<File>();

		for (File subtitleFile : subtitleFileList) {
			String movFileName = movFile.getName();
			String subtitleFileName = subtitleFile.getName();

			if (CheckSameName.isMatchWithoutNumber(movFileName, subtitleFileName)) {
				matchList.add(subtitleFile);
			}

		}

		if (matchList.size() > 0) {
			int x = 0;
		}

	}

}
