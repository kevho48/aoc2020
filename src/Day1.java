import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

//not the most optimal solution, probably could've used recursion

public class Day1 {

	public static void main(String[] args) {
		System.out.println("Hey guys it's ya boy Kevin working on day 1");

		populateExpenseReport();
		
		int[] part1Answer = find2NumbersThatAddTo2020();
		int[] part2Answer = find3NumbersThatAddTo2020();

		System.out.println("Product of 2 numbers that add to 2020 = " + part1Answer[0] * part1Answer[1]);
		System.out.println("Product of 3 numbers that add to 2020 = " + part2Answer[0] * part2Answer[1] * part2Answer[2]);

	}
	
	private static int[] find3NumbersThatAddTo2020() {
		int result1, result2, num = -1;
		
		for(int i = 0; i < Day1.expenseReport.size(); ++i) {
			result1 = Day1.expenseReport.get(i);
			num = total - result1;
			for(int j = i+1; j < Day1.expenseReport.size(); ++j) {
				result2 = Day1.expenseReport.get(j);
				if(Day1.expenseReport.contains(num - result2)) {
					int[] result = {result1, result2, num - result2};
					return result;
				}
			}
		}

		return null;
	}

	private static int[] find2NumbersThatAddTo2020() {
		int result2 = -1;
		
		for(int num : expenseReport) {
			result2 = Day1.total - num;
			
			if(expenseReport.contains(result2)) {
				int[] result = {num, result2};
				return result;
			}
		}
		
		return null;
	}
	
	private static void populateExpenseReport() {
		Day1.expenseReport = new ArrayList<>();
		
		try {
			Scanner scanner = new Scanner(new File(Day1.fileName));

			while (scanner.hasNextLine()) 
				Day1.expenseReport.add(scanner.nextInt());

			scanner.close();

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
	}
	
	private static int total = 2020;
	private static List<Integer> expenseReport;
	private static final String fileName = "src/inputs/day1input.txt";

}
