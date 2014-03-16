package com.journalrank.control.sort;

public enum Direction {
    
    ASC(-1), DESC(1);
    
    private int direction;
    
    Direction(int direction){
        this.direction = direction;
    }
    
    public int coefficent(){
        return direction;
    }
    
}
