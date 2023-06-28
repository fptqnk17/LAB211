package model.comparator;

import java.util.Comparator;
import model.Student;

public class StudentComparatorByID implements Comparator<Student> {

    @Override
    public int compare(Student o1, Student o2) {
        return o1.getID().compareToIgnoreCase(o2.getID());
    }
}
