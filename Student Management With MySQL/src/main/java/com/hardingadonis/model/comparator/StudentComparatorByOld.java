package com.hardingadonis.model.comparator;

import java.util.Comparator;
import com.hardingadonis.model.Student;

public class StudentComparatorByOld implements Comparator<Student> {

    @Override
    public int compare(Student o1, Student o2) {
        return o1.getOld() - o2.getOld();
    }
}
