package com.company;

/**
 * Created by user on 12.12.2015.
 */
public class EmptyTreeExeption extends Throwable {
    public EmptyTreeExeption(){
        System.err.println("The tree is empty!");
    }
}
