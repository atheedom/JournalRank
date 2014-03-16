package com.journalrank.entity;

import java.io.Serializable;

public class Journal implements Serializable{

    private static final long serialVersionUID = 8964756258469682390L;
       
    private String name;
    private float score;
    private boolean review;
    private int rank;
    
    
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public float getScore() {
        return score;
    }
    public void setScore(float score) {
        this.score = score;
    }
    public boolean isReview() {
        return review;
    }
    public void setReview(boolean review) {
        this.review = review;
    }
    public int getRank() {
        return rank;
    }
    public void setRank(int rank) {
        this.rank = rank;
    }
    

    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((name == null) ? 0 : name.hashCode());
        result = prime * result + (review ? 1231 : 1237);
        result = (int) (prime * result + score);
        return result;
    }
    
    
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Journal other = (Journal) obj;
        if (name == null) {
            if (other.name != null)
                return false;
        } else if (!name.equals(other.name))
            return false;
        if (review != other.review)
            return false;
        if (score != other.score)
            return false;
        return true;
    }
    
    @Override
    public String toString() {
        return "Journal [name=" + name + ", score=" + score + ", review=" + review + ", rank=" + rank + "]";
    }

    
}
