package Lab2_A;

import java.util.List;
import java.util.ArrayList;

public class Reducer {
	
public List<KeyValue> reducing(List<ReducerInput> RIList){
	List<KeyValue> KVList = new ArrayList();
	for(ReducerInput ri: RIList) {
		KeyValue kv = new KeyValue(ri.key.toString(), 0);
		int sum =0;
		for(Object vl : ri.val) {
			sum+= Integer.parseInt(vl.toString());
		}
		kv.value = sum;
		KVList.add(kv);
	}	
	return KVList;
}

}
