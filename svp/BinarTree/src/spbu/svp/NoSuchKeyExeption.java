package spbu.svp;

/**
 * Created by user on 01.11.2015.
 */
public class NoSuchKeyExeption extends Exception {
    public NoSuchKeyExeption(){

    }
    public String getMessage(){
        return "Error!There is no such key!";
    }
}
