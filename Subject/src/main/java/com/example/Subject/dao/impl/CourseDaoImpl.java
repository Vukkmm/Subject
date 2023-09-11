package com.example.Subject.dao.impl;

import com.example.Subject.dao.CourseDao;
import com.example.Subject.dao.HikariConfiguration;
import com.example.Subject.entity.Course;
import com.zaxxer.hikari.HikariConfig;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class CourseDaoImpl implements CourseDao {

    @Override
    public void create(int id, String name) {
        Connection connection = null;
        PreparedStatement ps = null;
        try {
            connection = HikariConfiguration.getInstance().getConnection();
            connection.setAutoCommit(false);
            ps = connection.prepareStatement("INSERT INTO courses (id, nameCourse) VALUES(?, ?)");
            ps.setInt(1, id);
            ps.setString(2, name);
            ps.executeUpdate();
            connection.commit();
            // System.out.println("Row affected: " + row);
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
    public Course findById(int id) {
        Course course = new Course();
        Connection connection = null;
        PreparedStatement pst = null;
        ResultSet resultSet = null;
        try {
            connection = HikariConfiguration.getInstance().getConnection();
            connection.setAutoCommit(false);
            pst = connection.prepareStatement("select * from courses where id = ?");
            pst.setInt(1, id);
            resultSet = pst.executeQuery();
            while (resultSet.next()) {
                course.setId(resultSet.getInt("id"));
                course.setNameCourse(resultSet.getString("nameCourse"));
            }

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
                    resultSet.close();
                    pst.close();
                    connection.close();
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            }
        }
        return course;
    }

    @Override
    public List<Course> getListCourse() {
        List<Course> courseList = new ArrayList<>();
        Connection connection = null;
        try {
            connection = HikariConfiguration.getInstance().getConnection();
            connection.setAutoCommit(false);
            PreparedStatement pst = connection.prepareStatement("SELECT * FROM courses");
            ResultSet resultSet = pst.executeQuery();
            while (resultSet.next()) {
                Course course = new Course();
                course.setId(resultSet.getInt("id"));
                course.setNameCourse(resultSet.getString("nameCourse"));
                courseList.add(course);
            }
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
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            }
        }
        return courseList;
    }

    @Override
    public void delete(int id) {
        Connection connection = null;
        try {
            connection = HikariConfiguration.getInstance().getConnection();
            connection.setAutoCommit(false);
            PreparedStatement pst = connection.prepareStatement("DELETE FROM courses WHERE id = ?");
            pst.setInt(1, id);
            int row = pst.executeUpdate();
            connection.commit();
            System.out.println("Row affected: " + row);
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
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }

    @Override
    public void update(int id, String name) {
        Connection connection = null;
        try {
            connection = HikariConfiguration.getInstance().getConnection();
            connection.setAutoCommit(false);
            PreparedStatement pst = connection.prepareStatement("UPDATE courses SET nameCourse = ? WHERE id = ?");
            pst.setInt(1, id);
            pst.setString(2, name);
            int row = pst.executeUpdate();
            connection.commit();
            System.out.println("Row affected: " + row);
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
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }


}
