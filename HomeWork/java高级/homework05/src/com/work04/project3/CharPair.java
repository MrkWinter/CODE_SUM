package com.work04.project3;

public class CharPair {
	
	
	char cm;
	int count;
	
	CharPair(char c,int co){
		this.cm=c;
		this.count=co;
	}
    CharPair(char c)  {
        this.cm=c;
        this.count=1;
    }
    public int getCount() {
    	return this.count;
    }
    
    public char getChar() {
    	return  this.cm;
    }
    public void increaseOne() {
    	this.count++;
    }
    
    public String toString()
    {
    	return String.valueOf(cm)+":"+String.valueOf(count);
    }
    
}
