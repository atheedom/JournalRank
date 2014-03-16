package com.journalrank.control;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.journalrank.control.filter.OutReview;
import com.journalrank.control.rank.Numerical;
import com.journalrank.control.sort.ByScore;
import com.journalrank.control.sort.ByScoreThenName;
import com.journalrank.control.sort.Direction;
import com.journalrank.entity.Journal;

public class TestCollateJournals {

    @Test
    public void sort_by_journal_score(){
        
        List<Journal> journals = new ArrayList<>();

        Journal journalB = new Journal();
        journalB.setName("Journal B");
        journalB.setScore(2.4f);
        journalB.setReview(false);
        journals.add(journalB);
        
        Journal journalA = new Journal();
        journalA.setName("Journal A");
        journalA.setScore(5.6f);
        journalA.setReview(false);
        journals.add(journalA);
        
        Journal journalC = new Journal();
        journalC.setName("Journal C");
        journalC.setScore(3.1f);
        journalC.setReview(false);        
        journals.add(journalC);
        

        Collate<Journal> collateJournals = new Collate<>();
        Collate<Journal> sortedJournals = collateJournals.from(journals).sort(new ByScore(Direction.ASC)).rank(new Numerical());
        
        assertEquals(journalA, sortedJournals.get(0));
        assertEquals(journalC, sortedJournals.get(1));
        assertEquals(journalB, sortedJournals.get(2));
        
    }
    
    
    @Test
    public void sort_by_journal_score_and_name_then_rank(){
        
        List<Journal> journals = new ArrayList<>();
        
        Journal journalC = new Journal();
        journalC.setName("Journal C");
        journalC.setScore(6.2f);
        journalC.setReview(false);        
        journals.add(journalC);
        
        Journal journalA = new Journal();
        journalA.setName("Journal A");
        journalA.setScore(2.2f);
        journalA.setReview(false);
        journals.add(journalA);
        
        Journal journalB = new Journal();
        journalB.setName("Journal B");
        journalB.setScore(6.2f);
        journalB.setReview(false);
        journals.add(journalB);
        
     
        Collate<Journal> collateJournals = new Collate<>();
        Collate<Journal> collatedJournals = collateJournals.from(journals).sort(new ByScoreThenName(Direction.ASC)).rank(new Numerical());

        assertEquals(journalB, collatedJournals.get(0));
        assertEquals(journalC, collatedJournals.get(1));
        assertEquals(journalA, collatedJournals.get(2));
        
        assertEquals(journalB.getRank(), 1);
        assertEquals(journalC.getRank(), 1);
        assertEquals(journalA.getRank(), 3);
        
    }
    
    
    @Test
    public void filter_out_all_review_journals_and_sort_by_name(){

        List<Journal> journals = new ArrayList<>();
        
        Journal journalA = new Journal();
        journalA.setName("Journal A");
        journalA.setScore(5.6f);
        journalA.setReview(true);
        journals.add(journalA);
        
        Journal journalB = new Journal();
        journalB.setName("Journal B");
        journalB.setScore(2.4f);
        journalB.setReview(false);
        journals.add(journalB);
        
        Journal journalC = new Journal();
        journalC.setName("Journal C");
        journalC.setScore(3.1f);
        journalC.setReview(false);        
        journals.add(journalC);
              
        Collate<Journal> collateJournals = new Collate<>();
        Collate<Journal> collatedJournals = collateJournals.from(journals).filter(new OutReview()).sort(new ByScore(Direction.ASC)).rank(new Numerical());
               
        assertEquals(journalC, collatedJournals.get(0));
        assertEquals(journalB, collatedJournals.get(1));
        assertFalse(collatedJournals.contains(journalA));
        
    }

    
    // Additional tests
    
    @Test
    public void compare_two_journals_lexicographically_and_numerically(){
        
        Journal journalA = new Journal();
        journalA.setName("Journal A");
        journalA.setScore(5.6f);
        journalA.setReview(false);
        
        Journal journalB = new Journal();
        journalB.setName("Journal B");
        journalB.setScore(6.2f);
        journalB.setReview(false);     
        
        Journal journalC = new Journal();
        journalC.setName("Journal C");
        journalC.setScore(6.2f);
        journalC.setReview(false); 
               
        ByScoreThenName sortByScoreThenName = new ByScoreThenName();
        
        assertEquals(sortByScoreThenName.compare(journalA, journalA), 0);        
        assertEquals(sortByScoreThenName.compare(journalC, journalB), 1);
        assertEquals(sortByScoreThenName.compare(journalB, journalC), -1);
               
    }
  
    
    @Test
    public void order_two_journals_ascending_then_descending() {

        Journal journalE = new Journal();
        journalE.setName("Journal E");
        journalE.setScore(0.2f);
        journalE.setReview(false);
        
        Journal journalC = new Journal();
        journalC.setName("Journal C");
        journalC.setScore(1.2f);
        journalC.setReview(false);

        ByScore sortByScoreAscending = new ByScore(Direction.ASC);
        assertEquals(sortByScoreAscending.compare(journalE, journalC), 1);

        ByScore sortByScoreDescending = new ByScore(Direction.DESC);
        assertEquals(sortByScoreDescending.compare(journalE, journalC), -1);

    }  
    
    
}
