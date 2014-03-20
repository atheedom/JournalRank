package com.journalrank.control.sort;

import java.util.Comparator;
import com.journalrank.entity.Journal;
import static com.journalrank.control.sort.Direction.ASCENDING;

public class ByScore implements Comparator<Journal> {
    
    private Direction direction;
    
    public ByScore(){
        this.direction = ASCENDING;
    }
    
    public ByScore(Direction direction){
        this.direction = direction;
    }
    
    @Override
    public int compare(Journal j1, Journal j2) {
        
        int comparatorValue = 0;

        if (j1.getScore() < j2.getScore()) {
            comparatorValue = -1;
        } else if (j1.getScore() == j2.getScore()) {
            comparatorValue = 0;
        } else if (j1.getScore() > j2.getScore()) {
            comparatorValue = 1;
        }

        return direction.coefficent() * comparatorValue;
    }

}
