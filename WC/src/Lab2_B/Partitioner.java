package Lab2_B;

import java.util.List;
import java.util.stream.Collectors;

public class Partitioner {

	private int partition = 1;
	
	public void setPartitionCount(int partiotionCount) {
		partition = partiotionCount;
	}

	public int getPartition(String key, int r) {
		int x = 0;
		
		if (r != 0)
			return Math.abs((int)  key.hashCode() % r);
		else
			return 0;
	}

	public List<ReducerInput> getReducerInput(List<ReducerInput> clusterInput, int pn) {

		List<ReducerInput> RI = clusterInput.stream()
				.filter(e -> getPartition(e.key.toString(), partition) == pn)
				.collect(Collectors.toList());
		return RI;

	}

}
