import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Day2 {

	public static void main(String[] args) {
		System.out.println("Hey guys it's ya boy Kevin working on day 2");

		populatePasswords();

		part1();
		part2();
	}

	private static void part2() {
		int answer = 0;
		Pattern p = Pattern.compile(Day2.pattern);

		for (String s : Day2.passwords) {
			Matcher m = p.matcher(s);
			if (m.matches()) {

				int lowerPosition = Integer.parseInt(m.group(1)) - 1;
				int upperPosition = Integer.parseInt(m.group(2)) - 1;
				char character = m.group(3).charAt(0);
				String password = m.group(4);

				if (password.charAt(lowerPosition) == character ^ password.charAt(upperPosition) == character) {
					++answer;
				}
			}

		}

		System.out.println(answer);
	}

	private static void part1() {
		int answer = 0;

		Pattern p = Pattern.compile(Day2.pattern);

		for (String s : Day2.passwords) {
			Matcher m = p.matcher(s);
			if (m.matches()) {

				int lowerRange = Integer.parseInt(m.group(1));
				int upperRange = Integer.parseInt(m.group(2));
				char character = m.group(3).charAt(0);
				String password = m.group(4);
				int occurances = 0;
				for (int i = 0; i < password.length(); ++i) {
					if (occurances <= upperRange && password.charAt(i) == character)
						++occurances;
				}

				if (lowerRange <= occurances && occurances <= upperRange)
					++answer;
			}

		}

		System.out.println(answer);
	}

	private static void populatePasswords() {
		Day2.passwords = new ArrayList<>();

		try {
			Scanner scanner = new Scanner(new File(Day2.fileName));

			while (scanner.hasNextLine())
				Day2.passwords.add(scanner.nextLine());

			scanner.close();

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

	}

	private static List<String> passwords;
	private static final String fileName = "src/inputs/day2input.txt";
	private static final String pattern = "(\\d+)-(\\d+) (.): (.+)";

}
