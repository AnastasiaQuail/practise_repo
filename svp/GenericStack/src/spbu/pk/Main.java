package spbu.pk;

import java.io.*;

public class Main {

    public static void main(String[] args) {
try {
    PrintWriter pw = new PrintWriter(new OutputStreamWriter(System.out, "Cp866"), true);
    LimitedStacks nstack;
    nstack = new LimitedStacks<Integer>();
    try {
        nstack.pop();
    } catch (ArrayIndexOutOfBoundsException e) {
    }
    nstack.push(1);
    nstack.push(2);
    nstack.push(3);
    nstack.push(4);
    nstack.push(5);
    try {
        nstack.push(6);
    } catch (ArrayIndexOutOfBoundsException e) {
        System.err.println("Error! The allowable stack size: " + nstack.getsize());
    }
    pw.println("The last element and remove:" + nstack.pop());
    pw.println("The last element witout removing: " + nstack.peek());
    pw.println("stack :");
    while (!nstack.empty()) {
        pw.println(nstack.pop());

    }
    InfinityStacks stack = new InfinityStacks<String>();
    try {
        stack.pop();
    } catch (ArrayIndexOutOfBoundsException e) {
        pw.println("Error!Empty stack!");
    }
    stack.push("!");
    stack.push("text");
    stack.push("some ");
    stack.pop();
    while (!stack.empty()) {
        pw.println(stack.pop());

    }
}
catch(Exception e) {
    System.out.println(e);
}


    }
    }

