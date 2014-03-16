package com.journalrank.control.filter;

import com.journalrank.entity.Journal;


public class OutReview implements Predicate<Journal>{

    @Override
    public boolean apply(Journal j) {
        return !j.isReview();
    }

}
