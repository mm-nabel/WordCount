package Lab2_A;

import java.io.FileNotFoundException;

public class Main {

	public static void main(String[] args) throws FileNotFoundException {
		String filePath = "E:/data.txt";
		Mapper myMappaerList = new Mapper();
		System.out.println("Mapper Output");
		myMappaerList.mapping(filePath).stream().forEach(System.out::println);
		
		System.out.println("\nShuffle sort Output ---> Rudecer Input");
		ShuffleSort ss = new ShuffleSort();
		ss.shufflingSorting(myMappaerList.mapping(filePath)).stream().forEach(System.out::println);
		
		Reducer Rc = new Reducer();
		System.out.println("\nRudecer Output");
		Rc.reducing(ss.shufflingSorting(myMappaerList.mapping(filePath))).stream().forEach(System.out::println);
	}
}
