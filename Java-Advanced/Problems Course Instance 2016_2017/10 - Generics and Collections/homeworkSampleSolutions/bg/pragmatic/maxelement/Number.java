package bg.pragmatic.maxelement;

public class Number implements Comparable<Number> {

	private int actual;

	public Number(int actual) {
		this.actual = actual;
	}
	
	@Override
	public int compareTo(Number num) {
		if ( actual == num.actual) return 0;
		if ( actual > num.actual ) return -1;
		return 1;
	}

	@Override
	public String toString() {
		return String.valueOf(actual);
	}
}