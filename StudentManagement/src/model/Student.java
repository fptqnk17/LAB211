package model;

public class Student {
    private String ID;
    private String name;
    private int old;
    private float GPA;

    public Student() {
    }

    public Student(String ID, String name, int old, float GPA) {
        this.ID = ID;
        this.name = name;
        this.old = old;
        this.GPA = GPA;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getOld() {
        return old;
    }

    public void setOld(int old) {
        this.old = old;
    }

    public float getGPA() {
        return GPA;
    }

    public void setGPA(float GPA) {
        this.GPA = GPA;
    }

    @Override
    public String toString() {
        return "%-15s%-25s%-8s%-5s".formatted(this.ID, this.name, this.old, this.GPA);
    }
}