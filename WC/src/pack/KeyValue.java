package pack;

public class KeyValue {
	public String ke;
	public int vl;
	public KeyValue(String ke, int vl) {
		this.ke = ke;
		this.vl = vl;
	}
	@Override
	public String toString() {
		return "["+ke +" ; "+vl+"]";
	}

}
