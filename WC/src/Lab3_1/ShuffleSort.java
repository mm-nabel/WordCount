package Lab3_1;

import java.util.ArrayList;
import java.util.List;

public class ShuffleSort {

	public List<ReducerInput> shufflingSorting(List<Lab3_2.KeyValue<String, Integer>> list) {

		List<ReducerInput> reducerInputList = new ArrayList();
		int kvlngth = list.size();
		List<String> tmpList = new ArrayList();
		for (int i = 0; i < kvlngth; i++) {
			ReducerInput ri = new ReducerInput<>();
			if (tmpList.isEmpty() || !tmpList.contains(list.get(i).key.toString())) {
				tmpList.add(list.get(i).key.toString());
				ri.key = list.get(i).key;
				ri.val = new ArrayList();
				ri.val.add(list.get(i).value);
				for (int j = 0; j < kvlngth; j++) {
					if (i != j && ri.key.toString().equals(list.get(j).key)) {
						ri.val.add(list.get(j).value);
					}
				}
			}
			if(ri.key != null)
				reducerInputList.add(ri);
		}
		sorting(reducerInputList);
		return reducerInputList;
	}
	private void sorting(List<ReducerInput> reducerInputList) {
		ReducerInputComparator comp = new ReducerInputComparator();
		reducerInputList.sort(comp);
	}

}
