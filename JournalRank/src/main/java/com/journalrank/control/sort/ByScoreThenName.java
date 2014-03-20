package com.journalrank.control.sort;

import java.util.Comparator;

import com.journalrank.entity.Journal;
import static com.journalrank.control.sort.Direction.ASCENDING;

public class ByScoreThenName implements Comparator<Journal> {
    
    private Direction direction;
    
    public ByScoreThenName(){
        this.direction = ASCENDING;
    }
    
    public ByScoreThenName(Direction direction){
        this.direction = direction;
    }

    @Override
    public int compare(Journal j1, Journal j2) {
        
        int comparatorValue = 0;

        if (j1.getScore() == j2.getScore()) {
            comparatorValue = j2.getName().compareToIgnoreCase(j1.getName());
        } else {
            if ((j1.getScore() < j2.getScore())) {
                comparatorValue = -1;
            } else if (j1.getScore() > j2.getScore()) {
                comparatorValue = 1;
            }
        }

        return direction.coefficent() * comparatorValue;
    }

}
