package com.journalrank.control;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import com.journalrank.control.filter.Predicate;
import com.journalrank.control.rank.Rank;

public class Collation<T> {
    
    private List<T> items = new ArrayList<>();
    
    private Collation(List<T> sourceItems){
        items = new ArrayList<T>(sourceItems);      
    }
    
    public static <T> Collation<T> from(List<T> sourceItems) {
        return new Collation<T>(sourceItems);
    }
    
    public Collation<T> sort(Comparator<T> sortComparator) {
        Collections.sort(items, sortComparator);
        return this;
    }

    public T get(int i) {
        return this.items.get(i);
    }
    
    public boolean contains(T element){       
        return items.contains(element);
    }

    public Collation<T> filter(Predicate<T> predicate) {        
        List<T> result = new ArrayList<T>();
        for (T element : (Collection<T>) items) {
          if (predicate.apply(element)) {
            result.add(element);
          }
        }

        this.items = result;  
        return this;
    }

    public Collation<T> rank(Rank<T> rankEngine) {
        rankEngine.doRank(items);       
        return this;
    }  

}
