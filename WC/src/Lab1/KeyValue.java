package Lab1;

public class KeyValue <K,V> implements Comparable<KeyValue>{
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
	@Override
	public int compareTo(KeyValue o) {
		return this.key.toString().compareTo(o.key.toString());
		
	}

}
