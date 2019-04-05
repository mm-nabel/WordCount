package Lab1;

import java.io.FileNotFoundException;

public class Main {

	public static void main(String[] args) throws FileNotFoundException {
		String filePath = "E:/data.txt";
		Mapper myMappaerList = new Mapper();				
		myMappaerList.mapping(filePath).stream().forEach(System.out::println);	
	}
}
