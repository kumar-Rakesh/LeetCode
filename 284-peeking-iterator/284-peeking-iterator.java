// Java Iterator interface reference:
// https://docs.oracle.com/javase/8/docs/api/java/util/Iterator.html

class PeekingIterator implements Iterator<Integer> {
    
    private boolean hasNext;
    private Integer nextVal;
    private Iterator<Integer> iterator;
    
	public PeekingIterator(Iterator<Integer> iterator) {
	    this.iterator= iterator;
        if(this.iterator.hasNext()){
            this.hasNext = true;
            this.nextVal = this.iterator.next();
        }else{
            this.hasNext = false;
        }
	}
	
    // Returns the next element in the iteration without advancing the iterator.
	public Integer peek() {
        return this.nextVal;
	}
	
	// hasNext() and next() should behave the same as in the Iterator interface.
	// Override them if needed.
	@Override
	public Integer next() {
	    Integer res = this.nextVal;
        if(this.iterator.hasNext()){
            this.nextVal = this.iterator.next();
        }else{
            this.hasNext = false;
        }
        return res;
	}
	
	@Override
	public boolean hasNext() {
	    return this.hasNext;
	}
}