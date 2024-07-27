package org.anirudroids._32_constructor_inheritance_polymorphism.problems.mandatory;

public class Q5_OOPs_in_Java_Inheritance_and_polymorphism_Method_Overloading_and_Overriding_8 {
    /**
     * Consider the following Code
     *
     * Java
     * Python
     * JS
     * public class P {
     *    protected int d1 = 10;
     *    protected int d = 100;
     *
     *    protected void fun1(){
     *        System.out.println("P's fun1");
     *    }
     *
     *    protected void fun(){
     *        System.out.println("P's fun");
     *    }
     *
     *    static protected void sfun(){
     *        System.out.println("P's sfun");
     *    }
     * }
     *
     * public class C extends P{
     *    protected int d2 = 20;
     *    protected int d = 200;
     *
     *    protected void fun2(){
     *        System.out.println("C's fun2");
     *    }
     *
     *    protected void fun(){
     *        System.out.println("C's fun");
     *    }
     *
     *    static protected void sfun(){
     *        System.out.println("C's sfun");
     *    }
     * }
     *
     * public class Client {
     *     public static void main(String[] args) {
     *         C obj = new C();
     *         System.out.println(obj.d1);
     *         System.out.println(obj.d);
     *         obj.fun1();
     *         obj.fun();
     *         obj.sfun();
     *     }
     * }
     * class P:
     *     def __init__(self):
     *         self.d1 = 10
     *         self.d = 100
     *
     *     def fun1(self):
     *         print("P's fun1")
     *
     *     def fun(self):
     *         print("P's fun")
     *
     *     def sfun():
     *         print("P's sfun")
     *
     *
     * class C(P):
     *     def __init__(self):
     *         super().__init__()
     *         self.d2 = 20
     *         self.d = 200
     *
     *     def fun2(self):
     *         print("C's fun2")
     *
     *     def fun(self):
     *         print("C's fun")
     *
     *     def sfun():
     *         print("C's sfun")
     *
     *
     * # Main code
     * obj = C()
     * print(obj.d1)
     * print(obj.d)
     * obj.fun1()
     * obj.fun()
     * C.sfun()
     * class P {
     *     constructor() {
     *         this.d1 = 10;
     *         this.d = 100;
     *     }
     *
     *     fun1() {
     *         console.log("P's fun1");
     *     }
     *
     *     fun() {
     *         console.log("P's fun");
     *     }
     *
     *     static sfun() {
     *         console.log("P's sfun");
     *     }
     * }
     *
     * class C extends P {
     *     constructor() {
     *         super();
     *         this.d2 = 20;
     *         this.d = 200;
     *     }
     *
     *     fun2() {
     *         console.log("C's fun2");
     *     }
     *
     *     fun() {
     *         console.log("C's fun");
     *     }
     *
     *     static sfun() {
     *         console.log("C's sfun");
     *     }
     * }
     *
     * const obj = new C();
     * console.log(obj.d1);
     * console.log(obj.d);
     * obj.fun1();
     * obj.fun();
     * C.sfun();
     * What is the output?
     *
     * 10 200 P's fun 1C's fun C's sfun
     * 10 100 P's fun 1C's fun C's sfun
     * 100 200 P's fun 1C's fun C's sfun
     * 200 100 P's fun 1C's fun C's sfun
     */
}
