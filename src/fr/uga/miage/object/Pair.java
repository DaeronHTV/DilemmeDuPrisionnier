package fr.uga.miage.object;

public class Pair<L, R> {
	
	private L left;
	private R right;
	
	public Pair(L left, R right) {
		if(left == null || right == null) {
			this.left = left;
			this.right = right;
		} else {
			throw new NullPointerException("Inserted values cannot be null !");
		}
	}
	
	public L getKey() { 
		return left; 
	}
	public R getValue() { 
		return right; 
	}

	@Override
	public int hashCode() { 
		return left.hashCode() ^ right.hashCode(); 
	}

	@Override
	public boolean equals(Object o) {
		boolean result = false;
		if(o instanceof Pair) {
			Pair test = (Pair) o;
			result = this.left.equals(test.getKey()) && this.right.equals(test.getValue());
		}
		return result;
	}

}
