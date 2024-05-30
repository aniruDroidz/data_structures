package org.anirudroids;

import java.util.ArrayList;
import java.util.Stack;

public class Solution {
    public static void main(String[] args) {
        ArrayList<Integer> arrayList = new ArrayList<>();
        arrayList.add(-1);
        nextGreater(arrayList);
    }

    public static ArrayList<Integer> nextGreater(ArrayList<Integer> A) {
        ArrayList<Integer> result = new ArrayList<>();
        for(int a: A) {
            result.add(-1);
        }

        Stack<Integer> stack = new Stack<>();
        for(int i = A.size()-1; i >= 1; i--) {
            if(!stack.isEmpty() && stack.peek() < A.get(i)) {
                stack.pop();
                if(!stack.isEmpty()) {
                    stack.push(stack.peek());
                } else {
                    stack.push(-1);
                }
            }

            stack.push(A.get(i));
        }

        while(!stack.isEmpty()) {
            result.add(stack.pop());
        }

        return result;
    }
}
