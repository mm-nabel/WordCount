package Lab3_1;

import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class WordCount {

	public static void main(String[] args) throws IOException {

	
		int mapperCount = getMappersCount("E:\\WordCount\\Lab3_1");
		for (int i = 1; i <= mapperCount; i++) {
			Mapper mp = new Mapper();
			System.out.println("Mapper "+ (i-1) +" output");	
			mp.mapping("E:\\WordCount\\Lab3_1\\data" + i + ".txt").stream().forEach(System.out::println);
		}
		
//		int reducerCount = getMappersCount("E:\\WordCount");
//		for (int i = 1; i <= mapperCount; i++) {
//			Mapper mp = new Mapper();
//			mp.mapping("E:\\WordCount\\data" + i + ".txt").stream().forEach(System.out::println);
//		}
		
	}

	public int getPartition(String key, int r) {
		if (r != 0)
			return (int) key.hashCode() % r;
		else
			return 0;
	}

	public static int getMappersCount(String filePath) throws IOException {
		Path dir = Paths.get(filePath);
		int count = (int) Files.walk(dir).parallel().filter(p -> !p.toFile().isDirectory()).count();

		return (int) count;
	}

}
