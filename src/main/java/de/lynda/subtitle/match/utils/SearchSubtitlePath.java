package de.lynda.subtitle.match.utils;

import java.io.File;

public class SearchSubtitlePath {

	public File searchPath;

	public void findInDirectory(File source, String name) {
		File[] files = source.listFiles();
		for (File f : files) {
			String fName = f.getName();
			if (f.isDirectory()) {
				findInDirectory(f, name);
			} else {
				if (CheckSameName.isMatch(fName, name)) {
					searchPath = f;
					return;
				}
			}
		}
	}
}
