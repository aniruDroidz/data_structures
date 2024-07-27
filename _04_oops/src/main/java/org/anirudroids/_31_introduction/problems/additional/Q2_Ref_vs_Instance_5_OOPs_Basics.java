package org.anirudroids._31_introduction.problems.additional;

public class Q2_Ref_vs_Instance_5_OOPs_Basics {
    /**
     * Consider the following class Student
     *
     * C++
     * Java
     * Python
     * JS
     * C#
     * #include <iostream>
     * using namespace std;
     *
     * class Student {
     * public:
     *     int age;
     *     string name;
     *
     *     void display() {
     *         cout << "My name is " << this->name << ". I am " << this->age << " years old" << endl;
     *     }
     *
     *     void sayHello(string name) {
     *         cout << this->name << " says hello to " << name << endl;
     *     }
     * };
     *
     * void swap(Student& s1, Student& s2) {
     *     int tage = s1.age;
     *     s1.age = s2.age;
     *     s2.age = tage;
     *
     *     string tname = s1.name;
     *     s1.name = s2.name;
     *     s2.name = tname;
     * }
     *
     * int main() {
     *     Student s1;
     *     s1.age = 10;
     *     s1.name = "A";
     *
     *     Student s2;
     *     s2.age = 20;
     *     s2.name = "B";
     *
     *     swap(s1, s2);
     *
     *     s1.display();
     *
     *     return 0;
     * }
     * class Student {
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
     *        int tage = s1.age;
     *        s1.age = s2.age;
     *        s2.age = tage;
     *
     *        String tname = s1.name;
     *        s1.name = s2.name;
     *        s2.name = tname;
     *    }
     * }
     * class Student:
     *     def __init__(self):
     *         self.age = 0
     *         self.name = ""
     *
     *     def display(self):
     *         print("My name is", self.name + ". I am", str(self.age), "years old")
     *
     *     def sayHello(self, name):
     *         print(self.name, "says hello to", name)
     *
     * def swap(s1, s2):
     *     tage = s1.age
     *     s1.age = s2.age
     *     s2.age = tage
     *
     *     tname = s1.name
     *     s1.name = s2.name
     *     s2.name = tname
     *
     * if __name__ == "__main__":
     *     s1 = Student()
     *     s1.age = 10
     *     s1.name = "A"
     *
     *     s2 = Student()
     *     s2.age = 20
     *     s2.name = "B"
     *
     *     swap(s1, s2)
     *
     *     s1.display()
     * class Student {
     *     constructor() {
     *         this.age = 0;
     *         this.name = "";
     *     }
     *
     *     display() {
     *         console.log("My name is", this.name + ". I am", this.age, "years old");
     *     }
     *
     *     sayHello(name) {
     *         console.log(this.name, "says hello to", name);
     *     }
     * }
     *
     * function swap(s1, s2) {
     *     let tage = s1.age;
     *     s1.age = s2.age;
     *     s2.age = tage;
     *
     *     let tname = s1.name;
     *     s1.name = s2.name;
     *     s2.name = tname;
     * }
     *
     * const s1 = new Student();
     * s1.age = 10;
     * s1.name = "A";
     *
     * const s2 = new Student();
     * s2.age = 20;
     * s2.name = "B";
     *
     * swap(s1, s2);
     *
     * s1.display();
     * using System;
     *
     * public class Student {
     *     public int age;
     *     public string name;
     *
     *     public void display() {
     *         Console.WriteLine("My name is " + this.name + ". I am " + this.age + " years old");
     *     }
     *
     *     public void sayHello(string name) {
     *         Console.WriteLine(this.name + " says hello to " + name);
     *     }
     * }
     *
     * public class Client {
     *     public static void Main(string[] args) {
     *         Student s1 = new Student();
     *         s1.age = 10;
     *         s1.name = "A";
     *
     *         Student s2 = new Student();
     *         s2.age = 20;
     *         s2.name = "B";
     *
     *         swap(s1, s2);
     *
     *         s1.display();
     *     }
     *
     *     private static void swap(Student s1, Student s2) {
     *         int tage = s1.age;
     *         s1.age = s2.age;
     *         s2.age = tage;
     *
     *         string tname = s1.name;
     *         s1.name = s2.name;
     *         s2.name = tname;
     *     }
     * }
     * What is the output of the final call to display function?
     *
     *
     * My name is A. I am 10 years old.
     * My name is B. I am 20 years old.
     * My name is A. I am 20 years old.
     * My name is B. I am 10 years old.
     */
}
