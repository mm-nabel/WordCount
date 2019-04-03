package Lab3_2;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Mapper {

	public List<KeyValue> mapping(String fileName) throws FileNotFoundException {
		
		String records = readFile(fileName);	
		
		List<String> words1ist = Arrays.asList(records.split(" |-|,|\"|\\."));
		
		List<KeyValue> keyValueList = words1ist.stream().filter(e -> !(e.equals("") || e.matches(".*\\d+.*") || e.matches(".*_.*")))
				.map(e -> new KeyValue(e.toLowerCase(), 1))
				//.sorted()
				.collect(Collectors.toList());

		
		return keyValueList;
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
