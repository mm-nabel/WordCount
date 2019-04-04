package Lab3_2;



public class KeyValue <K,V> {
	public K key;
	public V value;
	public KeyValue(K ke, V vl) {
		this.key = ke;
		this.value = vl;
	}
	public KeyValue() {	}
	@Override
	public String toString() {
		return "["+key +" ; "+value+"]";
	}
	public KeyValue sumKeyValue(KeyValue k2) {
		KeyValue ok1 = (KeyValue) this.value;
		KeyValue ok2 = (KeyValue) k2.value;
		int k1k = Integer.parseInt(ok1.key.toString());
		int k2k = Integer.parseInt(ok2.key.toString());
		int k1v = Integer.parseInt(ok1.value.toString());
		int k2v = Integer.parseInt(ok2.value.toString());
		return new KeyValue(k1k+k2k, k1v+k2v);
	}
}
