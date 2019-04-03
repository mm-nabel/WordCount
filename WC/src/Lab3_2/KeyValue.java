package Lab3_2;



public class KeyValue <K,V> {
	public K key;
	public V value;
	public KeyValue(K ke, V vl) {
		this.key = ke;
		this.value = vl;
	}
	@Override
	public String toString() {
		return "["+key +" ; "+value+"]";
	}

}
