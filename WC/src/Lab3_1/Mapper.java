package Lab3_1;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

public class Mapper {

	public List<KeyValue> mapping(String fileName) throws FileNotFoundException {

		String records = readFile(fileName);

		List<String> words1ist = Arrays.asList(records.split(" |-|,|\"|\\."));

		List<String> WordList = words1ist.stream()
				.filter(e -> !(e.equals("") || e.matches(".*\\d+.*") || e.matches(".*_.*"))).map(e -> e.toLowerCase())
				.collect(Collectors.toList());
		HashMap kvList = new HashMap<>();
		for (String w : WordList) {
			if (kvList.containsKey(w))
				kvList.put(w, Integer.parseInt(kvList.get(w).toString())+1);
		}
		//return keyValueList;
		return null;
	}

	public static String readFile(String fileName) {

		String line = "";
		try {
			FileReader fileReader = new FileReader(fileName);

			BufferedReader bufferedReader = new BufferedReader(fileReader);
			do {
				line += bufferedReader.readLine();
			} while (bufferedReader.ready());
			bufferedReader.close();
			return line;
		} catch (FileNotFoundException ex) {
			return "unable to open file '" + fileName + "'";
		} catch (IOException ex) {
			return "Error reading file '" + fileName + "'";
		}
	}
}
