package Lab2_B;

import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import Lab3_2.ReducerInput;

public class WordCount {

	public static void main(String[] args) throws IOException {

		String filePath="E:\\\\WordCount\\\\data";
		System.out.println(getMappersCount("E:\\WordCount"));
		int mapperCount = getMappersCount("E:\\WordCount");
		List maaperOutPuts = new ArrayList();
		for (int i = 1; i <= mapperCount; i++) {
			Mapper mp = new Mapper();
			mp.mapping(filePath + i + ".txt").stream().forEach(System.out::println);
			maaperOutPuts.add(mp.mapping(filePath + i + ".txt"));
		}
		
		Partitioner p = new Partitioner();
		p.setPartitionCount(4);
		for(int i=0 ; i<4; i++) {
			List<ReducerInput> ri = new ArrayList();
			for(Object mo: maaperOutPuts) {
			//	p.getReducerInput(mo, i);
			
			}
		}
		
		
		
	}



	public static int getMappersCount(String filePath) throws IOException {
		Path dir = Paths.get(filePath);
		int count = (int) Files.walk(dir).parallel().filter(p -> !p.toFile().isDirectory()).count();
		return (int) count;
	}

}
