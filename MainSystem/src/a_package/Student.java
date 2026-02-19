/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package a_package;

/**
 *
 * @author redelyn
 */
public class Student {
    private final int ID;
    private final String FIRSTNAME;
    private final String LASTNAME;
    private final int AGE;
    private final String COURSE;

    private Student(StudentBuilder builder) {
        this.ID = builder.ID;
        this.FIRSTNAME = builder.FIRSTNAME;
        this.LASTNAME = builder.LASTNAME;
        this.AGE = builder.AGE;
        this.COURSE = builder.COURSE;
    }

    public int getID() { return ID; }
    public String getFIRSTNAME() { return FIRSTNAME; }
    public String getLASTNAME() { return LASTNAME; }
    public int getAGE() { return AGE; }
    public String getCOURSE() { return COURSE; }

    
    public static class StudentBuilder {

        private int ID;
        private String FIRSTNAME;
        private String LASTNAME;
        private int AGE;
        private String COURSE;

        public StudentBuilder ID(int id) {
            this.ID = id;
            return this;
        }

        public StudentBuilder FIRSTNAME(String firstName) {
            this.FIRSTNAME = firstName;
            return this;
        }

        public StudentBuilder LASTNAME(String lastName) {
            this.LASTNAME = lastName;
            return this;
        }

        public StudentBuilder AGE(int age) {
            this.AGE = age;
            return this;
        }

        public StudentBuilder COURSE(String course) {
            this.COURSE = course;
            return this;
        }

        
          public Student buildstudentBuilder() {
            return new Student(this);
        }
    }
}
