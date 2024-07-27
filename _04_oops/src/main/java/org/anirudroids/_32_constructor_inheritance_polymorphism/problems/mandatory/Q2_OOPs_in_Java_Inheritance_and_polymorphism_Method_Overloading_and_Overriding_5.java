package org.anirudroids._32_constructor_inheritance_polymorphism.problems.mandatory;

public class Q2_OOPs_in_Java_Inheritance_and_polymorphism_Method_Overloading_and_Overriding_5 {
    /**
     * Consider the following Code which consists of P Class and C Class
     *
     * C++
     * Java
     * Python
     * JS
     * C#
     * #include <iostream>
     * using namespace std;
     *
     * class P {
     * protected:
     *     int d1 = 10;
     *     int d = 100;
     *
     *     void fun1() {
     *         cout << "P's fun1" << endl;
     *     }
     *
     *     void fun() {
     *         cout << "P's fun" << endl;
     *     }
     *
     *     static void sfun() {
     *         cout << "P's sfun" << endl;
     *     }
     *
     * public:
     *     void display() {
     *         cout << d1 << endl;
     *         cout << d << endl;
     *         fun1();
     *         fun();
     *         sfun();
     *     }
     * };
     *
     * class C : public P {
     * protected:
     *     int d2 = 20;
     *     int d = 200;
     *
     *     void fun2() {
     *         cout << "C's fun2" << endl;
     *     }
     *
     *     void fun() {
     *         cout << "C's fun" << endl;
     *     }
     *
     *     static void sfun() {
     *         cout << "C's sfun" << endl;
     *     }
     * };
     *
     * int main() {
     *     P obj;
     *     obj.display();
     *     return 0;
     * }
     * class P {
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
     * class C extends P{
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
     *         P obj = new P();
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
     *     @staticmethod
     *     def sfun():
     *         print("P's sfun")
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
     *     @staticmethod
     *     def sfun():
     *         print("C's sfun")
     *
     * if __name__ == "__main__":
     *     obj = P()
     *     print(obj.d1)
     *     print(obj.d)
     *     obj.fun1()
     *     obj.fun()
     *     P.sfun()
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
     * const obj = new P();
     * console.log(obj.d1);
     * console.log(obj.d);
     * obj.fun1();
     * obj.fun();
     * P.sfun();
     * using System;
     *
     * public class P {
     *     protected int d1 = 10;
     *     protected int d = 100;
     *
     *     protected void fun1() {
     *         Console.WriteLine("P's fun1");
     *     }
     *
     *     protected void fun() {
     *         Console.WriteLine("P's fun");
     *     }
     *
     *     protected static void sfun() {
     *         Console.WriteLine("P's sfun");
     *     }
     *
     *     public void Display() {
     *         Console.WriteLine(d1);
     *         Console.WriteLine(d);
     *         fun1();
     *         fun();
     *         sfun();
     *     }
     * }
     *
     * public class C : P {
     *     protected int d2 = 20;
     *     protected new int d = 200;
     *
     *     protected void fun2() {
     *         Console.WriteLine("C's fun2");
     *     }
     *
     *     protected new void fun() {
     *         Console.WriteLine("C's fun");
     *     }
     *
     *     protected new static void sfun() {
     *         Console.WriteLine("C's sfun");
     *     }
     * }
     *
     * public class Client {
     *     public static void Main(string[] args) {
     *         P obj = new P();
     *         obj.Display();
     *     }
     * }
     * What is the output?
     *
     * 10 100 P's fun1 P's fun P's sfun
     * 10 100 P's fun1 P's fun P's sfunsss
     * 100 100 P's fun1 P's fun P's sfun
     * 100 100 P's fun P's fun P's sfun
     */
}
