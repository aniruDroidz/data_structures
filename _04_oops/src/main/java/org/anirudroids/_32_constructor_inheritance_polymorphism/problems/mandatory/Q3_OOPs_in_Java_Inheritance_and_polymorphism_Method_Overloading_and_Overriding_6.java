package org.anirudroids._32_constructor_inheritance_polymorphism.problems.mandatory;

public class Q3_OOPs_in_Java_Inheritance_and_polymorphism_Method_Overloading_and_Overriding_6 {
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
     *         P obj = new C();
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
     *     def sfun(self):
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
     *     def sfun(self):
     *         print("C's sfun")
     *
     *
     * if __name__ == "__main__":
     *     obj = C()
     *     print(obj.d1)
     *     print(P().d)
     *     obj.fun1()
     *     obj.fun()
     *     P.sfun(obj)
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
     *     sfun() {
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
     *     sfun() {
     *         console.log("C's sfun");
     *     }
     * }
     *
     * obj = new C();
     * console.log(obj.d1);
     * console.log((new P()).d);
     * obj.fun1();
     * obj.fun();
     * (new P()).sfun.call(obj);
     * What is the output?
     *
     * 10 100 P's fun1 C's fun P's sfun
     * 100 100 P's fun 1C's fun P's sfun
     * 10 10 P's fun 1C's fun P's sfun
     * 10 100 P's fun 1C's fun P's sfun1
     */
}
