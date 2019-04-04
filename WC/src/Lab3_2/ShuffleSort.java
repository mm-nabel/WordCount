package Lab3_2;

import java.util.ArrayList;
import java.util.List;

public class ShuffleSort {

	public List<ReducerInput> shufflingSorting(List<KeyValue> kv) {

		List<ReducerInput> reducerInputList = new ArrayList();
		int kvlngth = kv.size();
		List<String> tmpList = new ArrayList();
		for (int i = 0; i < kvlngth; i++) {
			ReducerInput ri = new ReducerInput<>();
			if (tmpList.isEmpty() || !tmpList.contains(kv.get(i).key.toString())) {
				tmpList.add(kv.get(i).key.toString());
				ri.key = kv.get(i).key;
				ri.val = new ArrayList();
				ri.val.add(kv.get(i).value);
				for (int j = 0; j < kvlngth; j++) {
					if (i != j && ri.key.toString().equals(kv.get(j).key)) {
						ri.val.add(kv.get(j).value);
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
