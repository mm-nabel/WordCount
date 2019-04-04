package Lab3_2;

import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class WordCount {

	public static void main(String[] args) throws IOException {

		
		int mapperCount = getMappersCount("E:\\WordCount\\Lab3_2");
		for (int i = 1; i <= mapperCount; i++) {
			Mapper mp = new Mapper();
			System.out.println("Mapper " +(i-1)+ " Output");
			mp.mapping("E:\\WordCount\\Lab3_2\\data" + i + ".txt").stream().forEach(System.out::println);
		}
		
		
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
