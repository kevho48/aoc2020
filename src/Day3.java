import java.io.File;
import java.io.FileNotFoundException;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Day3 {

	public static void main(String[] args) {
		System.out.println("Hey guys it's ya boy Kevin working on day 3");

		populateTrees();
		
		Integer[] slope1 = {1,1};
		Integer[] slope2 = {3,1};
		Integer[] slope3 = {5,1};
		Integer[] slope4 = {7,1};
		Integer[] slope5 = {1,2};
		Day3.slopes.put(1, slope1);
		Day3.slopes.put(2, slope2);
		Day3.slopes.put(3, slope3);
		Day3.slopes.put(4, slope4);
		Day3.slopes.put(5, slope5);
		int result1 = determineTrees(1);
		int result2 = determineTrees(2);
		int result3 = determineTrees(3);
		int result4 = determineTrees(4);
		int result5 = determineTrees(5);
		
		BigInteger result1big = BigInteger.valueOf(result1);
		BigInteger result2big = BigInteger.valueOf(result2);
		BigInteger result3big = BigInteger.valueOf(result3);
		BigInteger result4big = BigInteger.valueOf(result4);
		BigInteger result5big = BigInteger.valueOf(result5);
		BigInteger result = result1big.multiply(result2big).multiply(result3big).multiply(result4big).multiply(result5big);
				
		System.out.println(result1);
		System.out.println(result2 + " part 1 answer");
		System.out.println(result3);
		System.out.println(result4);
		System.out.println(result5);
		System.out.println(result);
	}
	
	private static int determineTrees(int slopeNum) {
		int[] position = {0,0};
		int treesHit = 0;
		
		while(position[1] < Day3.trees.size()) {
			if(Day3.trees.get(position[1]).charAt(position[0]) == '#')
				++treesHit;
		
			position[0] = (position[0] + Day3.slopes.get(slopeNum)[0]) % Day3.trees.get(position[1]).length();
			position[1] += Day3.slopes.get(slopeNum)[1];
			
		}
		
		return treesHit;
	}
	
	private static void populateTrees() {
		Day3.trees = new ArrayList<>();

		try {
			Scanner scanner = new Scanner(new File(Day3.fileName));

			while (scanner.hasNextLine())
				Day3.trees.add(scanner.nextLine());

			scanner.close();

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

	}

	private static List<String> trees;
	private static final String fileName = "src/inputs/day3input.txt";
	private static Map<Integer, Integer[]> slopes = new HashMap<>();
}
