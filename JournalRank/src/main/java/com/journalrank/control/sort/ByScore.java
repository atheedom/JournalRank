package com.journalrank.control.sort;

import java.util.Comparator;

import com.journalrank.entity.Journal;

public class ByScore implements Comparator<Journal> {
    
    Direction direction;
    
    public ByScore(){
        this.direction = Direction.ASC;
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
