package ua.edu.ucu.stream;

import ua.edu.ucu.function.*;
import java.util.ArrayList;
import java.util.Iterator;
import ua.edu.ucu.iterators.FilterIterator;
import ua.edu.ucu.iterators.FlatMapIterator;
import ua.edu.ucu.iterators.MapIterator;
import ua.edu.ucu.iterators.StreamIterator;

public class AsIntStream implements IntStream {
    private Iterator<Integer> IntIter;
    public AsIntStream(Iterator<Integer> IntIter) {
        this.IntIter = IntIter;
    }

    public static IntStream of(int... values) {
        return new AsIntStream(new StreamIterator(values));
    }

    @Override
    public Double average() {
        if (!IntIter.hasNext()) {
            throw new IllegalArgumentException();
        }
        int[] IntArray= toArray();
        double sum = 0.0;
        for (int i : IntArray){
            sum += i;
        }
        int size = IntArray.length;
        return sum/size;
    }

    @Override
    public Integer max() {
        if (!IntIter.hasNext()) {
            throw new IllegalArgumentException();
        }
        int[] IntArray= toArray();
        int max = IntArray[0];
        for (int i : IntArray){
            if (i>max){
                max = i;
            }

        }
        return max;
    }

    @Override
    public Integer min() {
        if (!IntIter.hasNext()) {
            throw new IllegalArgumentException();
        }
        int[] IntArray= toArray();
        int min = IntArray[0];
        for (int i : IntArray){
            if (i<min){
                min = i;
            }

        }
        return min;
    }

    @Override
    public long count() {
        int[] IntArray= toArray();
        return IntArray.length;
    }

    @Override
    public Integer sum() {
        Integer sum = 0;
        while(IntIter.hasNext()) {
            sum += IntIter.next();
        }
        return sum;
    }

    @Override
    public IntStream filter(IntPredicate predicate) {
        return new AsIntStream(new FilterIterator(IntIter, predicate));
    }

    @Override
    public void forEach(IntConsumer action) {
        while(IntIter.hasNext()){
            action.accept(IntIter.next());
        }
    }

    @Override
    public IntStream map(IntUnaryOperator mapper) {
        return new AsIntStream(new MapIterator(IntIter, mapper));
    }

    @Override
    public IntStream flatMap(IntToIntStreamFunction func) {
        return new AsIntStream(new FlatMapIterator(IntIter, func));
    }

    @Override
    public int reduce(int identity, IntBinaryOperator op) {
        int i = identity;
        while(IntIter.hasNext()){
            i = op.apply(i, IntIter.next());
        }
        return i;    }

    @Override
    public int[] toArray() {
        ArrayList<Integer> ListIter = new ArrayList<>();
        while(IntIter.hasNext()){
            ListIter.add(IntIter.next());
        }
        int[] ArrayIter = new int[ListIter.size()];
        for (int i = 0; i <ListIter.size() ; i++) {
            ArrayIter[i] = ListIter.get(i);
        }
        return ArrayIter;


    }

}
