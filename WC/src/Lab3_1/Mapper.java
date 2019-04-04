package Lab3_1;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import Lab3_2.KeyValue;

public class Mapper {

	public List<KeyValue<String, Integer>> mapping(String fileName) throws FileNotFoundException {
		
		String records = readFile(fileName);	
		
		List<String> words1ist = Arrays.asList(records.split(" |-|'|,|\""));
		
		List<KeyValue<String, Integer>> keyValueList = words1ist.stream()
				.filter(e -> !(e.equals("") || e.matches("^[a-zA-Z_]+?[\\._][a-zA-Z]{1,}$")))
				.map(e -> e.replace(".", ""))
				.map(e -> new KeyValue(e.toLowerCase(), 1))
				.collect(Collectors.toList());

		
		List<String> tmpList = new ArrayList();
		List<KeyValue<String, Integer>> newKvList = new ArrayList();
		for(KeyValue kv: keyValueList) {
			if(tmpList.isEmpty() || !tmpList.contains(kv.key.toString())) {
			tmpList.add(kv.key.toString());			
			Optional<KeyValue<String, Integer>> newkv = keyValueList.stream().filter(e -> e.key.toString().equals(kv.key.toString()))
			.reduce((k1,k2) -> new KeyValue(kv.key,(k1.value+k2.value)));
			newKvList.add(newkv.get());
			}
		}
		return newKvList;
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
