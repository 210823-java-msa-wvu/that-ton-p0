package repositories;

import models.ProfUser;
import models.StudentUser;
import utils.ConnectionUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class StudentUserRepo implements CrudRepository<StudentUser>{

    ConnectionUtil cu = ConnectionUtil.getConnectionUtil();

    public StudentUser add(StudentUser studentUser) {

        try (Connection conn = cu.getConnection()) {

            String sql = "insert into studentuser values (?, ?, ?) returning *";

            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, studentUser.getStudentID());
            ps.setString(2, studentUser.getStudentEmail());
            ps.setString(3, studentUser.getStudentPw());

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                studentUser.setStudentID(rs.getInt("student_id"));
                return studentUser;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public StudentUser getById(Integer id) {
        return null;
    }

    public StudentUser getByUsername(String username) {

        try (Connection conn = cu.getConnection()) {

            String sql = "select * from studentuser where email = ?";

            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, username);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                StudentUser u = new StudentUser(
                        rs.getInt("student_id"),
                        rs.getString("email"),
                        rs.getString("password")
                );
                return u;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    @Override
    public List<StudentUser> getAll() {
        return null;
    }

    @Override
    public void update(StudentUser studentUser) {

    }

    @Override
    public void delete(Integer id) {

    }
}
