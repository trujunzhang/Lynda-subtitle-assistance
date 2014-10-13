package de.lynda.subtitle.match.utils;

public class CheckSameName {

	public static boolean isMatch(String name, String match) {
		if (name.equals("Keynote '09 Essential Training")) {
			int x = 0;
		}
		name = name.toLowerCase();
		match = match.toLowerCase();

		String[] split = match.split(" ");

		int size = split.length;
		int step = 0;
		for (String s : split) {
			if (name.contains(s)) {
				step++;
			}
		}

		return step == size;
	}
}
