package com.company;

/**
 * Created by user on 11.12.2015.
 */
public class NoSuchKeyExeption extends Exception {
public NoSuchKeyExeption(){
    System.err.println("This directory is not exist!");
}
}
