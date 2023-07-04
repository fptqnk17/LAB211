package com.hardingadonis.model.comparator;

import java.util.Comparator;
import com.hardingadonis.model.Student;

public class StudentComparatorByGPA implements Comparator<Student> {

    @Override
    public int compare(Student o1, Student o2) {
        return Float.compare(o1.getGPA(), o2.getGPA());
    }
}
