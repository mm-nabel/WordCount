package Lab3_2;

import java.io.FileNotFoundException;

public class Main {

	public static void main(String[] args) throws FileNotFoundException {
		
		Mapper<?> myMappaerList = new Mapper();
		System.out.println("Mapper Output");
		myMappaerList.mapping("E:/data.txt").stream().forEach(System.out::println);
		
		System.out.println("\nShuffle sort Output ---> Rudecer Input");
		ShuffleSort ss = new ShuffleSort();
		ss.shufflingSorting(myMappaerList.mapping("E:/data.txt")).stream().forEach(System.out::println);
		
		Reducer Rc = new Reducer();
		System.out.println("\nRudecer Output");
		Rc.reducing(ss.shufflingSorting(myMappaerList.mapping("E:/data.txt"))).stream().forEach(System.out::println);
	}
}
