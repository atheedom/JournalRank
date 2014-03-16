package com.journalrank.control.rank;

import java.util.List;

import com.journalrank.entity.Journal;

public class Numerical implements Rank<Journal> {
  
    @Override
    public void doRank(List<Journal> journals) {
        for(Journal journal : journals){    
           int index = journals.lastIndexOf(journal);
           if(index != 0 && journals.get(index-1).getScore() == journal.getScore()){
               journal.setRank(journals.get(index-1).getRank());
           } else {
               journal.setRank(++index);
           }
        }   
    }
       
}
