package ua.edu.ucu.iterators;
import ua.edu.ucu.function.IntToIntStreamFunction;

import java.util.Iterator;

public class FlatMapIterator implements Iterator<Integer>{
    private Iterator<Integer> IntIter;
    private IntToIntStreamFunction func;
    private StreamIterator streamIter;


    public FlatMapIterator(Iterator<Integer> IntIter, IntToIntStreamFunction func) {
        this.IntIter = IntIter;
        this.func = func;
    }
    @Override
    public boolean hasNext() {
        if (streamIter != null && streamIter.hasNext()) {
            return true;
        }
        if (IntIter.hasNext()) {
            streamIter = new StreamIterator(func.applyAsIntStream(IntIter.next()).toArray()) ;
            return true;
        }
        return false;
    }


    @Override
    public Integer next() {
        return streamIter.next();
    }
}
