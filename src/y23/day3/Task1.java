package y23.day3;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class Task1 {
	
	public static void main(String[] args) throws Exception {
		List<String> lines = Files.readAllLines(Paths.get("resources/y23/day3/input.txt"));
		int sum = 0;
		
		for (int i = 0; i < lines.size(); i++) {
			String line = lines.get(i);
			
			StringBuilder sb = new StringBuilder();
			for (int j = 0; j < line.length(); j++) {
				char c = line.charAt(j);
				if (Character.isDigit(c)) {
					sb.append(c);
				} else if (!sb.isEmpty()) {
					checkNumber(Integer.parseInt(sb.toString()));
					sb.setLength(0);
				}
			}
		}
	}
	
	private static void checkNumber(int number) {
		System.out.println(number);
	}
}
