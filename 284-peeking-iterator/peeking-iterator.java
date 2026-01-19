// Java Iterator interface reference:
// https://docs.oracle.com/javase/8/docs/api/java/util/Iterator.html

class PeekingIterator implements Iterator<Integer> {
    Iterator<Integer> itr;
    Integer nextEl;

    public PeekingIterator(Iterator<Integer> iterator) {
        this.itr = iterator;
        nextEl = itr.next();
    }

    // Returns the next element in the iteration without advancing the iterator.
    public Integer peek() {
        return nextEl;
    }

    // hasNext() and next() should behave the same as in the Iterator interface.
    // Override them if needed.
    @Override
    public Integer next() {
        Integer temp = nextEl;
        nextEl = null;
        if (itr.hasNext())
            nextEl = itr.next();
        return temp;
    }

    @Override
    public boolean hasNext() {
        return nextEl != null;
    }
}
