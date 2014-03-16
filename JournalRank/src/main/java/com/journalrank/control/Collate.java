package com.journalrank.control;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import com.journalrank.control.filter.Predicate;
import com.journalrank.control.rank.Rank;


public class Collate<T> {
    
    List<T> collection = new ArrayList<>();

    public Collate<T> sort(Comparator<T> sortComparator) {
        Collections.sort(collection, sortComparator);
        return this;
    }

    public T get(int i) {
        return this.collection.get(i);
    }
    
    public boolean contains(T element){       
        return collection.contains(element);
    }

    public Collate<T> from(List<T> collection) {
        this.collection = collection;
        return this;
    }

    public Collate<T> filter(Predicate<T> predicate) {
        
        List<T> result = new ArrayList<T>();
        for (T element : (Collection<T>) collection) {
          if (predicate.apply(element)) {
            result.add(element);
          }
        }

        this.collection = result;  
        return this;
    }

    public Collate<T> rank(Rank<T> rankEngine) {

        rankEngine.doRank(collection);
        
        return this;
    }
    
    

}
