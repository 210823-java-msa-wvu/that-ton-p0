package repositories;

import models.Student;
import models.Tuition;
import utils.ConnectionUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TuitionRepo implements CrudRepository<Tuition>{

    ConnectionUtil cu = ConnectionUtil.getConnectionUtil();

    public Tuition add(Tuition tuition) {

        try (Connection conn = cu.getConnection()) {

            String sql = "insert into tuition values (?, ?, ?) returning *";

            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, tuition.getStudentID());
            ps.setDouble(2, tuition.getTuition());
            ps.setDouble(3, tuition.getBalance());

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                tuition.setStudentID(rs.getInt("student_id"));
                return tuition;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }


    public Tuition getById(Integer id) {

        try (Connection conn = cu.getConnection()) {
            String sql = "select * from tuition where student_id = ?";

            PreparedStatement ps = conn.prepareStatement(sql); // Setting up our SQL statement in this way helps prevent SQL Injection Attacks
            ps.setInt(1, id); // parameter Indexes start from 1 (NOT 0)

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                Tuition a = new Tuition();
                a.setStudentID(rs.getInt("student_id"));
                a.setTuition(rs.getDouble("tuition"));
                a.setBalance(rs.getDouble("balance"));
                return a;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public List<Tuition> getAll() {

        List<Tuition> tuitions = new ArrayList<>();

        try (Connection conn = cu.getConnection()) {

            String sql = "select * from tuition";

            PreparedStatement ps = conn.prepareStatement(sql);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Tuition a = new Tuition(
                        rs.getInt("student_id"),
                        rs.getDouble("tuition"),
                        rs.getDouble("balance")
                );

                tuitions.add(a);
            }
            return tuitions;

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void update(Tuition tuition) {

    }

    public void updateTuition(Tuition ut) {

        try (Connection conn = cu.getConnection()) {

            String sql = "update tuition set tuition = ? where student_id = ?";

            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setDouble(1, ut.getTuition());
            ps.setInt(2, ut.getStudentID());

            ps.execute();

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public void payTuition(Tuition pt) {

        try (Connection conn = cu.getConnection()) {

            String sql = "update tuition set balance = ? where student_id = ?";

            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setDouble(1, pt.getBalance());
            ps.setInt(2, pt.getStudentID());

            ps.execute();

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void delete(Integer id) {

    }
}
