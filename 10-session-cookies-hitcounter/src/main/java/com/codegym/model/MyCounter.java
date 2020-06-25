package com.codegym.model;

public class MyCounter {
    private int count;

    public int increment(){
        return count ++;
    }

    public MyCounter(){}

    public MyCounter(int count) {
        this.count = count;
    }

    public int getCount(){
        return count;
    }

    public void setCount(){
        this.count = count;
    }

}
