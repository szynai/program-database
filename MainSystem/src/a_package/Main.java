/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package a_package;

/**
 *
 * @author redelyn
 */
import java.util.List;
import java.util.Scanner;

public class Main {
    
    public static void main(String[] args) {
        Repository repo = new Repository();
        Scanner sc = new Scanner(System.in);

        System.out.print("How many students will you add? ");
        int count = sc.nextInt();
        sc.nextLine();

        for (int i = 0; i < count; i++) {
            System.out.println("\n--- Student " + (i + 1) + " ---");

            System.out.print("ID: ");
            int id = sc.nextInt();
            sc.nextLine();

            System.out.print("First Name: ");
            String fname = sc.nextLine();

            System.out.print("Last Name: ");
            String lname = sc.nextLine();

            System.out.print("Age: ");
            int age = sc.nextInt();
            sc.nextLine();

            System.out.print("Course: ");
            String course = sc.nextLine();

            Student s = new Student.StudentBuilder()
                    .ID(id)
                    .FIRSTNAME(fname)
                    .LASTNAME(lname)
                    .AGE(age)
                    .COURSE(course)
                    .buildstudentBuilder();

            repo.save(s);
        }

        System.out.println("\n=== MASTER LIST ===");
        List<Student> list = repo.findAll();
        for (Student s : list) {
            System.out.println(s.getID() + " | " +
                    s.getFIRSTNAME() + " " + s.getLASTNAME() +
                    " | Age: " + s.getAGE() +
                    " | Course: " + s.getCOURSE());
        }

        sc.close();
    }
}

