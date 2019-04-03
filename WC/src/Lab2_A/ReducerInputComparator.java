package Lab2_A;

import java.util.*;

public class ReducerInputComparator implements Comparator<ReducerInput>{

	@Override
	public int compare(ReducerInput p1, ReducerInput p2) {
		return p1.key.toString().compareTo(p2.key.toString());				
	}
}

