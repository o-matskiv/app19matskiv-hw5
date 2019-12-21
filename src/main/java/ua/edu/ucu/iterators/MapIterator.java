package ua.edu.ucu.iterators;
import java.util.Iterator;
import ua.edu.ucu.function.IntUnaryOperator;

public class MapIterator implements Iterator<Integer> {
    private Iterator<Integer> IntIter;
    private IntUnaryOperator mapper;

    public MapIterator(Iterator<Integer> iter, IntUnaryOperator mapper) {
        this.mapper = mapper;
        this.IntIter = iter;

    }

    public boolean hasNext() {
        return IntIter.hasNext();
    }
    @Override
    public Integer next() {
        return mapper.apply(IntIter.next());
    }

}
