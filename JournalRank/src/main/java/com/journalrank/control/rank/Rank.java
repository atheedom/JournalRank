package com.journalrank.control.rank;

import java.util.List;

public interface Rank<T> {

    public void doRank(List<T> collection);
    
}
