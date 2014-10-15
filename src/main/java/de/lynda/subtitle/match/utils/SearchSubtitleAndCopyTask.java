package de.lynda.subtitle.match.utils;

import java.io.*;
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

		if (matchList.size() == 0) {

		} else if (matchList.size() == 1) {
			File fromFile = matchList.get(0);
			copyFile(fromFile.getAbsolutePath(), movFile.getAbsolutePath().replace(".mov", ".srt"));
		} else if (matchList.size() > 1) {
		}

	}

	public static void copyFile(String from, String to) {
		try {
			// Copy from file
			DataInputStream in = new DataInputStream(new BufferedInputStream(new FileInputStream(from)));
			// Copy to: path
			DataOutputStream out = new DataOutputStream(new BufferedOutputStream(new FileOutputStream(to)));

			byte[] buf = new byte[1024]; // size: 1024 byte
			int len;

			while ((len = in.read(buf)) > 0) {
				out.write(buf, 0, len);
			}

			in.close();
			out.close();

		} catch (FileNotFoundException e) {
			System.out.println("Файл не найден: " + e.getMessage());
		} catch (EOFException e1) {
			System.out.println("Достигнут конец файла: " + e1.getMessage());
		} catch (IOException e2) {
			System.out.println("Проблема при чтении файла: " + e2.getMessage());
		} finally {
			// System.out.println("Операция прошла успешно");
		}
	}

}
