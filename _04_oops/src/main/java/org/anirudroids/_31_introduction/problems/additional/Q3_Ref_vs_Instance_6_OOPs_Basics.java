package org.anirudroids._31_introduction.problems.additional;

public class Q3_Ref_vs_Instance_6_OOPs_Basics {
    /**
     * Consider the following code
     *
     * Java
     * Python
     * JS
     * public class Student {
     *    int age;
     *    String name;
     *
     *    void display(){
     *        System.out.println("My name is " + this.name + ". I am "  + this.age + " years old");
     *    }
     *
     *    void sayHello(String name){
     *        System.out.println(this.name + " says hello to " + name);
     *    }
     * }
     *
     * public class Client {
     *    public static void main(String[] args) {
     *        Student s1 = new Student();
     *        s1.age = 10;
     *        s1.name = "A";
     *
     *        Student s2 = new Student();
     *        s2.age = 20;
     *        s2.name = "B";
     *
     *        swap(s1, s2);
     *
     *        s1.display();
     *    }
     *
     *    private static void swap(Student s1, Student s2) {
     *         Student temp = s1;
     *         s1 = s2;
     *         s2 = temp;
     *    }
     * }
     * class Student:
     *     def __init__(self, age, name):
     *         self.age = age
     *         self.name = name
     *
     *     def display(self):
     *         print(f"My name is {self.name}. I am {self.age} years old")
     *
     *     def say_hello(self, name):
     *         print(f"{self.name} says hello to {name}")
     *
     * def swap(s1, s2):
     *     temp = s1
     *     s1 = s2
     *     s2 = temp
     *
     * # Main Code
     * s1 = Student(10, "A")
     * s2 = Student(20, "B")
     *
     * swap(s1, s2)
     *
     * s1.display()
     * class Student {
     *     constructor(name = "", age = 0) {
     *         this.age = age;
     *         this.name = name;
     *     }
     *
     *     display() {
     *         console.log(`My name is ${this.name}. I am ${this.age} years old`);
     *     }
     *
     *     sayHello(name) {
     *         console.log(`${this.name} says hello to ${name}`);
     *     }
     * }
     *
     * function swap(s1, s2) {
     *     const temp = s1;
     *     s1 = s2;
     *     s2 = temp;
     * }
     *
     * const s1 = new Student("A", 10);
     * const s2 = new Student("B", 20);
     *
     * swap(s1, s2);
     *
     * s1.display();
     * What is the output of the final call to display function?
     *
     *
     * My name is A. I am 10 years old.
     * My name is B. I am 20 years old.
     * My name is A. I am 20 years old.
     * My name is B. I am 10 years old.
     */
}
