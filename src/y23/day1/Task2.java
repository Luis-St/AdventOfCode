package y23.day1;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

/**
 *
 * @author Luis-St
 *
 */

public class Task2 {
	
	private static final List<String> NUMBERS = Arrays.asList("one", "two", "three", "four", "five", "six", "seven", "eight", "nine");
	private static final int CHAR_OFFSET = 48;
	
	public static void main(String[] args) throws Exception {
		List<String> lines = Files.readAllLines(Paths.get("resources/y23/day1/input.txt"));
		int sum = 0;
		for (String line : lines) {
			if (line.isBlank()) {
				continue;
			}
			List<Number> numbers = getNumbers(line);
			char firstNumber = numbers.get(0).number();
			char lastNumber = numbers.get(numbers.size() - 1).number();
			sum += Integer.parseInt(firstNumber + "" + lastNumber);
		}
		System.out.println(sum);
	}
	
	private static List<Number> getNumbers(String line) {
		List<Number> numbers = new ArrayList<>();
		for (int i = 0; i < NUMBERS.size(); i++) {
			int index = line.indexOf(NUMBERS.get(i));
			if (index != -1) {
				numbers.add(new Number((char) (i + 1 + CHAR_OFFSET), index));
			}
			int lastIndex = line.lastIndexOf(NUMBERS.get(i));
			if (lastIndex != -1 && lastIndex != index) {
				numbers.add(new Number((char) (i + 1 + CHAR_OFFSET), lastIndex));
			}
		}
		for (int i = 0; i < line.length(); i++) {
			char c = line.charAt(i);
			if (Character.isDigit(c)) {
				numbers.add(new Number(c, i));
			}
		}
		numbers.sort(Comparator.comparingInt(Number::index));
		if (numbers.size() == 1) {
			numbers.add(numbers.get(0));
		}
		return numbers;
	}
	
	private record Number(char number, int index) {}
}
