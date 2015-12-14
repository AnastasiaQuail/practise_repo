package com.company;

import java.util.function.Function;

public class Main {

    public static void main(String[] args) {

        MyFileTree<String> tree = new MyFileTree<>();


        try {
            tree.addEntity("c:","file");
        } catch (NoSuchKeyExeption noSuchKeyExeption) {
            noSuchKeyExeption.printStackTrace();
        }
        try {
            tree.addEntity("c:/folder","file2");
        } catch (NoSuchKeyExeption noSuchKeyExeption) {
            noSuchKeyExeption.printStackTrace();
        }

        try {
            tree.addEntity("c:/b","g");
        } catch (NoSuchKeyExeption noSuchKeyExeption) {
            noSuchKeyExeption.printStackTrace();
        }
        try {
            tree.addEntity("b:/folder/a","l");
        } catch (NoSuchKeyExeption noSuchKeyExeption) {
            noSuchKeyExeption.printStackTrace();
        }
        try {
            tree.deleteEntity("c:/root");
        } catch (NoSuchKeyExeption noSuchKeyExeption) {
            noSuchKeyExeption.printStackTrace();
        }
        try {
            tree.deleteEntity("c:/folder");
        } catch (NoSuchKeyExeption noSuchKeyExeption) {
            noSuchKeyExeption.printStackTrace();
        }
        Function<String,String> converter = (from) -> from.concat("++++");
        try {
            tree.IteratorFunction(converter);
        } catch (EmptyTreeExeption emptyTreeExeption) {
            emptyTreeExeption.printStackTrace();
        }


   }
}
