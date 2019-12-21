package ua.edu.ucu.iterators;

import java.util.ArrayList;
import java.util.Iterator;

public class StreamIterator implements Iterator<Integer>{
    private ArrayList<Integer> IntArray = new ArrayList<>();
    private int i = 0;

    public StreamIterator(int... values) {
        for (Integer v:values){
            this.IntArray.add(v);
        }

    }
    public StreamIterator() {
        this.IntArray = new ArrayList<>();
    }
    @Override
    public boolean hasNext(){
        return i < IntArray.size();
    }
    @Override
    public Integer next() {
        return IntArray.get(i++);
    }


}