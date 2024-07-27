package org.anirudroids._31_introduction.problems.additional;

public class Q1_Ref_vs_Instance_4_OOPs_Basics {
    /**
     * Consider the following code
     *
     * Java
     * Python
     * JS
     * class Student {
     *    int age;
     *    String name;
     *
     *    void display(){
     *        System.out.println("My name is " + this.name + ". I am "  + this.age + " years old");
     *    }
     * }
     *
     * public class Client {
     *    public static void main(String[] args) {
     *        Student s1 = new Student();
     *        s1.age = 10;
     *
     *        Student s2 = s1;
     *
     *        s2.display();
     *    }
     * }
     * class Student:
     *     def __init__(self):
     *         self.age = 0
     *         self.name = none
     *
     *     def display(self):
     *         print("My name is", self.name + ". I am", self.age, "years old")
     *
     *
     * # Main code
     * s1 = Student()
     * s1.age = 10
     *
     * s2 = s1
     *
     * s2.display()
     * class Student {
     *     constructor() {
     *         this.age = 0;
     *         this.name = null;
     *     }
     *
     *     display() {
     *         console.log(`My name is ${this.name}. I am ${this.age} years old`);
     *     }
     * }
     *
     * const s1 = new Student();
     * s1.age = 10;
     *
     * const s2 = s1;
     *
     * s2.display();
     * What is the output of the final call to display function?
     *
     * My name is A. I am 10 years old.
     * My name is null. I am 0 years old.
     * My name is null. I am 10 years old.
     * My name is A. I am 0 years old.
     */


}
