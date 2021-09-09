package repositories;

import models.Professor;
import models.Scholarship;
import models.Student;
import utils.ConnectionUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class StudentRepo implements CrudRepository<Student>{

    ConnectionUtil cu = ConnectionUtil.getConnectionUtil();

    public Student add(Student student) {

        try (Connection conn = cu.getConnection()) {

            String sql = "insert into student values (?, ?, ?, ?, ?) returning *";

            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, student.getStudentID());
            ps.setString(2, student.getFirstName());
            ps.setString(3, student.getLastName());
            ps.setString(4, student.getStudentEmail());
            ps.setString(5, student.getStudentMajor());

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                student.setStudentID(rs.getInt("student_id"));
                return student;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public Student getById(Integer id) {

        try (Connection conn = cu.getConnection()) {
            String sql = "select * from student where student_id = ?";

            PreparedStatement ps = conn.prepareStatement(sql); // Setting up our SQL statement in this way helps prevent SQL Injection Attacks
            ps.setInt(1, id); // parameter Indexes start from 1 (NOT 0)

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                Student a = new Student();
                a.setStudentID(rs.getInt("student_id"));
                a.setFirstName(rs.getString("first_name"));
                a.setLastName(rs.getString("last_name"));
                a.setStudentEmail(rs.getString("email"));
                a.setStudentMajor(rs.getString("major"));
                return a;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public List<Student> getAll() {

        List<Student> students = new ArrayList<>();

        try (Connection conn = cu.getConnection()) {

            String sql = "select * from student";

            PreparedStatement ps = conn.prepareStatement(sql);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Student a = new Student(
                        rs.getInt("student_id"),
                        rs.getString("first_name"),
                        rs.getString("last_name"),
                        rs.getString("email"),
                        rs.getString("major")
                );

                students.add(a);
            }
            return students;

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void update(Student student) {

        try (Connection conn = cu.getConnection()) {

            String sql = "update student set first_name = ?, last_name = ?, email = ?, major = ? where student_id = ?";

            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, student.getFirstName());
            ps.setString(2, student.getLastName());
            ps.setString(3, student.getStudentEmail());
            ps.setString(4, student.getStudentMajor());
            ps.setInt(5, student.getStudentID());

            ps.execute();

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public void delete(Integer id) {
        try (Connection conn = cu.getConnection()) {

            String sql = "delete from student where student_id = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, id);
            ps.execute();

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
