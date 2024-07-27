package org.anirudroids._31_introduction.problems.mandatory;

public class Q3_Ref_vs_Instance_3_OOPs_Basics {
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
     *
     *        int tempAge = s1.age;
     *        s1.age = s2.age;
     *        s2.age = tempAge;
     *
     *        s2.display();
     *
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
     * # Main code
     * if __name__ == "__main__":
     *     s1 = Student()
     *     s1.age = 10
     *     s1.name = "A"
     *
     *     s2 = Student()
     *
     *     # Swapping ages
     *     temp_age = s1.age
     *     s1.age = s2.age
     *     s2.age = temp_age
     *
     *     s2.display()
     * class Student {
     *     constructor(name = null, age = 0) {
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
     * s1 = new Student("A", 10);
     * s2 = new Student();
     *
     * tempAge = s1.age;
     * s1.age = s2.age;
     * s2.age = tempAge;
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
