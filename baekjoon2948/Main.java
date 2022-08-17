package baekjoon2948;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.format.TextStyle;
import java.util.Locale;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String[] s = br.readLine().split(" ");

		int D = stoi(s[0]);
		int M = stoi(s[1]);

		LocalDate date = LocalDate.of(2009, M, D);

		DayOfWeek dayOfWeek = date.getDayOfWeek();
		System.out.println(dayOfWeek.getDisplayName(TextStyle.FULL, Locale.US));

	}

	static int stoi(String s) {
		return Integer.parseInt(s);
	}

}
