package ua.edu.ucu.iterators;
import ua.edu.ucu.function.IntPredicate;
import java.util.Iterator;

public class FilterIterator implements Iterator<Integer> {
    private Iterator<Integer> IntIter;
    private IntPredicate pred;
    private Integer next;

    public FilterIterator(Iterator<Integer> IntIter, IntPredicate pred) {
        this.IntIter = IntIter;
        this.pred = pred;
        this.next = null;
    }

    @Override
    public boolean hasNext() {
        while (IntIter.hasNext()) {
            next = IntIter.next();
            if (pred.test(next)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public Integer next() {
        return next;
    }
}
