package com.example.Subject.dao.impl;

import com.example.Subject.dao.HikariConfiguration;
import com.example.Subject.dao.StudentDao;
import com.example.Subject.entity.Course;
import com.example.Subject.entity.Student;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class StudentDaoImpl implements StudentDao {

    @Override
    public void createStudent(int id, String name, String phoneNumber, String address, int courseId) {
        Student student = new Student();
        Connection connection = null;
        //Biến này sẽ được sử dụng để lưu trữ một kết nối đến cơ sở dữ liệu
        PreparedStatement ps = null;
        //Biến này sẽ được sử dụng để chuẩn bị và thực hiện một truy vấn SQL
        try {
            connection = HikariConfiguration.getInstance().getConnection();
            PreparedStatement checkCourse = connection.prepareStatement("SELECT COUNT(*) FROM courses WHERE id = ?");
            checkCourse.setInt(1, courseId);
            ResultSet rs = checkCourse.executeQuery();
            rs.next();
            int counts = rs.getInt(1);
            rs.close();
            checkCourse.close();
            if (counts == 0) {
                System.out.println("Course ID " + courseId + " không tồn tại");
                connection.rollback();
            }
            ps = connection.prepareStatement("INSERT INTO students (id, name, phoneNumber, address, courseId) VALUES(?, ?, ?, ?, ?)");
            ps.setInt(1, id);
            ps.setString(2, name);
            ps.setString(3, phoneNumber);
            ps.setString(4, address);
            ps.setInt(5, courseId);
            int row = ps.executeUpdate();
            System.out.println("row affected: " + row);

            connection.commit();
        } catch (SQLException e) {
            if (connection != null) {
                try {
                    connection.rollback();
                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                }
            }
            e.printStackTrace();
        } finally {
            if (Objects.nonNull(connection)) {
                try {
                    connection.close();
                    ps.close();
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }

    @Override
    public Student findById(int id) {
        Student student = new Student();
        Connection connection = null;
        PreparedStatement pts = null;
        ResultSet resultSet = null;
        try {
            connection = HikariConfiguration.getInstance().getConnection();
            pts = connection.prepareStatement("select * from students where id = ?");
            pts.setInt(1, id);
            resultSet = pts.executeQuery();
            while (resultSet.next()) {
                student.setId(resultSet.getInt("id"));
                student.setName(resultSet.getString("name"));
                student.setPhoneNumber(resultSet.getString("phoneNumber"));
                student.setAddress(resultSet.getString("address"));
            }
            List<Course> courseList = new ArrayList<>();

        } catch (SQLException e) {
            if (connection != null) {
                try {
                    connection.rollback();
                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                }
            }
            e.printStackTrace();
        } finally {
            if (Objects.nonNull(connection)) {
                try {
                    connection.close();
                    pts.close();
                    resultSet.close();
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            }
        }
        return student;
    }

    @Override
    public List<Student> getListStudent() {
        List<Student> studentList = new ArrayList<>();
        Connection connection = null;
        PreparedStatement pts = null;
        ResultSet resultSet = null;
        try {
            connection = HikariConfiguration.getInstance().getConnection();
            pts = connection.prepareStatement("SELECT * FROM students");
            resultSet = pts.executeQuery();
            while (resultSet.next()) {
                if (resultSet.next()) {
                    int id = resultSet.getInt("id");
                    String name = resultSet.getString("name");
                    String phoneNumber = resultSet.getString("phoneNumber");
                    String address = resultSet.getString("address");
                    Student student = new Student();
                }
            }
        } catch (SQLException e) {

        } finally {

        }
        return null;
    }


}
