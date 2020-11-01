package fr.uga.miage.object;

public class Triplet<L, M, R>{
	private L left;
	private M middle;
	private R right;
	
	public Triplet(L left, M middle, R right) {
		if(left != null && right != null && middle != null) {
			this.left = left;
			this.right = right;
			this.middle = middle;
		} else {
			throw new NullPointerException("Inserted values cannot be null !");
		}
	}
	
	public L getLeft() { 
		return left; 
	}
	public R getRight() { 
		return right; 
	}
	
	public M getMiddle() {
		return middle;
	}
	
	public void setLeft(L left) {
		this.left = left;
	}
	
	public void setRight(R right) {
		this.right = right;
	}
	
	public void setMiddle(M middle) {
		this.middle = middle;
	}

	@Override
	public int hashCode() { 
		return this.left.hashCode() ^ this.right.hashCode() ^ this.middle.hashCode(); 
	}

	@Override
	public boolean equals(Object o) {
		boolean result = false;
		if(o instanceof Triplet) {
			Triplet test = (Triplet) o;
			result = this.left.equals(test.getLeft()) && this.right.equals(test.getRight()) && this.middle.equals(test.getMiddle());
		}
		return result;
	}
}
