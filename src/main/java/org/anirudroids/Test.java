package org.anirudroids;

import java.util.Stack;

public class Test {
    int age = 1;



    public static void main(String[] args) {
        Stack<Integer> s = new Stack<>();
        s.push(1);
        s.push(2);
        s.push(3);

        s.remove(1);

        System.out.println(s);
    }
}
