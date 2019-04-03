package pack;

import java.io.FileNotFoundException;

public class Main {

	public static void main(String[] args) throws FileNotFoundException {
		
		Mapper myMappaerList = new Mapper();				
		myMappaerList.mapping("E:/data.txt").stream().forEach(System.out::println);	
	}
}
