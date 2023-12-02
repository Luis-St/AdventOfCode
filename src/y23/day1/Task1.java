package y23.day1;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

/**
 *
 * @author Luis-St
 *
 */

public class Task1 {
	
	public static void main(String[] args) throws Exception {
		List<String> lines = Files.readAllLines(Paths.get("resources/y23/day1/input.txt"));
		int sum = 0;
		for (String line : lines) {
			if (line.isBlank()) {
				continue;
			}
			char firstNumber = '\0';
			char lastNumber = '\0';
			for (int i = 0; i < line.length(); i++) {
				char c = line.charAt(i);
				if (Character.isDigit(c)) {
					firstNumber = c;
					break;
				}
			}
			for (int i = line.length() - 1; i >= 0; i--) {
				char c = line.charAt(i);
				if (Character.isDigit(c)) {
					lastNumber = c;
					break;
				}
			}
			sum += Integer.parseInt(firstNumber + "" + lastNumber);
		}
		System.out.println(sum);
	}
}
