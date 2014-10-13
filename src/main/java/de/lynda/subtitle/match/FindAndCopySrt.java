package de.lynda.subtitle.match;

import java.io.File;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by djzhang on 10/13/14.
 */
public class FindAndCopySrt {
	private List<File> subtitleFileList = new LinkedList<File>();
	private List<File> destFileList = new LinkedList<File>();

	public FindAndCopySrt(File subtitleFold, File dest) {
		collectListInPath(subtitleFold, subtitleFileList);
		collectListInPath(dest, destFileList);
	}

	public void collectListInPath(File fold, List<File> list) {
		File[] files = fold.listFiles();

		for (File file : files) {
			if (file.isDirectory()) {
				collectListInPath(file, list);
			} else {
				list.add(file);
			}
		}
	}

	// public static void findAndCopy(File subtitleFold, File dest) {
	// File[] files = subtitleFold.listFiles();
	//
	// for (File subtitleFile : files) {
	//
	// if (subtitleFile.isDirectory()) {
	//
	// findAndCopy(subtitleFile, dest);
	//
	// } else {
	//
	// SearchSubtitleFile.findInDirectory(subtitleFile, dest);
	//
	// }
	//
	// }
	// }

}
