package y23.day2;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Luis-St
 *
 */

@SuppressWarnings("DuplicatedCode")
public class Task2 {
	
	public static void main(String[] args) throws Exception {
		List<String> lines = Files.readAllLines(Paths.get("resources/y23/day2/input.txt"));
		int sum = 0;
		for (String line : lines) {
			Game game = parseGame(line);
			sum += (game.red() * game.green() * game.blue());
		}
		System.out.println(sum);
	}
	
	private static Game parseGame(String line) {
		String[] parts = line.split(": ");
		int id = Integer.parseInt(parts[0].replace("Game ", ""));
		List<Set> sets = parseSets(parts[1].split("; "));
		int red = 0, green = 0, blue = 0;
		for (Set set : sets) {
			red = Math.max(red, set.red());
			green = Math.max(green, set.green());
			blue = Math.max(blue, set.blue());
		}
		return new Game(id, red, green, blue);
	}
	
	private static List<Set> parseSets(String[] sets) {
		List<Set> setList = new ArrayList<>();
		for (String set : sets) {
			int red = 0, green = 0, blue = 0;
			String[] parts = set.split(", ");
			for (String part : parts) {
				if (part.endsWith(" blue")) {
					blue = Integer.parseInt(part.replace(" blue", ""));
				} else if (part.endsWith(" green")) {
					green = Integer.parseInt(part.replace(" green", ""));
				} else if (part.endsWith(" red")) {
					red = Integer.parseInt(part.replace(" red", ""));
				}
			}
			setList.add(new Set(red, green, blue));
		}
		return setList;
	}
	
	private record Game(int id, int red, int green, int blue) {}
	
	private record Set(int red, int green, int blue) {}
}
