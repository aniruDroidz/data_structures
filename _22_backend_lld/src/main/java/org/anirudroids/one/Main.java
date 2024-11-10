package org.anirudroids.one;

import java.util.stream.Stream;

public class Main {
    A a = new A();

    public static void main(String[] args) {
        System.out.println("Hello world!");

        new Main().register(new B());

        A b = new B();

        Stream<Integer> stream;
        stream.find
    }

    public void register(A a) {

    }

    public void register(B b) {

    }
}

class A {
    private void a() {}
}

class B extends A {

    public void a() {}
}

class C extends B {}

@FunctionalInterface
interface I {
    public void a();
}

interface I1 extends I {
    public void b();
}