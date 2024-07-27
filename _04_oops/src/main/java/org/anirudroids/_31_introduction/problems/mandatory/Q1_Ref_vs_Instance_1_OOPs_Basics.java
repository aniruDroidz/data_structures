package org.anirudroids._31_introduction.problems.mandatory;

public class Q1_Ref_vs_Instance_1_OOPs_Basics {
    /**
     * Consider the following code
     *
     * Java
     * Python
     * JS
     * public class Student {
     *      int age;
     *      String name;
     *
     *      void display(){
     *              System.out.println("My name is " + this.name + ". I am "  + this.age + " years old");
     *      }
     *
     *      void sayHello(String name){
     *              System.out.println(this.name + " says hello to " + name);
     *      }
     * }
     *
     *
     * public class Client {
     *    public static void main(String[] args) {
     *        Student s1 = new Student();
     *        s1.age = 10;
     *        s1.name = "A";
     *        s1.display();
     *
     *        Student s2 = s1;
     *        s2.age = 20;
     *        s2.name = "B";
     *
     *        s2.display();
     *
     *        s1.display();
     *    }
     * }
     * class Student:
     *     def __init__(self):
     *         self.age = 0
     *         self.name = ""
     *
     *     def display(self):
     *         print("My name is", self.name + ". I am", self.age, "years old")
     *
     *     def say_hello(self, name):
     *         print(self.name, "says hello to", name)
     *
     * # Main Code
     * s1 = Student()
     * s1.age = 10
     * s1.name = "A"
     * s1.display()
     *
     * s2 = s1
     * s2.age = 20
     * s2.name = "B"
     *
     * s2.display()
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
     * const s1 = new Student("A", 10);
     * s1.display();
     *
     * const s2 = s1;
     * s2.age = 20;
     * s2.name = "B";
     *
     * s2.display();
     *
     * s1.display();
     * What is the output of the final call to display function i.e. s1.display()?
     *
     *
     * My name is A. I am 10 years old.
     * My name is B. I am 10 years old.
     * My name is A. I am 20 years old.
     * My name is B. I am 20 years old.
     */


}
