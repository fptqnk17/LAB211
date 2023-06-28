package model;

import java.util.*;
import model.comparator.StudentComparatorByID;
import utils.Validation;

public class StudentList {

    private List<Student> list;

    public StudentList() {
        this.list = new ArrayList<>();
    }

    public void listAllStudents() {
        this.listAllStudents(this.list, new StudentComparatorByID());
    }

    public void listAllStudents(List<Student> list) {
        this.listAllStudents(list, new StudentComparatorByID());
    }

    public void listAllStudents(Comparator<Student> comparator) {
        this.listAllStudents(this.list, comparator);
    }

    public void listAllStudents(List<Student> list, Comparator<Student> comparator) {
        int total = list.size();

        if (total <= 0) {
            System.err.println("Sorry. Nothing to print.");

            return;
        }

        list.sort(comparator);

        System.out.println("List all students");
        System.out.println("--------------------------------");
        System.out.printf("%-15s%-25s%-8s%-5s\n", "ID", "Name", "Old", "GPA");

        for (var student : list) {
            System.out.println(student);
        }

        System.out.println("--------------------------------");
        System.out.println("Total: " + total + " students.");
    }

    public void addNewStudent() {
        System.out.println("Add new student");
        System.out.println("--------------------------------");

        String newID = null;
        String newName = null;
        int newOld = 0;
        float newGPA = 0.f;

        while (true) {
            newID = Validation.getString("Enter ID (st. ID QE000000): ", "[qQ][eE][\\d]{6}");

            if (!this.isStudentIDDuplicated(newID)) {
                break;
            }
        }

        newName = Validation.getString("Enter name: ");
        newOld = Validation.getInt("Enter old: ", 6, Integer.MAX_VALUE);
        newGPA = Validation.getFloat("Enter GPA: ", 0.f, 10.f);

        this.list.add(new Student(newID, newName, newOld, newGPA));
    }

    private boolean isStudentIDDuplicated(String ID) {
        ID = ID.trim().toUpperCase();

        for (Student student : this.list) {
            if (student.getID().equalsIgnoreCase(ID)) {
                return true;
            }
        }

        return false;
    }

    public List<Student> search(Comparator<Student> comparator, Student student) {
        List<Student> newList = new ArrayList<>();

        for (Student s : this.list) {
            if (comparator.compare(s, student) == 0) {
                newList.add(s);
            }
        }

        return newList;
    }
}
