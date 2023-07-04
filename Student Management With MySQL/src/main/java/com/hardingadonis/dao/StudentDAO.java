package com.hardingadonis.dao;

import com.hardingadonis.model.*;
import com.hardingadonis.utils.JDBC;
import java.sql.*;
import java.util.*;

public class StudentDAO {

    private static final String INSERT_QUERY = "INSERT INTO student (ID, name, old, GPA) VALUES (?, ?, ?, ?);";
    private static final String UPDATE_QUERY = "UPDATE student SET name = ?, old = ?, GPA = ? WHERE ID = ?;";
    private static final String DELETE_QUERY = "DELETE FROM student WHERE ID = ?;";
    private static final String SELECT_ALL_QUERY = "SELECT * FROM student";

    public static List<Student> list;

    public static void insert(Student student) {

        Connection connection = JDBC.getConnection();

        try {
            PreparedStatement statement = connection.prepareStatement(INSERT_QUERY);
            statement.setString(1, student.getID());
            statement.setString(2, student.getName());
            statement.setInt(3, student.getOld());
            statement.setFloat(4, student.getGPA());

            statement.executeUpdate();
            list.add(student);

            System.out.println("Insert Student successfully!");

        } catch (SQLException ex) {
            System.err.println("Insert Student failure!");
        }

        JDBC.closeConnection(connection);
    }

    public static void update(Student student) {
        Connection connection = JDBC.getConnection();

        try {
            PreparedStatement statement = connection.prepareStatement(UPDATE_QUERY);
            statement.setString(1, student.getName());
            statement.setInt(2, student.getOld());
            statement.setFloat(3, student.getGPA());
            statement.setString(4, student.getID());

            statement.executeUpdate();

            System.out.println("Update Student successfully!");

        } catch (SQLException ex) {
            System.err.println("Update Student failure!");
        }

        JDBC.closeConnection(connection);
    }

    public static void delete(Student student) {
        Connection connection = JDBC.getConnection();

        try {
            PreparedStatement statement = connection.prepareStatement(DELETE_QUERY);
            statement.setString(1, student.getID());

            statement.executeUpdate();
            list.remove(student);

            System.out.println("Delete Student successfully!");

        } catch (SQLException ex) {
            System.err.println("Delete Student failure!");
        }

        JDBC.closeConnection(connection);
    }

    public static List<Student> selectAll() {
        if (list == null) {
            list = new ArrayList<>();
        }

        list.clear();

        Connection connection = JDBC.getConnection();

        try {
            PreparedStatement statement = connection.prepareStatement(SELECT_ALL_QUERY);

            ResultSet result = statement.executeQuery();

            while (result.next()) {
                list.add(new Student(result.getString(1), result.getString(2), result.getInt(3), result.getFloat(4)));
            }

            System.out.println("Select all Students successfully!");

        } catch (SQLException ex) {
            System.err.println("Select all Students failure!");
        }

        JDBC.closeConnection(connection);

        return list;
    }
}
