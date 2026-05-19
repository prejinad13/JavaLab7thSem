package unit1corejava.qn2serializeddeserialized;
import java.io.Serializable;


public class Student implements Serializable{
    private static final long serialVersionUID = 1L;

    private int id;
    private String name;
    private double marks;

    // Constructor
    public Student(int id, String name, double marks) {
        this.id = id;
        this.name = name;
        this.marks = marks;
    }

    // Method to display student details
    public void displayStudent() {
        System.out.println("Student ID: " + id);
        System.out.println("Student Name: " + name);
        System.out.println("Student Marks: " + marks);
    }
}
